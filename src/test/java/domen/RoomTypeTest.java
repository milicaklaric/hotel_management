/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author MK
 */
public class RoomTypeTest {
    
    RoomType instance;
  
    
    @BeforeEach
    public void setUp() {
        instance = new RoomType(1, "Double", "Featires", 15.0, 4);
                
    }
    
    @AfterEach
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of TableName method, of class RoomType.
     */
    @Test
    public void testTableName() {
        instance = new RoomType(1, "Double", "Featires", 15.0, 4);
        System.out.println("TableName");
        String expResult = "RoomType";
        String result = instance.TableName();
        assertEquals(expResult, result);
    }

    /**
     * Test of Join method, of class RoomType.
     */
    @Test
    public void testJoin() {
        instance = new RoomType(1, "Double", "Featires", 15.0, 4);
        System.out.println("Join");
        String expResult = "";
        String result = instance.Join();
        assertEquals(expResult, result);
    }

    /**
     * Test of Where method, of class RoomType.
     */
    @Test
    public void testWhere() {
        instance = new RoomType(1, "Double", "Featires", 15.0, 4);
        System.out.println("Where");
        String expResult = "";
        String result = instance.Where();
        assertEquals(expResult, result);
    }

    /**
     * Test of Update method, of class RoomType.
     */
    @Test
    public void testUpdate() {
        instance = new RoomType(1, "Double", "Featires", 15.0, 4);
        System.out.println("Update");
        String expResult = "";
        String result = instance.Update();
        assertEquals(expResult, result);
    }

    /**
     * Test of Insert method, of class RoomType.
     */
    @Test
    public void testInsert() {
        instance = new RoomType(1, "Double", "Featires", 15.0, 4);
        System.out.println("Insert");
        String expResult = "";
        String result = instance.Insert();
        assertEquals(expResult, result);
    }

    /**
     * Test of ReturnList method, of class RoomType.
     */
    @Test
    public void testReturnList() {
        instance = new RoomType(1, "Double", "Featires", 15.0, 4);
        System.out.println("ReturnList");
        ResultSet rs = null;
        List<GeneralDomainObject> expResult = null;
        List<GeneralDomainObject> result = instance.ReturnList(rs);
        assertNull(instance.ReturnList(rs));
    }

    /**
     * Test of GetRecord method, of class RoomType.
     */
    @Test
    public void testGetRecord() throws Exception {
        instance = new RoomType(1, "Double", "Featires", 15.0, 4);
        System.out.println("GetRecord");
        ResultSet rs = null;
        GeneralDomainObject expResult = null;
        assertThrows(java.lang.NullPointerException.class,
				() -> instance.GetRecord(rs));
    }

    /**
     * Test of toString method, of class RoomType.
     */
    @Test
    public void testToString() {
        instance = new RoomType(1, "Double", "Featires", 15.0, 4);
        System.out.println("toString");
        String expResult = "1 Double - 15.0 eur/night - 4 people max";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTypeID method, of class RoomType.
     */
    @Test
    public void testGetTypeID() {
        instance = new RoomType(1, "Double", "Featires", 15.0, 4);
        System.out.println("getTypeID");
        int expResult = 1;
        int result = instance.getTypeID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTypeName method, of class RoomType.
     */
    @Test
    public void testGetTypeName() {
        instance = new RoomType(1, "Double", "Featires", 15.0, 4);
        System.out.println("getTypeName");
        String expResult = "Double";
        String result = instance.getTypeName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFeatures method, of class RoomType.
     */
    @Test
    public void testGetFeatures() {
        instance = new RoomType(1, "Double", "Featires", 15.0, 4);
        System.out.println("getFeatures");
        String expResult = "Featires";
        String result = instance.getFeatures();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPricePerNight method, of class RoomType.
     */
    @Test
    public void testGetPricePerNight() {
        instance = new RoomType(1, "Double", "Featires", 15.0, 4);
        System.out.println("getPricePerNight");
        double result = instance.getPricePerNight();
        assertEquals(15.0, result);
    }

    /**
     * Test of getCapacity method, of class RoomType.
     */
    @Test
    public void testGetCapacity() {
        instance = new RoomType(1, "Double", "Featires", 15.0, 4);
        System.out.println("getCapacity");
        int expResult = 4;
        int result = instance.getCapacity();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTypeID method, of class RoomType.
     */
    @Test
    public void testSetTypeID() {
        instance = new RoomType(1, "Double", "Featires", 15.0, 4);
        System.out.println("setTypeID");
        int typeID = 2;
        instance.setTypeID(typeID);
        assertEquals(typeID, instance.getTypeID());
    }

    /**
     * Test of setTypeName method, of class RoomType.
     */
    @Test
    public void testSetTypeName() {
        instance = new RoomType(1, "Double", "Featires", 15.0, 4);
        System.out.println("setTypeName");
        String typeName = "Studio";
        instance.setTypeName(typeName);
        assertEquals(typeName, instance.getTypeName());
    }

    /**
     * Test of setFeatures method, of class RoomType.
     */
    @Test
    public void testSetFeatures() {
        instance = new RoomType(1, "Double", "Featires", 15.0, 4);
        System.out.println("setFeatures");
        String features = "New features";
        instance.setFeatures(features);
        assertEquals(features, instance.getFeatures());
    }

    /**
     * Test of setPricePerNight method, of class RoomType.
     */
    @Test
    public void testSetPricePerNight() {
        instance = new RoomType(1, "Double", "Featires", 15.0, 4);
        System.out.println("setPricePerNight");
        double pricePerNight = 11.0;
        instance.setPricePerNight(pricePerNight);
        assertEquals(pricePerNight, instance.getPricePerNight());
    }

    /**
     * Test of setCapacity method, of class RoomType.
     */
    @Test
    public void testSetCapacity() {
        instance = new RoomType(1, "Double", "Featires", 15.0, 4);
        System.out.println("setCapacity");
        int capacity = 2;
        instance.setCapacity(capacity);
        assertEquals(capacity, instance.getCapacity());
    }
    
}
