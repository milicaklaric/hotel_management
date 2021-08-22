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
 *
 * @author MK
 */
public abstract class GeneralDomainObject implements Serializable{
    public abstract String TableName();
    public abstract String Join();
    public abstract String Where();
    public abstract String Update();
    public abstract String Insert();
    public abstract GeneralDomainObject GetRecord(ResultSet rs)throws Exception;
    public abstract List<GeneralDomainObject> ReturnList(ResultSet rs)throws Exception;
}
