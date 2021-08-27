/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author MK
 */
public class ReservationValidationTest {
    
    public ReservationValidationTest() {
    }
    
    

    /**
     * Test of correctDates method, of class ReservationValidation.
     */
    @Test
    public void testCorrectDates() throws ParseException {
        System.out.println("correctDates");
        Reservation res;
        Room room = new Room();
        room.setRoomNumber(104);
        Employee employee = new Employee("milica", "milica", "Milica Klaric");
        Guest guest = new Guest("6532652362526","Milan","Cekic","m.cekic@gmailc.com");
        
        res = new Reservation(4,room,guest,employee,null,null,"no");
        res.setCheckIn(new SimpleDateFormat("yyyy-MM-dd").parse("2021-08-20"));
        res.setCheckOut(new SimpleDateFormat("yyyy-MM-dd").parse("2021-08-30"));
        res.setTotal(195.0);
        boolean expResult = true;
        boolean result = ReservationValidation.correctDates(res);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testWrongDates() throws ParseException, InterruptedException {
        System.out.println("correctDates");
        Reservation res;
        Room room = new Room();
        room.setRoomNumber(104);
        Employee employee = new Employee("milica", "milica", "Milica Klaric");
        Guest guest = new Guest("6532652362526","Milan","Cekic","m.cekic@gmailc.com");
        
        res = new Reservation(4,room,guest,employee,null,null,"no");
        
        res.setCheckIn(new SimpleDateFormat("yyyy-MM-dd").parse("2021-08-20"));
        res.setCheckOut(new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-30"));
        
        
        res.setTotal(195.0);
        boolean expResult = false;
        boolean result = ReservationValidation.correctDates(res);
        assertEquals(expResult, result);
    }

    /**
     * Test of allFieldsAreRequired method, of class ReservationValidation.
     */
    @Test
    public void testAllFieldsAreRequired() {
        System.out.println("allFieldsAreRequired");
        Reservation res;
        Room room = new Room();
        room.setRoomNumber(104);
        Employee employee = new Employee("milica", "milica", "Milica Klaric");
        Guest guest = new Guest("6532652362526","Milan","Cekic","m.cekic@gmailc.com");
        Date checkIn = new Date(2021, 5, 22);
        Date checkOut = new Date(2021, 5, 22);
        res = new Reservation(4,room,guest,employee,checkIn,checkOut,"no");
        res.setTotal(195.0);
        boolean expResult = true;
        boolean result = ReservationValidation.allFieldsAreRequired(res);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAllFieldsAreRequiredRoomNull() {
        System.out.println("allFieldsAreRequired");
        Reservation res;
        Room room = null;
        Employee employee = new Employee("milica", "milica", "Milica Klaric");
        Guest guest = new Guest("6532652362526","Milan","Cekic","m.cekic@gmailc.com");
        Date checkIn = new Date(2021, 5, 22);
        Date checkOut = new Date(2021, 5, 22);
        res = new Reservation(4,room,guest,employee,checkIn,checkOut,"no");
        res.setTotal(195.0);
        boolean expResult = false;
        boolean result = ReservationValidation.allFieldsAreRequired(res);
        assertEquals(expResult, result);
    }
    @Test
    public void testAllFieldsAreRequiredGuestNull() {
        System.out.println("allFieldsAreRequired");
        Reservation res;
        Room room = new Room();
        room.setRoomNumber(104);
        Employee employee = new Employee("milica", "milica", "Milica Klaric");
        Guest guest = null;
        Date checkIn = new Date(2021, 5, 22);
        Date checkOut = new Date(2021, 5, 22);
        res = new Reservation(4,room,guest,employee,checkIn,checkOut,"no");
        res.setTotal(195.0);
        boolean expResult = false;
        boolean result = ReservationValidation.allFieldsAreRequired(res);
        assertEquals(expResult, result);
    }
    @Test
    public void testAllFieldsAreRequiredEmployeeNull() {
        System.out.println("allFieldsAreRequired");
        Reservation res;
        Room room = new Room();
        room.setRoomNumber(104);
        Employee employee = null;
        Guest guest = new Guest("6532652362526","Milan","Cekic","m.cekic@gmailc.com");
        Date checkIn = new Date(2021, 5, 22);
        Date checkOut = new Date(2021, 5, 22);
        res = new Reservation(4,room,guest,employee,checkIn,checkOut,"no");
        res.setTotal(195.0);
        boolean expResult = false;
        boolean result = ReservationValidation.allFieldsAreRequired(res);
        assertEquals(expResult, result);
    }
    @Test
    public void testAllFieldsAreRequiredCheckInNull() {
        System.out.println("allFieldsAreRequired");
        Reservation res;
        Room room = new Room();
        room.setRoomNumber(104);
        Employee employee = new Employee("milica", "milica", "Milica Klaric");
        Guest guest = new Guest("6532652362526","Milan","Cekic","m.cekic@gmailc.com");
        Date checkIn = null;
        Date checkOut = new Date(2021, 5, 22);
        res = new Reservation(4,room,guest,employee,checkIn,checkOut,"no");
        res.setTotal(195.0);
        boolean expResult = false;
        boolean result = ReservationValidation.allFieldsAreRequired(res);
        assertEquals(expResult, result);
    }
    @Test
    public void testAllFieldsAreRequiredCheckOutNull() {
        System.out.println("allFieldsAreRequired");
        Reservation res;
        Room room = new Room();
        room.setRoomNumber(104);
        Employee employee = new Employee("milica", "milica", "Milica Klaric");
        Guest guest = new Guest("6532652362526","Milan","Cekic","m.cekic@gmailc.com");
        Date checkIn = new Date(2021, 5, 22);
        Date checkOut = null;
        res = new Reservation(4,room,guest,employee,checkIn,checkOut,"no");
        res.setTotal(195.0);
        boolean expResult = false;
        boolean result = ReservationValidation.allFieldsAreRequired(res);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAllFieldsAreRequiredBreakfastNull() {
        System.out.println("allFieldsAreRequired");
        Reservation res;
        Room room = new Room();
        room.setRoomNumber(104);
        Employee employee = new Employee("milica", "milica", "Milica Klaric");
        Guest guest = new Guest("6532652362526","Milan","Cekic","m.cekic@gmailc.com");
        Date checkIn = new Date(2021, 5, 22);
        Date checkOut = null;
        res = new Reservation(4,room,guest,employee,checkIn,checkOut,null);
        res.setTotal(195.0);
        boolean expResult = false;
        boolean result = ReservationValidation.allFieldsAreRequired(res);
        assertEquals(expResult, result);
    }
    
    
}
