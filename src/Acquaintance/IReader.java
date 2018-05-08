/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

/**
 *
 * @author ander
 */
public interface IReader {    
    public String[] getPerson(long cpr);
    public String[] getEmployee(int id);
    public String[] getCase(int id);
    public String[] getCaseRequest(int id);
    public int[] getCurrentIDs();
}
