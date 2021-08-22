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
public class RoomType extends GeneralDomainObject{
    private int typeID;
    private String typeName;
    private String features;
    private double pricePerNight;
    private int capacity;

    public RoomType() {
    }

    public RoomType(int typeID, String typeName, String features, double pricePerNight, int capacity) {
        this.typeID = typeID;
        this.typeName = typeName;
        this.features = features;
        this.pricePerNight = pricePerNight;
        this.capacity = capacity;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
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

    @Override
    public String toString() {
        return typeID +" "+ typeName + " - " + pricePerNight + " eur/night - " + capacity + " people max";
    }
    
            
}
