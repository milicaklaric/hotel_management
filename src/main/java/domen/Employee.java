/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MK
 */
public class Employee extends GeneralDomainObject {

    private String username;
    private String password;
    private String name;

    public Employee() {
    }

    public Employee(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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

    @Override
    public String toString() {
        return name;
    }

    
}
