package Domain;

public enum LogAction {

    SAVE_CASE_REQUEST("saveCaseRequest"), SAVE_CASE("saveCase"), SAVE_EMPLOYEE("saveEmployee"), 
    DELETE_EMPLOYEE("deleteEmployee"), GET_CASE_REQUEST("getCaseRequest"), GET_CASE("getCase"), 
    GET_EMPLOYEE("getEmployee"), GET_CASE_OBJECT("getCaseObject"), LOG_IN("logIn"), LOG_OUT("logOut");
    
    private String commandString;

    LogAction(String commandString) {
        this.commandString = commandString;
    }

    @Override
    public String toString() {
        return commandString;
    }

}
