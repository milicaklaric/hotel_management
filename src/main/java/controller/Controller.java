/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dbBroker.Broker;
import domen.Employee;
import domen.GeneralDomainObject;
import domen.Reservation;
import domen.Room;
import domen.RoomType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MK
 */
public class Controller {

    private static Controller controller;
    private Broker broker = new Broker();

    private Controller() {

    }

    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    public Employee getEmployee(String username, String password) {
        broker.makeConnection();
        Employee e = new Employee(username, password, username);
        GeneralDomainObject emp = broker.findRecord(e);
        e = (Employee) emp;
        if (e != null) {
            if (e.getUsername().equals(username) && e.getPassword().equals(password)) {
                return e;
            }
        }
        broker.closeConnection();
        return null;
    }

    public ArrayList<GeneralDomainObject> getReservations() {
        broker.makeConnection();
        Reservation r = new Reservation();
        ArrayList<GeneralDomainObject> reservations = broker.findRecords(r);
        broker.closeConnection();
        return reservations;
    }

    public ArrayList<GeneralDomainObject> getRoomTypes() {
        broker.makeConnection();
        RoomType rt = new RoomType();
        ArrayList<GeneralDomainObject> roomTypes = broker.findRecords(rt);
        broker.closeConnection();
        return roomTypes;
    }

    public ArrayList<GeneralDomainObject> getRooms(Room r) {
        broker.makeConnection();
        ArrayList<GeneralDomainObject> roomTypes = broker.findRecords(r);
        broker.closeConnection();
        return roomTypes;
    }

    public boolean saveReservation(Reservation res) {
        broker.makeConnection();
        boolean guestSaved = broker.insertRecord(res.getGuest());
        boolean reservationSaved = false;
        if (guestSaved) {
            reservationSaved = broker.insertRecord(res);
        }

        broker.closeConnection();
        return reservationSaved;
    }

    public boolean deleteReservation(Reservation res) {
        broker.makeConnection();
        boolean reservationDeleted = broker.deleteRecord(res);
        broker.closeConnection();
        return reservationDeleted;
    }

}
