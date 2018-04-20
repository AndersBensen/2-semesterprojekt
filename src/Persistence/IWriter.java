/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Domain.ICase;
import Domain.IEmployee;

/**
 *
 * @author ander
 */
public interface IWriter {
    public void writeEmployee(IEmployee employee);
    public void writeCase(ICase cases);
}
