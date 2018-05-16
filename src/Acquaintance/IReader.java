package Acquaintance;

import java.util.List;

public interface IReader {

    public String[] login(String username, String password);
     
    public String[] getCaseRequest(int id);
   
    public List<String[]> getSimpleCaseRequests(String citizenCPR);

    public String[] getCase(int id);
    
    public List<String[]> getSimpleCases(String citizenCPR);
            
    public String[] getPerson(String cpr);

    public String[] getEmployee(int id);

    public int[] getCurrentIDs();
}
