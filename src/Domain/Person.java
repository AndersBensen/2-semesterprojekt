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
public class Person {
    private long cpr; 
    private String name;
    private char gender;
    private String birthDate; 
    private String address; 
    private int phoneNumber; 
    private String mail; 

    public Person(long cpr, String name, char gender, String birthDate, String address, int phoneNumber, String mail) {
        this.cpr = cpr;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
    }

    public long getCpr() {
        return cpr;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getAddress() {
        return address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setCpr(int cpr) {
        this.cpr = cpr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
