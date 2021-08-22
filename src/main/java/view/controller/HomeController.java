/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller;

import domen.Employee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.coordinator.MainCoordinator;
import view.form.FrmHome;

/**
 *
 * @author MK
 */
public class HomeController {
    private final FrmHome frmHome;
    private Employee employee;

    public HomeController(FrmHome frmHome) {
        this.frmHome = frmHome;
        addListeners();
    }

    public FrmHome getFrmHome() {
        return frmHome;
    }
//
    public void openForm(Employee employee) {
        this.employee = employee;
        frmHome.setVisible(true);
        frmHome.setLocationRelativeTo(null);
        frmHome.getlblEmployee().setText("Employee: " + employee.toString());
    }

    private void addListeners() {
        frmHome.btnAllReservationsAddListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MainCoordinator.getInstance().showAllReservations();
            }

        });
        frmHome.btnNewReservationAddListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                MainCoordinator.getInstance().showNewReservation(employee);
                frmHome.dispose();
            }
        });
        frmHome.btnCancelReservation(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                MainCoordinator.getInstance().showCancelReservation();
                frmHome.dispose();
            }
        });
    }
}
