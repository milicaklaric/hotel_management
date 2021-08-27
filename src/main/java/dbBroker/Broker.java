/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbBroker;

import domen.GeneralDomainObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa zadužena za komunikaciju sa bazom podataka
 * @author MK
 */
public class Broker {

    /**
     * Konekcija ka bazi podataka
     */
    Connection conn = null;

    /**
     * Metoda koja uspostavlja konekciju sa bazom
     * @param url Url kao String vrednost
     * @return Vraća TRUE ukoliko je konekcija uspešno uspostavljena i FALSE u suprotnom
     */
    public boolean makeConnection(String url) {
        String Url;

        try {
            Class.forName("org.sqlite.JDBC");
            Url = url;//"jdbc:sqlite:ttp-db.s3db";
            conn = DriverManager.getConnection(Url);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /**
     * Metoda koja upisuje novi zapis u odredjenu tabelu u bazi
     * @param odo Domenski objekat koji se upisuje u bazu podataka
     * @return Vraća TRUE ukoliko je operacija uspešno izvršena
     */
    public boolean insertRecord(GeneralDomainObject odo) {
        String sql = "INSERT INTO " + odo.TableName() + " VALUES (" + odo.Insert() + ")";
        
        return executeUpdate(sql);
    }

    /**
     * Metoda koja briše zapis iz odredjene tabelu u bazi
     * @param odo Domenski objekat koji brišemo iz baze podataka
     * @return Vraća TRUE ukoliko je operacija uspešno izvršena
     */
    public boolean deleteRecord(GeneralDomainObject odo) {
        String upit = "DELETE FROM " + odo.TableName() + odo.Update();
        return executeUpdate(upit);
    }

    /**
     * Metoda ya izvršavanje posledjenog SQL upita nad bazom podataka
     * @param sql SQL upit koji se izvršava nad bazom podataka
     * @return Vraća TRUE ukoliko je operacija uspeštno izvršena
     */
    public boolean executeUpdate(String sql) {
        Statement st = null;
        boolean signal = false;
        try {
            st = conn.createStatement();
            int rowcount = st.executeUpdate(sql);
            if (rowcount > 0) {
                signal = true;
            }
        } catch (SQLException ex) {
            //Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
            signal = false;
        } finally {
            close(null, st, null);
        }
        return signal;
    }

    /**
     * Metoda koja u bazi podataka pronalazi podatke o odredjenom domenskom objektu
     * @param odo Domenski objekat koji tražimo u bazi podataka
     * @return Vraća instancu traženog domenskog objekta
     */
    public GeneralDomainObject findRecord(GeneralDomainObject odo) {
        ResultSet rs = null;
        Statement st = null;
        String upit = "SELECT * FROM " + odo.TableName() + odo.Where();
        boolean signal;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(upit);
            signal = rs.next();
            if (signal == true) {
                odo = odo.GetRecord(rs);
            } else {
                odo = null;
            }
        } catch (Exception ex) {
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(null, st, rs);
        }
        return odo;
    }

    /**
     * Metoda koja u bazi podataka pronalazi podatke o odredjenom domenskom objektu
     * @param odo Domenski objekti koje tražimo u bazi podataka
     * @return Vraća listu objekata traženog tipa
     */
    public ArrayList<GeneralDomainObject> findRecords(GeneralDomainObject odo) {
        ArrayList<GeneralDomainObject> records = new ArrayList<>();
        ResultSet rs = null;
        Statement st = null;
        String upit = "SELECT * FROM " + odo.TableName() + odo.Where() + odo.Join();

        try {
            st = conn.createStatement();
            rs = st.executeQuery(upit);
            while (rs.next()) {
                odo = odo.GetRecord(rs);
                records.add(odo);
            }
        } catch (Exception ex) {
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(null, st, rs);
        }

        return records;
    }

    /**
     * @return Vraća TRUE ukoliko su promene u bazi uspešno commit-ovane
     */
    public boolean commitTransation() {
        try {
            conn.commit();
        } catch (SQLException esql) {
            return false;
        }
        return true;
    }

    /**
     * Metoda poništava promene u bazi
     * @return Vraća TRUE ukoliko je operacija uspešno izvršena
     */
    public boolean rollbackTransation() {
        try {
            conn.rollback();
        } catch (SQLException esql) {
            return false;
        }

        return true;
    }

    /**
     * Metoda zatvara konekciju sa bazom podataka
     */
    public void closeConnection() {
        close(conn, null, null);
    }

    /**
     * Metoda zatvara konekciju sa bazom podataka
     * @param conn Konekcija
     * @param st Statement
     * @param rs Rezultat upita izvršenog nad bazom
     */
    public void close(Connection conn, Statement st, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
