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
import domen.RoomType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        controller = Controller.getInstanceForTests();
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
        controller = Controller.getInstanceForTests();
        assertNotNull(controller);
        
        Controller controller2 = Controller.getInstanceForTests();
        
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
        assertEquals(4,result.size());
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
        ArrayList<GeneralDomainObject> result;
        RoomType rt = new RoomType(1, "", "", 0, 0);
        Room r = new Room(rt, 0, "", true);
        result = controller.getRooms(r);
        assertNotNull(result);
        assertEquals(2,result.size());
    }

    /**
     * Test of saveReservation method, of class Controller.
     */
    @Test
    public void testSaveReservation() throws ParseException {
        System.out.println("saveReservation");
        
        Reservation res;
        Room room = new Room();
        room.setRoomNumber(104);
        Employee employee = new Employee("milica", "milica", "Milica Klaric");
        Guest guest = new Guest("0012345678","Milan","Cekic","m.cekic@gmailc.com");
        res = new Reservation(44,room,guest,employee,null,null,"no");
        res.setCheckIn(new SimpleDateFormat("yyyy-MM-dd").parse("2021-08-20"));
        res.setCheckOut(new SimpleDateFormat("yyyy-MM-dd").parse("2021-08-30"));
        res.setTotal(195.0);
        
        boolean saved = controller.saveReservation(res);
        
        assertTrue(saved);
        
        ArrayList<GeneralDomainObject> reservations = controller.getReservations();
        
        assertNotNull(reservations);
        assertTrue(reservations.contains(res));
        
        controller.deleteReservation(res);
       
    }

    /**
     * Test of deleteReservation method, of class Controller.
     */
    @Test
    public void testDeleteReservation() throws ParseException {
        System.out.println("deleteReservation");
        
        Reservation res;
        Room room = new Room();
        room.setRoomNumber(104);
        Employee employee = new Employee("milica", "milica", "Milica Klaric");
        Guest guest = new Guest("005209853","Katarina","lica","k.ilic@gmailc.com");
        
        res = new Reservation(44,room,guest,employee,null,null,"no");
        res.setCheckIn(new SimpleDateFormat("yyyy-MM-dd").parse("2021-08-20"));
        res.setCheckOut(new SimpleDateFormat("yyyy-MM-dd").parse("2021-08-30"));
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
