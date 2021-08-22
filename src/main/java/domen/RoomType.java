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
 * Klasa koja označava tip sobe
 * Za svaki tip sobe čuva se njegov ID, naziv, karakteristike, cena po noći i kapacitet
 * @author MK
 */
@Getter
@Setter
@NoArgsConstructor
public class RoomType extends GeneralDomainObject{
    
    /**
     * ID tipa sobe
     */
    private int typeID;
    /**
     * Naziv tipa sobe
     */
    private String typeName;
    /**
     * Karakteristike tipa sobe
     */
    private String features;
    /**
     * Cena po noći
     */
    private double pricePerNight;
    /**
     * Kapacitet odnosno broj ljudi koji mogu da odsedaju u datom tipu sobe
     */
    private int capacity;

    /**
     * Parametarski konstruktor koji instancira objekat i postavlja vrednosti za sve atribute na osnovu
     * zadatih parametara
     * @param typeID ID tipa sobe
     * @param typeName Naziv tipa sobe
     * @param features Karakteristike tipa sobe
     * @param pricePerNight Cena po noći
     * @param capacity  Kapacitet odnosno broj ljudi koji mogu da odsedaju u datom tipu sobe
     */
    public RoomType(int typeID, String typeName, String features, double pricePerNight, int capacity) {
        this.typeID = typeID;
        this.typeName = typeName;
        this.features = features;
        this.pricePerNight = pricePerNight;
        this.capacity = capacity;
    }

    @Override
    public String TableName() {
        return "RoomType";
    }

    @Override
    public String Join() {
        return "";
    }

    @Override
    public String Where() {
        return "";
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
        RoomType rt = new RoomType();
        rt.setTypeID(rs.getInt("TypeID"));
        rt.setTypeName(rs.getString("TypeName"));
        rt.setPricePerNight(rs.getDouble("PricePerNight"));
        rt.setCapacity(rs.getInt("MaxCapacity"));
        
        return rt;
    }

    /**
     * 
     * @return Vraća string informacijama o ceni i kapacitetu za odredjeni tip sobe
     */
    @Override
    public String toString() {
        return typeID +" "+ typeName + " - " + pricePerNight + " eur/night - " + capacity + " people max";
    }
    
            
}
