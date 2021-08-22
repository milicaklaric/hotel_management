/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dbBroker.Broker;
import domen.Employee;
import domen.GeneralDomainObject;
import domen.Guest;
import domen.Reservation;
import domen.Room;
import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author MK
 */
public class ControllerTest {
    
    private static Controller controller;
    private Broker broker;
    
    public ControllerTest(){
        controller = Controller.getInstance();
        broker = new Broker();
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class Controller.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        controller = Controller.getInstance();
        assertNotNull(controller);
        
        Controller controller2 = Controller.getInstance();
        
        assertTrue(controller.equals(controller2));
    }

    /**
     * Test of getEmployee method, of class Controller.
     */
    @Test
    public void testGetEmployeeDoesNotExist() {
        System.out.println("getEmployee");
        Employee result = controller.getEmployee("nevena", "klaric");
        assertNull(result);
    }
    
    @Test
    public void testGetEmployeeWrongPassword() {
        System.out.println("getEmployee");
        Employee result = controller.getEmployee("milica", "milic");
        assertNull(result);
    }
    
    @Test
    public void testGetEmployee() {
        System.out.println("getEmployee");
        Employee result = controller.getEmployee("milica", "milica");
        Employee expected = new Employee("milica", "milica", "Milica Klaric");
        assertEquals(expected.getName(),result.getName());
    }

    /**
     * Test of getReservations method, of class Controller.
     */
    @Test
    public void testGetReservations() {
        System.out.println("getReservations");
        ArrayList<GeneralDomainObject> result = controller.getReservations();
        assertNotNull(result);
        assertEquals(3,result.size());
    }

    /**
     * Test of getRoomTypes method, of class Controller.
     */
    @Test
    public void testGetRoomTypes() {
        System.out.println("getRoomTypes");
        ArrayList<GeneralDomainObject> result = controller.getRoomTypes();
        assertNotNull(result);
        assertEquals(5,result.size());
    }

    /**
     * Test of getRooms method, of class Controller.
     */
    @Test
    public void testGetRooms() {
        System.out.println("getRooms");
        ArrayList<GeneralDomainObject> result = controller.getReservations();
        assertNotNull(result);
        assertEquals(3,result.size());
    }

    /**
     * Test of saveReservation method, of class Controller.
     */
    @Test
    public void testSaveReservation() {
        System.out.println("saveReservation");
        
        Reservation res = new Reservation();
        Room room = new Room();
        room.setRoomNumber(104);
        Employee employee = new Employee("milica", "milica", "Milica Klaric");
        Guest guest = new Guest("0012345678","Milan","Cekic","m.cekic@gmailc.com");
        Date checkIn = new Date(2021, 5, 22);
        Date checkOut = new Date(2021, 5, 28);
        res = new Reservation(44,room,guest,employee,checkIn,checkOut,"no");
        res.setTotal(195.0);
        
        boolean saved = controller.saveReservation(res);
        
        assertTrue(saved);
        
        ArrayList<GeneralDomainObject> reservations = controller.getReservations();
        
        assertNotNull(reservations);
        assertTrue(reservations.contains(res));
       
    }

    /**
     * Test of deleteReservation method, of class Controller.
     */
    @Test
    public void testDeleteReservation() {
        System.out.println("deleteReservation");
        Reservation res ;
        Room room = new Room();
        room.setRoomNumber(104);
        Employee employee = new Employee("milica", "milica", "Milica Klaric");
        Guest guest = new Guest("12345647891011","Milan","Cekic","m.cekic@gmailc.com");
        Date checkIn = new Date(2021, 5, 22);
        Date checkOut = new Date(2021, 5, 28);
        res = new Reservation(55,room,guest,employee,checkIn,checkOut,"no");
        res.setTotal(195.0);
        
        boolean saved = controller.saveReservation(res);
        assertTrue(saved);
        
        boolean deleted = controller.deleteReservation(res);
        assertTrue(deleted);
        
        ArrayList<GeneralDomainObject> reservations = controller.getReservations();
        
        assertNotNull(reservations);
        assertFalse(reservations.contains(res));
    }
    
}
