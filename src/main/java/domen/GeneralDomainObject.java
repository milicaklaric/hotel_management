/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 * Klasa koja predstavlja generalni domenski objekat i koju ostale domenske klase nasledjuju
 * @author MK
 */
public abstract class GeneralDomainObject implements Serializable{
    /**
     * 
     * @return Vraća naziv tabele u bazi podataka za dati objekat
     */
    public abstract String TableName();
    /**
     * 
     * @return Vraća deo SQL upita potrebnog za povezivanje tabela 
     */
    public abstract String Join();
    /**
     * 
     * @return Vraća deo SQL upita sa uslovom za pretragu
     */
    public abstract String Where();
    /**
     * 
     * @return Vraća SQL upit za ažuriranje podataka u bazi 
     */
    public abstract String Update();
    /**
     * 
     * @return Vraća SQL upit za unošenje podataka u bazu
     */
    public abstract String Insert();
    /**
     * Metoda instancira objekat i postavlja vrednosti parametara na osnovu ResultSet-a 
     * dobijenog iz baze podataka
     * @param rs Rezultat SQL upita u vidu Result seta
     * @return Vraća instancu odredjenog domenskog objekta
     * @throws Exception  Ukoliko dodje do greške u čitanju podataka iz Result seta
     */
    public abstract GeneralDomainObject GetRecord(ResultSet rs)throws Exception;
    /**
     * Metoda vraća listu objekata koja sadrzi sve zapise o odredjenoj domenskoj klasi u bazi podataka 
     * @param rs Rezultat SQL upita u vidu Result seta
     * @return Vraća listu objekata odredjene domenske klase
     * @throws Exception Ukoliko dodje do greške u čitanju podataka iz Result seta
     */
    public abstract List<GeneralDomainObject> ReturnList(ResultSet rs)throws Exception;
}
