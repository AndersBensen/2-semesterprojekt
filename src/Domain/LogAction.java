/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author Peter
 */
public enum LogAction {
    
    SAVE_CASE_REQUEST("saveCaseRequest"), SAVE_CASE("saveCase"), SAVE_EMPLOYEE("saveEmployee"), DELETE_EMPLOYEE("deleteEmployee"), GET_CASE_REQUEST("getCaseRequest"), GET_CASE("getCase"), GET_EMPLOYEE("getEmployee"), LOG_IN("logIn"),LOG_OUT("logOut");
    private String commandString;
    
   LogAction(String commandString) {
       this.commandString = commandString;
    }
   
}
