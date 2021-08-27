/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author MK
 */

public class ReservationTest {
    Reservation instance;
    
    /**
     * Pre svakog testa se izvrašava
     */
    @BeforeEach
    public void setUp() {
        instance = new Reservation();
        Room room = new Room();
        room.setRoomNumber(104);
        Employee employee = new Employee("milica", "milica", "Milica Klaric");
        Guest guest = new Guest("6532652362526","Milan","Cekic","m.cekic@gmailc.com");
        Date checkIn = new Date(2021, 5, 22);
        Date checkOut = new Date(2021, 5, 22);
        instance = new Reservation(4,room,guest,employee,checkIn,checkOut,"no");
        instance.setTotal(195.0);
    }
    
    /**
     * Posle svakog testa se izvrašava
     */
    @AfterEach
    public void tearDown() {
        instance = null;
    }
    /**
     * Test of TableName method, of class Reservation.
     */
    @Test
    public void testTableName() {
        instance = new Reservation();
        System.out.println("TableName");
        String expResult = "Reservation";
        String result = instance.TableName();
        assertEquals(expResult, result);
    }

    /**
     * Test of Join method, of class Reservation.
     */
    @Test
    public void testJoin() {
        instance = new Reservation();
        System.out.println("Join");
        String expResult = " JOIN room using(roomNumber) join roomtype using(TypeID) join guest on reservation.Guest = guest.PassportNumber";
        String result = instance.Join();
        assertEquals(expResult, result);
    }

    /**
     * Test of Where method, of class Reservation.
     */
    @Test
    public void testWhere() {
        instance = new Reservation();
        System.out.println("Where");
        String expResult = "";
        String result = instance.Where();
        assertEquals(expResult, result);
    }

    /**
     * Test of Update method, of class Reservation.
     */
    @Test
    public void testUpdate() {
        System.out.println("Update");
        instance.setId(5);
        String expResult = " WHERE id = " + instance.getId();
        String result = instance.Update();
        assertEquals(expResult, result);
    }

    /**
     * Test of Insert method, of class Reservation.
     */
    @Test
    public void testInsert() {
        System.out.println("Insert");
        String expResult = "4, 104, '6532652362526', datetime('3921-06-22'), datetime('3921-06-22'), 'milica', 'no', 195.0";
        String result = instance.Insert();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of ReturnList method, of class Reservation.
     */
    @Test
    public void testReturnList() {
        System.out.println("ReturnList");
        ResultSet rs = null;
        assertNull(instance.ReturnList(rs));
    }

    /**
     * Test of GetRecord method, of class Reservation.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetRecord() throws Exception {
        instance = new Reservation();
        System.out.println("GetRecord");
        ResultSet rs = null;
        assertThrows(NullPointerException.class, () -> {
        instance.GetRecord(rs);
    });
    }

    /**
     * Test of getId method, of class Reservation.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        int expResult = 4;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRoom method, of class Reservation.
     */
    @Test
    public void testGetRoom() {
        System.out.println("getRoom");;
        Room result = instance.getRoom();
        assertEquals(104, result.getRoomNumber());
    }

    /**
     * Test of getGuest method, of class Reservation.
     */
    @Test
    public void testGetGuest() {
        System.out.println("getGuest");
        Guest result = instance.getGuest();
        assertEquals("6532652362526", result.getPassportNumber());
    }

    /**
     * Test of getEmployee method, of class Reservation.
     */
    @Test
    public void testGetEmployee() {
        System.out.println("getEmployee");
        Employee result = instance.getEmployee();
        assertEquals("Milica Klaric", result.getName());
    }

    /**
     * Test of getCheckIn method, of class Reservation.
     */
    @Test
    public void testGetCheckIn() {
        System.out.println("getCheckIn");
        Date expResult = new Date(2021, 5, 22);
        Date result = instance.getCheckIn();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCheckOut method, of class Reservation.
     */
    @Test
    public void testGetCheckOut() {
        System.out.println("getCheckOut");
        Date expResult = new Date(2021, 5, 22);
        Date result = instance.getCheckOut();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBreakfast method, of class Reservation.
     */
    @Test
    public void testGetBreakfast() {
        System.out.println("getBreakfast");
        String expResult = "no";
        String result = instance.getBreakfast();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTotal method, of class Reservation.
     */
    @Test
    public void testGetTotal() {
        System.out.println("getTotal");
        double expResult = 195.0;
        double result = instance.getTotal();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Reservation.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        instance.setId(id);
        assertEquals(0, instance.getId());
    }

    /**
     * Test of setRoom method, of class Reservation.
     */
    @Test
    public void testSetRoom() {
        System.out.println("setRoom");
        Room roomNull = null;
        Room room1 = new Room();
        room1.setRoomNumber(204);
        instance.setRoom(room1);
        assertEquals(room1.getRoomNumber(), instance.getRoom().getRoomNumber());
    }

    /**
     * Test of setGuest method, of class Reservation.
     */
    @Test
    public void testSetGuest() {
        System.out.println("setGuest");
        Guest guestNew = new Guest("6532652362526","Emilija","Kartalija","e.kartalija@gmailc.com");
        instance.setGuest(guestNew);
        assertEquals(guestNew.getPassportNumber(), instance.getGuest().getPassportNumber());
    }

    /**
     * Test of setEmployee method, of class Reservation.
     */
    @Test
    public void testSetEmployee() {
        System.out.println("setEmployee");
        Employee employeeNew = new Employee("uros", "bajic", "Uros Bajic");
        instance.setEmployee(employeeNew);
        assertEquals(employeeNew.getName(), instance.getEmployee().getName());
    }

    /**
     * Test of setCheckIn method, of class Reservation.
     */
    @Test
    public void testSetCheckIn() {
        System.out.println("setCheckIn");
        Date checkInNew = new Date(2021, 5, 22);
        instance.setCheckIn(checkInNew);
        assertEquals(checkInNew, instance.getCheckIn());
    }

    /**
     * Test of setCheckOut method, of class Reservation.
     */
    @Test
    public void testSetCheckOut() {
        System.out.println("setCheckOut");
        Date checkOutNew = new Date(2021, 5, 27);
        instance.setCheckOut(checkOutNew);
        assertEquals(checkOutNew, instance.getCheckOut());
    }

    /**
     * Test of setBreakfast method, of class Reservation.
     */
    @Test
    public void testSetBreakfast() {
        System.out.println("setBreakfast");
        String breakfast = "yes";
        instance.setBreakfast(breakfast);
        assertEquals(breakfast, instance.getBreakfast());
    }

    /**
     * Test of setTotal method, of class Reservation.
     */
    @Test
    public void testSetTotal() {
        System.out.println("setTotal");
        double total = 207.5;
        instance.setTotal(total);
        assertEquals(total, instance.getTotal());
    }
    
}
