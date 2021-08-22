/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller;

import controller.Controller;
import domen.Employee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.coordinator.MainCoordinator;
import view.form.FrmLogIn;

/**
 *
 * @author MK
 */
public class LoginController {
    private final FrmLogIn frmLogin;

    public LoginController(FrmLogIn frmLogin) {
        this.frmLogin = frmLogin;
        frmLogin.setLocationRelativeTo(null);
        addActionListeners();
        
    }

    public FrmLogIn getFrmLogIn() {
        return frmLogin;
    }

    public void openForm() {
        frmLogin.setVisible(true);
    }

    private void addActionListeners() {
        frmLogin.btnSignInAddListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String username = frmLogin.getTxtUsername().getText().trim();
                String password = String.copyValueOf(frmLogin.getTpfPassword().getPassword());
                if(username.isEmpty() || password.isEmpty()){
                    JOptionPane.showMessageDialog(frmLogin, "All fields are required!", "Input all fields", JOptionPane.ERROR_MESSAGE);
                        return;
                }
                Employee employee = Controller.getInstance().getEmployee(username, password);
                if(employee == null){
                    JOptionPane.showMessageDialog(frmLogin, "The username or password you entered is incorrect!", "Invalid information", JOptionPane.ERROR_MESSAGE);
                    return;
                }else{
                    JOptionPane.showMessageDialog(frmLogin, "Welcome  "+employee.toString());
                    MainCoordinator.getInstance().openFrmHome(employee);
                    frmLogin.dispose();
                }
            }

        });
        
    }

}
