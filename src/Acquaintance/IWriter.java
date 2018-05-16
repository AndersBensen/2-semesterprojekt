package Acquaintance;

public interface IWriter {

    public void writeEmployee(IEmployee employee, int position);

    public void deleteEmployee(int id);

    public void writeCase(ICase cases);

    public void writeCaseRequest(ICaseRequest ICR);

    public void writeLog(ILog log);
}
