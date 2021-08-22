/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author MK
 */
public class Reservation extends GeneralDomainObject {

    private int id;
    private Room room;
    private Guest guest;
    private Employee employee;
    private Date checkIn;
    private Date checkOut;
    private String breakfast;
    private double total;

    public Reservation() {
    }

    public Reservation(int id, Room room, Guest guest, Employee employee, Date checkIn, Date checkOut, String breakfast) {
        this.id = id;
        this.room = room;
        this.guest = guest;
        this.employee = employee;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.breakfast = breakfast;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String TableName() {
        return "Reservation";
    }

    @Override
    public String Join() {
        return " JOIN room using(roomNumber) join roomtype using(TypeID) join guest on reservation.Guest = guest.PassportNumber";
    }

    @Override
    public String Where() {
        return "";
    }

    @Override
    public String Update() {
        return " WHERE id = " + id;
    }

    @Override
    public String Insert() {
        return id + ", " +(room == null ? null : room.getRoomNumber()) + ", " + (guest == null ? null : "'" + guest.getPassportNumber() + "'") + ", " + (checkIn == null ? null : "'" + checkIn + "'") + ", " + (checkOut == null ? null : "'" + checkOut + "'") + ", " + (employee == null ? null : "'" + employee.getUsername() + "'") + ", " + (breakfast == null ? null : "'" + breakfast + "'") + ", " + total;
    }

    @Override
    public List<GeneralDomainObject> ReturnList(ResultSet rs) {
        return null;
    }

    @Override
    public GeneralDomainObject GetRecord(ResultSet rs) throws Exception {
        RoomType rt = new RoomType();
        rt.setTypeID(rs.getInt("TypeID"));
        rt.setTypeName(rs.getString("TypeName"));
        rt.setPricePerNight(rs.getDouble("PricePerNight"));
        rt.setCapacity(rs.getInt("MaxCapacity"));
        Room r = new Room();
        r.setType(rt);
        r.setRoomNumber(rs.getInt("RoomNumber"));
        Guest g = new Guest();
        g.setFirstName(rs.getString("FirstName"));
        g.setLastName(rs.getString("LastName"));
        g.setContactInfo(rs.getString("ContactInfo"));
        Reservation res = new Reservation();
        res.setId(rs.getInt("id"));
        res.setRoom(r);
        res.setGuest(g);
        res.setCheckIn(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("CheckIn")));
        res.setCheckOut(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("CheckOut")));
        res.setTotal(rs.getDouble("Total"));

        return res;

    }

}
