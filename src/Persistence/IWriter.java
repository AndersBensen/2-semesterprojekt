/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Domain.ICase;
import Domain.ICaseRequest;
import Domain.IEmployee;
import Domain.ILog;

/**
 *
 * @author ander
 */
public interface IWriter {
    public void writeEmployee(IEmployee employee);
    public void deleteEmployee(int id); 
    public void writeCase(ICase cases);
    public void writeCaseRequest(ICaseRequest ICR);
    public void writeLog(ILog log); 
    public void writeIDs(int currentCaseID, int currentCaseRequestID, int currentEmployeeID);
}
