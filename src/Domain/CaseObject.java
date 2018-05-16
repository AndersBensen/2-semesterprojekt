/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Acquaintance.ICaseObject;
import java.util.Date;

/**
 *
 * @author ander
 */
public class CaseObject implements ICaseObject{
    private int id; 
    private int employeeID;
    private String type;
    private String desc; 
    private Date dateCreated; 

    public CaseObject(int id, int employeeID, String type, String desc, Date dateCreated) {
        this.id = id;
        this.employeeID = employeeID;
        this.type = type;
        this.desc = desc;
        this.dateCreated = dateCreated;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public int getEmployeeID() {
        return employeeID;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public Date getDateCreated() {
        return dateCreated;
    }
    
    @Override
    public String toString() {
        return "id: " + id + " employeeID: " + employeeID + " type: " + type + " desc: " + desc + " datecreated: " + dateCreated;
    }
}
