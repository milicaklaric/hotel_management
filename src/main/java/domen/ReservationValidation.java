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
public class ReservationValidation {
    
    public static boolean correctDates(Reservation res){
        return !res.getCheckIn().before(res.getCheckIn());
    }

    public static boolean allFieldsAreRequired(Reservation res) {
        return res.getBreakfast() != null &&
                res.getCheckIn() != null &&
                res.getCheckOut()!= null &&
                res.getEmployee()!= null &&
                res.getGuest()!= null &&
                res.getRoom()!= null;
    }
    
}
