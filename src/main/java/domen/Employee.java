/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Klasa koja predstavlja zaposlenog u hotelu
 * Zaposleni ima ime, kao i korisničko ime i šifru za prijavljivanje na sistem
 * @author MK
 */
@Getter
@Setter
@NoArgsConstructor
public class Employee extends GeneralDomainObject {

    /**
     * Korisničko ime zaposlenog
     */
    private String username;
    /**
     * šifra zaposlenog
     */
    private String password;
    /**
     * Ime i prezime zaposlenog
     */
    private String name;

    /**
     * Parametarski konstruktor koji instancira objekat i postavlja vrednosti za sve atribute na osnovu
     * zadatih parametara
     * @param username Korisničko ime zaposlenog
     * @param password Šifra zaposlenog
     * @param name Ime i prezime zaposlenog
     */
    public Employee(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

  
    @Override
    public String TableName() {
        return "Employee";
    }

    @Override
    public String Join() {
        return "";
    }

    @Override
    public String Where() {
        return " WHERE username LIKE '" + this.username+"'";
    }

    @Override
    public String Update() {
        return "";
    }

    @Override
    public String Insert() {
        return "";
    }

    @Override
    public List<GeneralDomainObject> ReturnList(ResultSet rs) throws Exception {
        List<GeneralDomainObject> employees = new ArrayList<>();

        while (rs.next()) {
            String username = rs.getString("username");
            String password = rs.getString("password");
            String name = rs.getString("name");
            GeneralDomainObject e = new Employee(username, password, name);
            employees.add(e);

        }

        return employees;
    }

    @Override
    public GeneralDomainObject GetRecord(ResultSet rs) throws Exception {
        String username = rs.getString("username");
        String password = rs.getString("password");
        String name = rs.getString("name");
        GeneralDomainObject e = new Employee(username, password, name);
        return e;
    }

    /**
     * @return Vraća string sa svim podacima o zaposlenom
     */
    @Override
    public String toString() {
        return name;
    }

    
}
