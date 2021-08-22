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
public class RoomsTableModel extends AbstractTableModel {

    ArrayList<Room> rooms;
    String[] columnNames = {"Room number", "Room view"};

    public RoomsTableModel(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public int getRowCount() {
        return rooms.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Room r = (Room) rooms.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return r.getRoomNumber();
            case 1:
                return r.getView();
            
            default:
                return " ";
        }

    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public ArrayList<Room> getReservations() {
        return rooms;
    }

    public void setReservations(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }
    
    public Room getRoomAt(int row) {
        return rooms.get(row);
    }
}
