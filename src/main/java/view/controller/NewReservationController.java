/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller;

import controller.Controller;
import domen.Employee;
import domen.GeneralDomainObject;
import domen.Guest;
import domen.GuestValidation;
import domen.Reservation;
import domen.ReservationValidation;
import domen.Room;
import domen.RoomType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.form.FrmNewReservation;
import view.form.table.RoomsTableModel;

/**
 *
 * @author MK
 */
public class NewReservationController {

    private final FrmNewReservation frmNewReservation;
    private Employee employee;
    private Date from;
    private Date to;
    private Room r = new Room();
    private String passportNumber;
    private String firstName;
    private String LastName;
    private String Contact;
    private int row;
    private int id;

    public void getInfo() {
        from = frmNewReservation.getFromDate().getDate();
        to = frmNewReservation.getToDate().getDate();
        r.setType((RoomType) frmNewReservation.getCbRoomTypes().getSelectedItem());
        passportNumber = frmNewReservation.getPassportNumber().getText();
        firstName = frmNewReservation.getFirstName().getText();
        LastName = frmNewReservation.getLastName().getText();
        Contact = frmNewReservation.getContact().getText();
        row = frmNewReservation.getTblRooms().getSelectedRow();
    }

    public NewReservationController(FrmNewReservation frmNewReservation) {
        this.frmNewReservation = frmNewReservation;
        addListeners();
    }

    public FrmNewReservation getpnlAllReservations() {
        return frmNewReservation;
    }

    public void show(Employee employee) {
        this.employee = employee;
        frmNewReservation.setVisible(true);
        fillCbTaxRate();
    }

    private void fillCbTaxRate() {

        List<GeneralDomainObject> types = null;
        frmNewReservation.getCbRoomTypes().removeAllItems();
        try {
            types = Controller.getInstance().getRoomTypes();
            for (GeneralDomainObject type : types) {
                frmNewReservation.getCbRoomTypes().addItem(type);
            }
        } catch (Exception ex) {
            Logger.getLogger(NewReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private double countTotal(RoomType rt, Date from, Date to) {
        double total = 0;
        long daysBetween = to.getTime() - from.getTime();
        daysBetween = TimeUnit.DAYS.convert(daysBetween, TimeUnit.MILLISECONDS);
        total = rt.getPricePerNight() * daysBetween;
        if (frmNewReservation.getCbBreakfast().isSelected()) {
            total = total + 7 * daysBetween;
        }

        frmNewReservation.setTotal(total);
        return total;
    }

    private boolean Validation() {
        if (passportNumber.isEmpty()
                || firstName.isEmpty()
                || LastName.isEmpty()
                || Contact.isEmpty()) {
            JOptionPane.showMessageDialog(frmNewReservation, "All fields are required!", "Input all fields", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (row == -1) {
            JOptionPane.showMessageDialog(frmNewReservation, "Choosing a room is required!", "Choose room", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (to.before(from)) {
            JOptionPane.showMessageDialog(frmNewReservation, "Check out date has to be after check in date", "Check the date", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private void addListeners() {
        frmNewReservation.btnCheckAvailableAddListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                getInfo();
                ArrayList<GeneralDomainObject> reservations = Controller.getInstance().getReservations();

                for (int i = 0; i < reservations.size(); i++) {
                    Reservation res = (Reservation) reservations.get(i);
                    if (res.getCheckOut().before(from) || res.getCheckIn().after(to)) {
                        reservations.remove(res);
                    }
                }

                ArrayList<GeneralDomainObject> rooms = Controller.getInstance().getRooms(r);
                ArrayList<Room> availableRooms = new ArrayList<>();

                for (int i = 0; i < rooms.size(); i++) {
                    Room room = (Room) rooms.get(i);
                    for (int j = 0; j < reservations.size(); j++) {
                        Reservation res = (Reservation) reservations.get(j);
                        if (res.getRoom().equals(room)) {
                            rooms.remove(room);
                            continue;
                        }
                    }
                }

                for (int i = 0; i < rooms.size(); i++) {
                    Room room = (Room) rooms.get(i);
                    availableRooms.add(room);
                }

                frmNewReservation.setTable(availableRooms);
                countTotal(r.getType(), from, to);
            }

        });

        frmNewReservation.btnSaveAddListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                getInfo();
                if (Validation()) {
                    ArrayList<GeneralDomainObject> reservations = Controller.getInstance().getReservations();
                    int id = reservations.size()+1;

                    Guest g = new Guest();
                    g.setPassportNumber(passportNumber);
                    g.setFirstName(firstName);
                    g.setLastName(LastName);
                    g.setContactInfo(Contact);

                    RoomsTableModel rtm = (RoomsTableModel) frmNewReservation.getTblRooms().getModel();
                    Room room = rtm.getRoomAt(row);
                    room.setType((RoomType) frmNewReservation.getCbRoomTypes().getSelectedItem());

                    Reservation res = new Reservation();
                    res.setId(id);
                    res.setGuest(g);
                    res.setRoom(room);
                    res.setCheckIn(from);
                    res.setCheckOut(to);
                    if (frmNewReservation.getCbBreakfast().isSelected()) {
                        res.setBreakfast("yes");
                    } else {
                        res.setBreakfast("no");
                    }
                    res.setTotal(countTotal(r.getType(), from, to));
                    res.setEmployee(employee);
                    
                    if (GuestValidation.allFieldsAreRequired(g) &&
                            ReservationValidation.correctDates(res) &&
                            ReservationValidation.allFieldsAreRequired(res)){
                        if (Controller.getInstance().saveReservation(res)) {
                        JOptionPane.showMessageDialog(frmNewReservation, "Reservation successfully saved!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frmNewReservation, "Reservation couldn't be saved", "Fail", JOptionPane.ERROR_MESSAGE);
                    }
                    }
                    

                }

            }

        });
    }
}
