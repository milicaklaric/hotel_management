/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Klasa koja predstavlja gosta u hotelu
 * Za svakog gosta se čuva njegov broj pasoša, ime, prezime i kontakt informacije
 * @author MK
 */
@Getter
@Setter
@NoArgsConstructor
public class Guest extends GeneralDomainObject {

    /**
     * Broj pasoša gosta hotela
     */
    private String passportNumber;
    /**
     * Ime gosta hotela
     */
    private String firstName;
    /**
     * Prezime gosta hotela
     */
    private String lastName;
    /**
     * Kontakt informacije gosta hotela
     */
    private String contactInfo;

    /**
     * Parametarski konstruktor koji instancira objekat i postavlja vrednosti za sve atribute na osnovu
     * zadatih parametara
     * @param passportNumber Broj pasoša gosta hotela
     * @param firstName Ime gosta hotela
     * @param lastName Prezime gosta hotela
     * @param contactInfo Kontakt informacije gosta hotela
     */
    public Guest(String passportNumber, String firstName, String lastName, String contactInfo) {
        this.passportNumber = passportNumber;
        this.firstName = firstName;
        this.lastName = lastName;
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
        return null;
    }

    /**
     * @return Vraća string sa svim podacima o gostu hotela
     */
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    
    
}
