/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;
import Domain.Case;
import Persistence.IReader;
import Persistence.IWriter;
import java.util.ArrayList;
/**
 *
 * @author Peter
 */
public class PersistanceContact {
    
    private static PersistanceContact instance = null;
    public static ArrayList<Integer> caseList = new ArrayList<>();
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
    }
    
    public String saveCase(Case c){ 
        System.out.println("trying to write case: " + c.getID());
        caseList.add(Integer.parseInt(c.getID()+""));
        writer.writeCase(c);
        return "your case has been saved with the ID: " + c.getID();
    }
    
    public IReader getReader(){
        
        return this.reader;
    }
    
    public IWriter getWriter(){
        return this.writer;
    }
    
    
    
    
    
}
