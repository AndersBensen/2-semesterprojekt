/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import java.util.Date;

/**
 *
 * @author ander
 */
public interface ICaseObject {
    
    public int getID();
    
    public int getEmployeeID();
    
    public String getType();
    
    public String getDesc();
    
    public Date getDateCreated();
    
}
