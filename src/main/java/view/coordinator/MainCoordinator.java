/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.coordinator;
        
import domen.Employee;
import view.controller.AllReservationsController;
import view.controller.CancelReservationController;
import view.controller.HomeController;
import view.controller.LoginController;
import view.controller.NewReservationController;
import view.form.FrmAllReservations;
import view.form.FrmCancelReservation;
import view.form.FrmHome;
import view.form.FrmLogIn;
import view.form.FrmNewReservation;

/**
 *
 * @author MK
 */
public class MainCoordinator {
    private static MainCoordinator instance;
    
    private final LoginController loginController;
    private final HomeController homeController;
    
    public MainCoordinator() {
        loginController = new LoginController(new FrmLogIn());
        homeController = new HomeController(new FrmHome());
                }

    public static MainCoordinator getInstance() {
        if(instance == null){
            instance = new MainCoordinator();
        }
        return instance;
    }

    public void openLoginForm() {
        loginController.openForm();
    }

    public void openFrmHome(Employee employee) {
        homeController.openForm(employee);
    }

    public void showAllReservations() {
        AllReservationsController arc = new AllReservationsController(new FrmAllReservations());
        arc.show();
    }

    public void showNewReservation(Employee employee) {
        NewReservationController nrc = new NewReservationController(new FrmNewReservation());
        nrc.show(employee);
    }

    public void showCancelReservation() {
        CancelReservationController crc = new CancelReservationController(new FrmCancelReservation());
        crc.show();
    }


}
