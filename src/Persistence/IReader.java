/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

/**
 *
 * @author ander
 */
public interface IReader {    
    public String[] getPatient(long cpr);
    public String[] getEmployee(int id);
}
