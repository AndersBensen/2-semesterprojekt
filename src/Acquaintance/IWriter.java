package Acquaintance;

public interface IWriter {

    public int writeCaseRequest(ICaseRequest ICR);

    public int writeCase(ICase cases);

    public int writeEmployee(IEmployee employee, int position);

    public int deleteEmployee(int id);

    public void writeLog(ILog log);
}
