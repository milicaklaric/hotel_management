/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author MK
 */
public class GuestValidation {
    
    public static boolean allFieldsAreRequired(Guest guest){
        return guest.getPassportNumber() != null &&
                guest.getFirstName() != null &&
                guest.getLastName() != null &&
                guest.getContactInfo() != null;
    }
    
}
