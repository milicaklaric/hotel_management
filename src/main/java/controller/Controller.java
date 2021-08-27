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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa zadužena za poslovnu logiku sistema
 * @author MK
 */
public class Controller {

    private static Controller controller;
    private final Broker broker = new Broker();
    private final String url;

    private Controller(String url) {
        this.url = url;
    }

    /** 
     * @return Vraća instancu kontrolera
     */
    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller("jdbc:sqlite:ttp-db.s3db");
        }
        return controller;
    }
    
    public static Controller getInstanceForTests() {
        if (controller == null) {
            controller = new Controller("jdbc:sqlite:ttp-db-test.s3db");
        }
        return controller;
    }

    /**
     * Metoda za pronalaženje podataka o zaposlenom u bazi podataka na osnovu korisničkog imena i šifre
     * @param username Korisničko ime zaposlenog koji želi da se uloguje u sistem
     * @param password Šifra zaposlenog koji želi da se uloguje u sistem
     * @return Vraća Zaposlenog ukoliko postoji u bazi i NULL u suprotnom
     */
    public Employee getEmployee(String username, String password) {
        broker.makeConnection(url);
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

    /**
     * Metoda za pronalaženje podataka o rezervacijama u bazi podataka 
     * @return Vraća listu svih rezervacija u bazi
     */
    public ArrayList<GeneralDomainObject> getReservations() {
        broker.makeConnection(url);
        Reservation r = new Reservation();
        ArrayList<GeneralDomainObject> reservations = broker.findRecords(r);
        broker.closeConnection();
        return reservations;
    }

    /**
     * Metoda za pronalaženje podataka o tipovima soba u bazi podataka 
     * @return Vraća listu svih tipova soba u bazi
     */
    public ArrayList<GeneralDomainObject> getRoomTypes() {
        broker.makeConnection(url);
        RoomType rt = new RoomType();
        ArrayList<GeneralDomainObject> roomTypes = broker.findRecords(rt);
        broker.closeConnection();
        return roomTypes;
    }

    /**
     * Metoda za pronalaženje podataka o sobama u bazi podataka na osnovu tipa sobe
     * @param r Sobe koje tažimo u bazi
     * @return Vraća listu svih soba u bazi
     * 
     */
    public ArrayList<GeneralDomainObject> getRooms(Room r) {
        broker.makeConnection(url);
        ArrayList<GeneralDomainObject> roomTypes = broker.findRecords(r);
        broker.closeConnection();
        return roomTypes;
    }

    /**
     * Metoda za čuvanje rezervacije u bazi podataka
     * @param res Rezervacija za čuvanje
     * @return Vraća TRUE ukoliko je operacija uspešno izvršena a FALSE u suprotnom
     */
    public boolean saveReservation(Reservation res)  {
        broker.makeConnection(url);
        boolean guestSaved;
        broker.insertRecord(res.getGuest());
        guestSaved = true;
        boolean reservationSaved = false;
        if (guestSaved) {
            broker.commitTransation();
           
                reservationSaved = broker.insertRecord(res);
            
        } else {
            broker.rollbackTransation();
        }
        if (reservationSaved) {
            broker.commitTransation();
        } else {
            broker.rollbackTransation();
        }
        broker.closeConnection();
        return reservationSaved;
    }

    /**
     * Metoda za brisanje rezervacije iz baze podataka
     * @param res Rezervacija za brisanje
     * @return Vraća TRUE ukoliko je operacija uspešno izvršena a FALSE u suprotnom
     */
    public boolean deleteReservation(Reservation res) {
        broker.makeConnection(url);
        boolean reservationDeleted = broker.deleteRecord(res);
        if (reservationDeleted) {
            broker.commitTransation();
        } else {
            broker.rollbackTransation();
        }
        broker.closeConnection();
        return reservationDeleted;
    }


}
