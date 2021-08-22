/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dbBroker.Broker;
import domen.Employee;
import domen.GeneralDomainObject;
import domen.Reservation;
import domen.Room;
import domen.RoomType;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa zadužena za poslovnu logiku sistema
 *
 * @author MK
 */
public class Controller {
    
    private static Controller controller;
    private Broker broker = new Broker();
    
    private Controller() {
    }

    /**
     * @return Vraća instancu kontrolera
     */
    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    /**
     * Metoda za pronalaženje podataka o zaposlenom u bazi podataka na osnovu
     * korisničkog imena i šifre
     *
     * @param username Korisničko ime zaposlenog koji želi da se uloguje u
     * sistem
     * @param password Šifra zaposlenog koji želi da se uloguje u sistem
     * @return Vraća Zaposlenog ukoliko postoji u bazi i NULL u suprotnom
     */
    public Employee getEmployee(String username, String password) {
        broker.makeConnection();
        Employee e = new Employee(username, password, "");
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
     *
     * @return Vraća listu svih rezervacija u bazi
     */
    public ArrayList<GeneralDomainObject> getReservations() {
        broker.makeConnection();
        Reservation r = new Reservation();
        ArrayList<GeneralDomainObject> reservations = broker.findRecords(r);
        try ( FileWriter file = new FileWriter("allReservations.json")) {
            
            Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
            file.write("All reservations in database: \n");
            gson.toJson(reservations, file);            
            
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        broker.closeConnection();
        return reservations;
    }

    /**
     * Metoda za pronalaženje podataka o tipovima soba u bazi podataka
     *
     * @return Vraća listu svih tipova soba u bazi
     */
    public ArrayList<GeneralDomainObject> getRoomTypes() {
        broker.makeConnection();
        RoomType rt = new RoomType();
        ArrayList<GeneralDomainObject> roomTypes = broker.findRecords(rt);
        broker.closeConnection();
        return roomTypes;
    }

    /**
     * Metoda za pronalaženje podataka o sobama u bazi podataka na osnovu tipa
     * sobe
     *
     * @param r Sobe koje tažimo u bazi
     * @return Vraća listu svih soba u bazi
     *
     */
    public ArrayList<GeneralDomainObject> getRooms(Room r) {
        broker.makeConnection();
        ArrayList<GeneralDomainObject> roomTypes = broker.findRecords(r);
        broker.closeConnection();
        return roomTypes;
    }

    /**
     * Metoda za čuvanje rezervacije u bazi podataka
     *
     * @param res Rezervacija za čuvanje
     * @return Vraća TRUE ukoliko je operacija uspešno izvršena a FALSE u
     * suprotnom
     */
    public boolean saveReservation(Reservation res) {
        broker.makeConnection();
        boolean guestSaved = broker.insertRecord(res.getGuest());
        boolean reservationSaved = false;
        if (guestSaved) {
            broker.commitTransation();
            reservationSaved = broker.insertRecord(res);
        } else {
            broker.rollbackTransation();
        }
        if (reservationSaved) {
            broker.commitTransation();
            try ( FileWriter file = new FileWriter("newReservations.json")) {
                file.write("New reservation saved: \n");
                Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
                gson.toJson(res, file);                
                
            } catch (IOException e) {
                
                e.printStackTrace();
            }
        } else {
            broker.rollbackTransation();
        }
        broker.closeConnection();
        return reservationSaved;
    }

    /**
     * Metoda za brisanje rezervacije iz baze podataka
     *
     * @param res Rezervacija za brisanje
     * @return Vraća TRUE ukoliko je operacija uspešno izvršena a FALSE u
     * suprotnom
     */
    public boolean deleteReservation(Reservation res) {
        broker.makeConnection();
        boolean reservationDeleted = broker.deleteRecord(res);
        if (reservationDeleted) {
            broker.commitTransation();
            try ( FileWriter file = new FileWriter("deletedReservations.json")) {
                file.write("Reservation deleted: \n");
                Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
                gson.toJson(res, file);                
                
            } catch (IOException e) {
                
                e.printStackTrace();
            }
        } else {
            broker.rollbackTransation();
        }
        broker.closeConnection();
        return reservationDeleted;
    }
    
}
