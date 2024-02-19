/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.DB4OUtil;

import business.ConfigureASystem;
import business.EcoSystem;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ta.TransparentPersistenceSupport;
import java.util.ConcurrentModificationException;

/**
 *
 * @author tejageetla
 */
public class DB4OUtil {
    //private static final String FILENAME = System.getProperty("user.dir") + "/DataBank.db4o";  
    //private static final String FILENAME = "/Users/sameersdeshpande/Working code2/DB40/DataBank8.db4o";

    //private static final String FILENAME = "/Users/sameersdeshpande/hms/Working-code2/DB40/DataBank8.db4o";
    private static final String FILENAME = "/Users/shrivatsanaragund/hms/Working-code2/DB40/DataBank8.db4o";
    private static DB4OUtil dB4OUtil;

    public static synchronized DB4OUtil getInstance() {
        if (dB4OUtil == null) {
            dB4OUtil = new DB4OUtil();
        }
        return dB4OUtil;
    }

    protected static synchronized void shutdown(ObjectContainer conn) {
        if (conn != null) {
            conn.close();
        }
    }

    private ObjectContainer createConnection() {
        try {
            EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
            config.common().add(new TransparentPersistenceSupport());

            config.common().activationDepth(Integer.MAX_VALUE);

            config.common().updateDepth(Integer.MAX_VALUE);

            config.common().objectClass(EcoSystem.class).cascadeOnUpdate(true);

            return Db4oEmbedded.openFile(config, FILENAME);
        } catch (Exception ex) {
            //    System.out.print(ex.getMessage());
        }
        return null;
    }

    public synchronized void storeSystem(EcoSystem system) {
        try {

            ObjectContainer conn = createConnection();
            conn.store(system);
            conn.commit();
            conn.close();

        } catch (ConcurrentModificationException cme) {

        }
    }

    public EcoSystem retrieveSystem() {
        ObjectContainer conn = createConnection();
        ObjectSet<EcoSystem> systems = conn.query(EcoSystem.class);

        EcoSystem system;
        if (systems.size() == 0) {
            system = ConfigureASystem.configure();
        } else {
            system = (EcoSystem) systems.get(systems.size() - 1);
        }
        conn.close();
        return system;
    }
}
