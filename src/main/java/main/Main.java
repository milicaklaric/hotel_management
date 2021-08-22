/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 * Main class for project
 * 
 * @author MK
 * @version 0.1
 */
import view.coordinator.*;

public class Main {
    public static void main(String[] args) {
        
        MainCoordinator.getInstance().openLoginForm();
        
    }
    
}
