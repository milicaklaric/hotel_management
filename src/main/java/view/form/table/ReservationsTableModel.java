/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.form.table;

import domen.GeneralDomainObject;
import domen.Reservation;
import domen.Room;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MK
 */
public class ReservationsTableModel extends AbstractTableModel {

    ArrayList<Reservation> reservations;
    String[] columnNames = {"Room type", "Room number", "Guest", "Contact information", "Check in date", "Check out date", "TOTAL"};

    public ReservationsTableModel(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public int getRowCount() {
        return reservations.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Reservation r = (Reservation) reservations.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return r.getRoom().getType().toString();
            case 1:
                return r.getRoom().getRoomNumber();
            case 2:
                return r.getGuest().toString();
            case 3:
                return r.getGuest().getContactInfo();
            case 4:
                return r.getCheckIn();
            case 5:
                return r.getCheckOut();
            case 6:
                return r.getTotal();
            default:
                return " ";
        }

    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }
    
    public Reservation getReservationAt(int row) {
        return reservations.get(row);
    }
}
