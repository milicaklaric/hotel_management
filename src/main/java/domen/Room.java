/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author MK
 */
public class Room extends GeneralDomainObject{

    private RoomType type;
    private int roomNumber;
    private String view;
    private boolean available;

    public Room() {
    }

    public Room(RoomType type, int roomNumber, String view, boolean available) {
        this.type = type;
        this.roomNumber = roomNumber;
        this.view = view;
        this.available = available;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    
     
    
    @Override
    public String TableName() {
        return "Room";
    }

    @Override
    public String Join() {
        return "";
    }

    @Override
    public String Where() {
        return " WHERE TypeID = " + type.getTypeID();
    }

    @Override
    public String Update() {
        return "";
    }

    @Override
    public String Insert() {
        return "";
    }

    @Override
    public List<GeneralDomainObject> ReturnList(ResultSet rs) {
        return null;
    }

    @Override
    public GeneralDomainObject GetRecord(ResultSet rs) throws Exception {
        Room room = new Room();
        room.setRoomNumber(rs.getInt("RoomNumber"));
        room.setView(rs.getString("RoomView"));
        return room;
    }

    @Override
    public boolean equals(Object obj) {
        return this.roomNumber==((Room)obj).roomNumber;
    }
    
    
    
}


