/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author Sigurd E. Espersen
 */
public interface IPerson {
    
    public long getCpr();

    public String getName();

    public char getGender();

    public String getBirthDate();

    public String getAddress();

    public int getPhoneNumber();

    public String getMail();
}
