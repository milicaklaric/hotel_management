/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author MK
 */
public class RoomTest {
    
    Room instance;
    
    @BeforeEach
    public void setUp() {
        RoomType type = new RoomType(1, "Studio", "some features", 20.0, 2);
        instance = new Room(type, 100, "beach", true);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of TableName method, of class Room.
     */
    @Test
    public void testTableName() {
        RoomType type = new RoomType(1, "Studio", "some features", 20.0, 2);
        instance = new Room(type, 100, "beach", true);
        System.out.println("TableName");
        String expResult = "Room";
        String result = instance.TableName();
        assertEquals(expResult, result);
    }

    /**
     * Test of Join method, of class Room.
     */
    @Test
    public void testJoin() {
        RoomType type = new RoomType(1, "Studio", "some features", 20.0, 2);
        instance = new Room(type, 100, "beach", true);
        System.out.println("Join");
        String expResult = "";
        String result = instance.Join();
        assertEquals(expResult, result);
    }

    /**
     * Test of Where method, of class Room.
     */
    @Test
    public void testWhere() {
        RoomType type = new RoomType(1, "Studio", "some features", 20.0, 2);
        instance = new Room(type, 100, "beach", true);
        System.out.println("Where");
        String expResult = " WHERE TypeID = " + instance.getType().getTypeID();
        String result = instance.Where();
        assertEquals(expResult, result);
    }

    /**
     * Test of Update method, of class Room.
     */
    @Test
    public void testUpdate() {
        RoomType type = new RoomType(1, "Studio", "some features", 20.0, 2);
        instance = new Room(type, 100, "beach", true);
        System.out.println("Update");
        String expResult = "";
        String result = instance.Update();
        assertEquals(expResult, result);
    }

    /**
     * Test of Insert method, of class Room.
     */
    @Test
    public void testInsert() {
        RoomType type = new RoomType(1, "Studio", "some features", 20.0, 2);
        instance = new Room(type, 100, "beach", true);
        System.out.println("Insert");
        String expResult = "";
        String result = instance.Insert();
        assertEquals(expResult, result);
    }

    /**
     * Test of ReturnList method, of class Room.
     */
    @Test
    public void testReturnList() {
        RoomType type = new RoomType(1, "Studio", "some features", 20.0, 2);
        instance = new Room(type, 100, "beach", true);
        System.out.println("ReturnList");
        ResultSet rs = null;
        assertNull(instance.ReturnList(rs));
    }

    /**
     * Test of GetRecord method, of class Room.
     */
    @Test
    public void testGetRecord()  {
        RoomType type = new RoomType(1, "Studio", "some features", 20.0, 2);
        instance = new Room(type, 100, "beach", true);
        System.out.println("GetRecord");
        ResultSet rs = null;
        assertThrows(java.lang.NullPointerException.class,
				() -> instance.GetRecord(rs));
    }

    /**
     * Test of equals method, of class Room.
     * @param roomNumber1 room number for first room
     * @param roomNumber2 room number for second room
     * @param result are rooms equal based on room number
     */
    @ParameterizedTest
	@CsvSource({
		"100, 100, true",
		"100, 10, false",
	})
    public void testEquals(int roomNumber1, int roomNumber2, boolean result) {
        System.out.println("equals");
        Room room1 = new Room();
        room1.setRoomNumber(roomNumber1);
        
        Room room2 = new Room();
        room2.setRoomNumber(roomNumber2);
        
        assertEquals(result, room1.equals(room2));
        
        
    }

    /**
     * Test of getType method, of class Room.
     */
    @Test
    public void testGetType() {
        RoomType type = new RoomType(1, "Studio", "some features", 20.0, 2);
        instance = new Room(type, 100, "beach", true);
        System.out.println("getType");
        RoomType result = instance.getType();
        assertEquals(1, result.getTypeID());
    }

    /**
     * Test of getRoomNumber method, of class Room.
     */
    @Test
    public void testGetRoomNumber() {
        RoomType type = new RoomType(1, "Studio", "some features", 20.0, 2);
        instance = new Room(type, 100, "beach", true);
        System.out.println("getRoomNumber");
        int expResult = 100;
        int result = instance.getRoomNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getView method, of class Room.
     */
    @Test
    public void testGetView() {
        RoomType type = new RoomType(1, "Studio", "some features", 20.0, 2);
        instance = new Room(type, 100, "beach", true);
        System.out.println("getView");
        String expResult = "beach";
        String result = instance.getView();
        assertEquals(expResult, result);
    }

    /**
     * Test of isAvailable method, of class Room.
     */
    @Test
    public void testIsAvailable() {
        RoomType type = new RoomType(1, "Studio", "some features", 20.0, 2);
        instance = new Room(type, 100, "beach", true);
        System.out.println("isAvailable");
        boolean expResult = true;
        boolean result = instance.isAvailable();
        assertEquals(expResult, result);
    }

    /**
     * Test of setType method, of class Room.
     */
    @Test
    public void testSetTypeNull() {
        RoomType type = new RoomType(1, "Studio", "some features", 20.0, 2);
        instance = new Room(type, 100, "beach", true);
        System.out.println("setTypeNull");
        RoomType typeNull = null;
        instance.setType(typeNull);
        assertNull(instance.getType());
        
    }
    
    @Test
    public void testSetType() {
        RoomType type = new RoomType(1, "Studio", "some features", 20.0, 2);
        instance = new Room(type, 100, "beach", true);
        System.out.println("setType");
        RoomType typeNew = new RoomType(1, "Studio", "some features", 20.0, 2);
        instance.setType(typeNew);
        assertEquals(typeNew.getTypeID(), instance.getType().getTypeID());
        
    }

    /**
     * Test of setRoomNumber method, of class Room.
     */
    @Test
    public void testSetRoomNumber() {
        
        RoomType type = new RoomType(1, "Studio", "some features", 20.0, 2);
        instance = new Room(type, 100, "beach", true);
        System.out.println("setRoomNumber");
        int roomNumber = 200;
        instance.setRoomNumber(roomNumber);
        assertEquals(roomNumber, instance.getRoomNumber());
    }

    /**
     * Test of setView method, of class Room.
     */
    @Test
    public void testSetView() {
        RoomType type = new RoomType(1, "Studio", "some features", 20.0, 2);
        instance = new Room(type, 100, "beach", true);
        System.out.println("setView");
        String view = "garden";
        instance.setView(view);
        assertEquals(view, instance.getView());
    }

    /**
     * Test of setAvailable method, of class Room.
     */
    @Test
    public void testSetAvailable() {
        RoomType type = new RoomType(1, "Studio", "some features", 20.0, 2);
        instance = new Room(type, 100, "beach", true);
        System.out.println("setAvailable");
        boolean available = false;
        instance.setAvailable(available);
        assertEquals(available, instance.isAvailable());
    }
    
}
