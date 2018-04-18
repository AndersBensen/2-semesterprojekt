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
    
     public void injectWriter(IReader reader){
        this.reader = reader;
    }
    
    public void saveCaseRequest(CaseRequest caseRequest){
        this.caseRequest = caseRequest;
    }
    
    public String saveCase(int ID){ 
        return "your case has been saved" + ID;
    }
    
    
    
    
    
}
