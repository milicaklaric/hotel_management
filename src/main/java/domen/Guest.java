/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author MK
 */
public class Guest extends GeneralDomainObject {

    private String passportNumber;
    private String firstName;
    private String lastName;
    private String contactInfo;

    public Guest() {
    }

    public Guest(String passportNumber, String firstName, String lastName, String contactInfo) {
        this.passportNumber = passportNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactInfo = contactInfo;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
    
    
    
    @Override
    public String TableName() {
        return "Guest";
    }

    @Override
    public String Join() {
        return "";
    }

    @Override
    public String Where() {
        return "";
    }

    @Override
    public String Update() {
        return "";
    }

    @Override
    public String Insert() {
        return (passportNumber == null ? null : "'" + passportNumber + "'") + ", " + (firstName == null ? null : "'" + firstName + "'") + ", " + (lastName == null ? null : "'" + lastName + "'") + ", " + (contactInfo == null ? null : "'" + contactInfo + "'");
    }

    @Override
    public List<GeneralDomainObject> ReturnList(ResultSet rs) {
        return null;
    }

    @Override
    public GeneralDomainObject GetRecord(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
    
    
    
}
