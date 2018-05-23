package Domain;

import Acquaintance.ICaseObject;
import java.util.Date;

public class CaseObject implements ICaseObject{
    
    // Information stored on a CaseObject
    private int id; 
    private int employeeID;
    private String type;
    private String desc; 
    private Date dateCreated; 

    // *******************************
    // ********* Constructor *********
    // *******************************
    public CaseObject(int id, int employeeID, String type, String desc, Date dateCreated) {
        this.id = id;
        this.employeeID = employeeID;
        this.type = type;
        this.desc = desc;
        this.dateCreated = dateCreated;
    }

    // *******************************
    // *********   Getters   *********
    // *******************************
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
    
    // *******************************
    // *********    Misc    **********
    // *******************************
    @Override
    public String toString() {
        return "id: " + id + " employeeID: " + employeeID + " type: " + type + " desc: " + desc + " datecreated: " + dateCreated;
    }
}
