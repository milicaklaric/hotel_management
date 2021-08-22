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
public class EmployeeTest {
    Employee instance;
        
    @BeforeEach
    public void setUp() {
        instance = new Employee("milica","milica","Milica Klaric");     
    }
    
    @AfterEach
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of TableName method, of class Employee.
     */
    @Test
    public void testTableName() {
        instance = new Employee("milica","milica","Milica Klaric");   
        System.out.println("TableName");
        String expResult = "Employee";
        String result = instance.TableName();
        assertEquals(expResult, result);
    }

    /**
     * Test of Join method, of class Employee.
     */
    @Test
    public void testJoin() {
        instance = new Employee("milica","milica","Milica Klaric");   
        System.out.println("Join");
        String expResult = "";
        String result = instance.Join();
        assertEquals(expResult, result);
    }

    /**
     * Test of Where method, of class Employee.
     */
    @Test
    public void testWhere() {
        instance = new Employee("milica","milica","Milica Klaric");   
        System.out.println("Where");
        String expResult = " WHERE username LIKE '" + instance.getUsername()+"'";
        String result = instance.Where();
        assertEquals(expResult, result);
    }

    /**
     * Test of Update method, of class Employee.
     */
    @Test
    public void testUpdate() {
        instance = new Employee("milica","milica","Milica Klaric");   
        System.out.println("Update");
        String expResult = "";
        String result = instance.Update();
        assertEquals(expResult, result);
    }

    /**
     * Test of Insert method, of class Employee.
     */
    @Test
    public void testInsert() {
        instance = new Employee("milica","milica","Milica Klaric");   
        System.out.println("Insert");
        String expResult = "";
        String result = instance.Insert();
        assertEquals(expResult, result);
    }

    /**
     * Test of ReturnList method, of class Employee.
     */
    @Test
    public void testReturnList() {
        instance = new Employee("milica","milica","Milica Klaric");   
        System.out.println("ReturnList");
        ResultSet rs = null;
        assertThrows(java.lang.NullPointerException.class,
				() -> instance.ReturnList(rs));
    }

    /**
     * Test of GetRecord method, of class Employee.
     */
    @Test
    public void testGetRecord() {
        instance = new Employee("milica","milica","Milica Klaric");   
        System.out.println("GetRecord");
        ResultSet rs = null;
        assertThrows(java.lang.NullPointerException.class,
				() -> instance.GetRecord(rs));
    }

    /**
     * Test of toString method, of class Employee.
     */
    @Test
    public void testToString() {
        instance = new Employee("milica","milica","Milica Klaric");   
        System.out.println("toString");
        String expResult = instance.getName();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsername method, of class Employee.
     */
    @Test
    public void testGetUsername() {
        instance = new Employee("milica","milica","Milica Klaric");   
        System.out.println("getUsername");
        String expResult = "milica";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassword method, of class Employee.
     */
    @Test
    public void testGetPassword() {
        instance = new Employee("milica","milica","Milica Klaric");   
        System.out.println("getPassword");
        String expResult = "milica";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Employee.
     */
    @Test
    public void testGetName() {
        instance = new Employee("milica","milica","Milica Klaric");   
        System.out.println("getName");
        String expResult = "Milica Klaric";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUsername method, of class Employee.
     */
    @Test
    public void testSetUsername() {
        instance = new Employee("milica","milica","Milica Klaric");   
        System.out.println("setUsername");
        String username = "jana";
        instance.setUsername(username);
        assertEquals(username, instance.getUsername());
    }

    /**
     * Test of setPassword method, of class Employee.
     */
    @Test
    public void testSetPassword() {
        instance = new Employee("milica","milica","Milica Klaric");   
        System.out.println("setPassword");
        String password = "janaPass";
        instance.setPassword(password);
        assertEquals(password, instance.getPassword());
    }

    /**
     * Test of setName method, of class Employee.
     */
    @Test
    public void testSetName() {
        instance = new Employee("milica","milica","Milica Klaric");   
        System.out.println("setName");
        String name = "Jana Jovanovic";
        instance.setName(name);
        assertEquals(name, instance.getName());
    }
    
}
