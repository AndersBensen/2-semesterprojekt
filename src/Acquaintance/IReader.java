package Acquaintance;

public interface IReader {

    public String[] getCaseRequest(int id);

    public String[] getCase(int id);

    public String[] login(String username, String password);

    public String[] getPerson(long cpr);

    public String[] getEmployee(int id);

    public int[] getCurrentIDs();
}
