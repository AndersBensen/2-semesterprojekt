/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;


/**
 *
 * @author ander
 */
public interface IEmployee {
    
    public long getCpr(); 
    
    public String getName();
    
    public char getGender();
    
    public String getBirthDate();
    
    public String getAddress();
    
    public int getPhoneNumber();
    
    public String getMail();
    
    public int getId();
    
    public String getUserName();
    
    public String getPassWord();
    
    public void setId(int id);
    
    public void setUserName(String userName);
    
    public void setPassword(String password);
}
