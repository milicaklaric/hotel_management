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

/**
 *
 * @author MK
 */
public class GuestTest {
    Guest instance;
    
    
    @BeforeEach
    public void setUp() {
        instance = new Guest("69563045263985","Jana","Jovanovic","+381652036060");
    }
    
    @AfterEach
    public void tearDown() {
        instance = null;
    }
    /**
     * Test of TableName method, of class Guest.
     */
    @Test
    public void testTableName() {
        System.out.println("TableName");
        String expResult = "Guest";
        String result = instance.TableName();
        assertEquals(expResult, result);
    }

    /**
     * Test of Join method, of class Guest.
     */
    @Test
    public void testJoin() {
        System.out.println("Join");
        String expResult = "";
        String result = instance.Join();
        assertEquals(expResult, result);
    }

    /**
     * Test of Where method, of class Guest.
     */
    @Test
    public void testWhere() {
        System.out.println("Where");
        String expResult = "";
        String result = instance.Where();
        assertEquals(expResult, result);
    }

    /**
     * Test of Update method, of class Guest.
     */
    @Test
    public void testUpdate() {
        System.out.println("Update");
        String expResult = "";
        String result = instance.Update();
        assertEquals(expResult, result);
    }

    /**
     * Test of Insert method, of class Guest.
     */
    @Test
    public void testInsert() {
        System.out.println("Insert");
        String expResult = "'69563045263985', 'Jana', 'Jovanovic', '+381652036060'";
        String result = instance.Insert();
        assertEquals(expResult, result);
    }

    /**
     * Test of ReturnList method, of class Guest.
     */
    @Test
    public void testReturnList() {
        System.out.println("ReturnList");
        ResultSet rs = null;
        assertNull(instance.ReturnList(rs));
    }

    /**
     * Test of GetRecord method, of class Guest.
     */
    @Test
    public void testGetRecord() throws Exception {
        System.out.println("GetRecord");
        ResultSet rs = null;
        assertNull(instance.GetRecord(rs));
    }

    /**
     * Test of toString method, of class Guest.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Jana Jovanovic";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassportNumber method, of class Guest.
     */
    @Test
    public void testGetPassportNumber() {
        System.out.println("getPassportNumber");
        String expResult = "69563045263985";
        String result = instance.getPassportNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFirstName method, of class Guest.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        String expResult = "Jana";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastName method, of class Guest.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        String expResult = "Jovanovic";
        String result = instance.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getContactInfo method, of class Guest.
     */
    @Test
    public void testGetContactInfo() {
        System.out.println("getContactInfo");
        String expResult = "+381652036060";
        String result = instance.getContactInfo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassportNumber method, of class Guest.
     */
    @Test
    public void testSetPassportNumber() {
        System.out.println("setPassportNumber");
        String passportNumber = "00063045263985";
        instance.setPassportNumber(passportNumber);
        assertEquals(passportNumber, instance.getPassportNumber());
    }

    /**
     * Test of setFirstName method, of class Guest.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "Iva";
        instance.setFirstName(firstName);
        assertEquals(firstName, instance.getFirstName());
    }

    /**
     * Test of setLastName method, of class Guest.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "Veljkovic";
        instance.setLastName(lastName);
        assertEquals(lastName, instance.getLastName());
    }

    /**
     * Test of setContactInfo method, of class Guest.
     */
    @Test
    public void testSetContactInfo() {
        System.out.println("setContactInfo");
        String contactInfo = "+381652035000";
        instance.setContactInfo(contactInfo);
        assertEquals(contactInfo, instance.getContactInfo());
    }
    
}
