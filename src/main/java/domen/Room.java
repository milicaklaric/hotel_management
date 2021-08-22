/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Klasa koja predstavlja sobu hotela Za svaku sobu čuvaju se podaci o tipu
 * sobe, broju sobe, pogledu i tome da li je u datom trenutku dostupna
 *
 * @author MK
 */
@Getter
@Setter
@NoArgsConstructor
public class Room extends GeneralDomainObject {

    /**
     * Tip sobe
     */
    private RoomType type;
    /**
     * Broj sobe
     */
    private int roomNumber;
    /**
     * Soba moze imati pogled na:
     * <ul>
     *  <li>baštu</li>
     *  <li>plažu</li>
     *  <li>i na baštu i na plažu</li>
     * </ul>
     * 
     */
    private String view;

    /**
     * Podatak o tome da li je soba dostupna za traženi datum
     */
    private boolean available;

    /**
     * Parametarski konstruktor koji instancira objekat i postavlja vrednosti za sve atribute na osnovu
     * zadatih parametara
     * @param type Tip sobe
     * @param roomNumber Broj sobe
     * @param view Pogled iz sobe
     * @param available Podatak o tome da li je soba dostupna za traženi datum
     */
    public Room(RoomType type, int roomNumber, String view, boolean available) {
        this.type = type;
        this.roomNumber = roomNumber;
        this.view = view;
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

    /**
     * Proverava da li su dva objekta jednaka prema atributu broj sobe
     * @param obj Instanca objekta koji želimo da poredimo
     * @return Vraća vrednost TRUE ukoliko su oba objekta tipa Room i imaju isti broj sobe
     */
    @Override
    public boolean equals(Object obj) {
        return this.roomNumber == ((Room) obj).roomNumber;
    }

}
