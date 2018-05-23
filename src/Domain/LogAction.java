package Domain;

public enum LogAction {
    
    // Possible actions in the Log
    SAVE_CASE_REQUEST("saveCaseRequest"), SAVE_CASE("saveCase"), EDIT_CASE("editCase"), SAVE_EMPLOYEE("saveEmployee"), 
    DELETE_EMPLOYEE("deleteEmployee"), GET_CASE_REQUEST("getCaseRequest"), GET_CASE("getCase"), GET_PERSON("getPerson"), 
    GET_EMPLOYEE("getEmployee"), GET_CASE_OBJECT("getCaseObject"), LOG_IN("logIn"), LOG_OUT("logOut");
    
    private String commandString;
    
    // Constructor
    LogAction(String commandString) {
        this.commandString = commandString;
    }
    
    // Used to write the action to the database
    @Override
    public String toString() {
        return commandString;
    }

}
