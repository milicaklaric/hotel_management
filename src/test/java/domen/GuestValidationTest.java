/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author MK
 */
public class GuestValidationTest {
    
    public GuestValidationTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of allFieldsAreRequired method, of class GuestValidation.
     */
    @Test
    public void testAllFieldsAreRequiredAllNull() {
        System.out.println("allFieldsAreRequired");
        Guest guest = new Guest();
        boolean expResult = false;
        boolean result = GuestValidation.allFieldsAreRequired(guest);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testAllFieldsAreRequiredPassportNull() {
        System.out.println("allFieldsAreRequired");
        Guest guest = new Guest(null,"First Name","Last Name","contact");
        boolean expResult = false;
        boolean result = GuestValidation.allFieldsAreRequired(guest);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testAllFieldsAreRequiredFirstNameNull() {
        System.out.println("allFieldsAreRequired");
        Guest guest = new Guest("123456789",null,"Last Name","contact");
        boolean expResult = false;
        boolean result = GuestValidation.allFieldsAreRequired(guest);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testAllFieldsAreRequiredLstNameNull() {
        System.out.println("allFieldsAreRequired");
        Guest guest = new Guest("123456789",null,"Last Name","contact");
        boolean expResult = false;
        boolean result = GuestValidation.allFieldsAreRequired(guest);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testAllFieldsAreRequiredContactNull() {
        System.out.println("allFieldsAreRequired");
        Guest guest = new Guest("123456789","First Name","Last Name",null);
        boolean expResult = false;
        boolean result = GuestValidation.allFieldsAreRequired(guest);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testAllFieldsAreRequired() {
        System.out.println("allFieldsAreRequired");
        Guest guest = new Guest("123456789","First Name","Last Name","contact");
        boolean expResult = true;
        boolean result = GuestValidation.allFieldsAreRequired(guest);
        assertEquals(expResult, result);
        
    }
    
}
