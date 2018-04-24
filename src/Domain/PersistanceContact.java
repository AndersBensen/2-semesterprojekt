/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;
import Domain.Case;
import Persistence.IReader;
import Persistence.IWriter;
/**
 *
 * @author Peter
 */
public class PersistanceContact {
    
    private static PersistanceContact instance = null;
    private IWriter writer;
    private IReader reader;
    private CaseRequest caseRequest;
    
    public static PersistanceContact getInstance()
    {
        if (instance == null)
            instance = new PersistanceContact();
        
        return instance;
    }
    
    public void injectWriter(IWriter writer){
        this.writer = writer;
    }
    
     public void injectReader(IReader reader){
        this.reader = reader;
    }
    
    public void saveCaseRequest(CaseRequest caseRequest){
        this.caseRequest = caseRequest;
        writer.writeCaseRequest(caseRequest);
        System.out.println("Case request have been saved!");
    }
    
    public String saveCase(Case c){ 
        writer.writeCase(c);
        return "your case has been saved with the ID: " + c.getID();
    }
    
    
    
    
    
    public Person getPerson(long CPR){
       String[] p = reader.getPerson(CPR);
       Person person = new Person(Long.parseLong(p[0]), p[1], p[2].charAt(0), p[3], p[4], Integer.parseInt(p[5]), p[6]);
       return person;
    }
    
    public IReader getReader(){
        return this.reader;
    }
    
    public IWriter getWriter(){
        return this.writer;
    }
    
    
    
    
    
}
