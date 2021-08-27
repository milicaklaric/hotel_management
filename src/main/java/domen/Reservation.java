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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Klasa koja predstavlja jednu rezervaciju sobe u hotelu
 * Svaka rezervacija ima svoj ID
 * Za svaku rezervaciju čuvaju se podaci o gostu, sobi, zaposlenom koji je izvršio rezercvaciju,
 * datumu početka i kraja rezervacije, o tome da li je uključen doručak i ukupnoj ceni boravka
 * @author MK
 */
@Getter
@Setter
@NoArgsConstructor
public class Reservation extends GeneralDomainObject {

    /**
     * ID rezervacije
     */
    private int id;
    /**
     * Soba koja je rezervisana
     */
    private Room room;
    /**
     * Gost koji je rezervisao boravak u hotelu
     */
    private Guest guest;
    /**
     * Zaposleni koji je izvršio rezervaciju preko sistema
     */
    private Employee employee;
    /**
     * Datum početka boravka gosta u hotelu
     */
    private Date checkIn;
    /**
     * Datum odjavljivanja gosta iz hotela
     */
    private Date checkOut;
    /**
     * Podatak o tome da li je uključen dorucak
     */
    private String breakfast;
    /**
     * Ukupna cena boravka u hotelu
     */
    private double total;

    /**
     * Parametarski konstruktor koji instancira objekat i postavlja vrednosti za sve atribute na osnovu
     * zadatih parametara
     * @param id ID rezervacije
     * @param room Soba koja je rezervisana
     * @param guest Gost koji je rezervisao boravak u hotelu
     * @param employee Zaposleni koji je izvršio rezervaciju preko sistema
     * @param checkIn Datum početka boravka gosta u hotelu
     * @param checkOut Datum odjavljivanja gosta iz hotela
     * @param breakfast  Podatak o tome da li je uključen dorucakPodatak o tome da li je uključen dorucak
     */
    public Reservation(int id, Room room, Guest guest, Employee employee, Date checkIn, Date checkOut, String breakfast) {
        this.id = id;
        this.room = room;
        this.guest = guest;
        this.employee = employee;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.breakfast = breakfast;
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
        String insert = (id + ", " +(room == null ? null : room.getRoomNumber()) + ", " + (guest == null ? null : "'" + guest.getPassportNumber() + "'") + ", " + (checkIn == null ? null : "'" + checkIn + "'") + ", " + (checkOut == null ? null : "'" + checkOut + "'") + ", " + (employee == null ? null : "'" + employee.getUsername() + "'") + ", " + (breakfast == null ? null : "'" + breakfast + "'") + ", " + total);
        System.out.println(insert);
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

    @Override
    public boolean equals(Object obj) {
        if (((Reservation)obj).getId() == this.id)
            return true;
        return false;
    }
    
    

}
