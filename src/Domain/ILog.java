/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.Date;

/**
 *
 * @author ander
 */
public interface ILog {
    public int getEmployeeID();
    public LogAction getAction();
    public String getDesc();
    public Date getDate();
}
