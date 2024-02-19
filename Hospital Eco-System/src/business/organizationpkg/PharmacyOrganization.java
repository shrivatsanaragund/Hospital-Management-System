/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organizationpkg;

import business.rolepkg.AdminRole;
import business.rolepkg.PharmacyAdminRole;
import business.rolepkg.Role;
import java.util.ArrayList;

/**
 *
 * @author tejageetla
 */
public class PharmacyOrganization extends Organization{
    
    public PharmacyOrganization()
    {
        super(Organization.Type.Pharmacy.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new PharmacyAdminRole());
        return roles;
    }
    
}
