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
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MK
 */
public class Broker {

    Connection conn = null;

    public boolean makeConnection() {
        String Url;

        try {
            Class.forName("org.sqlite.JDBC");
            Url = "jdbc:sqlite:ttp-db.s3db";//+path
            conn = DriverManager.getConnection(Url);
            conn.setAutoCommit(false); // Ako se ovo ne uradi nece moci da se radi roolback.
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public boolean insertRecord(GeneralDomainObject odo) {
        String sql = "INSERT INTO " + odo.TableName() + " VALUES (" + odo.Insert() + ")";
        return executeUpdate(sql);
    }

    public boolean deleteRecord(GeneralDomainObject odo) {
        String upit = "DELETE FROM " + odo.TableName() + odo.Update();
        return executeUpdate(upit);
    }

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
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
            signal = false;
        } finally {
            close(null, st, null);
        }
        return signal;
    }

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

    public boolean commitTransation() {
        try {
            conn.commit();
        } catch (SQLException esql) {
            return false;
        }
        return true;
    }

    public boolean rollbackTransation() {
        try {
            conn.rollback();
        } catch (SQLException esql) {
            return false;
        }

        return true;
    }

    public void closeConnection() {
        close(conn, null, null);
    }

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
