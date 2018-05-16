package Domain;

import Acquaintance.IPerson;

public class Person implements IPerson {

    private String cpr;
    private String name;
    private char gender;
    private String birthDate;
    private String address;
    private Integer phoneNumber;
    private String mail;

    public Person(String cpr, String name, char gender, String birthDate, String address, Integer phoneNumber, String mail) {
        this.cpr = cpr;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
    }

    @Override
    public String getCpr() {
        return cpr;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public char getGender() {
        return gender;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String getMail() {
        return mail;
    }

    public void setCpr(String cpr) {
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

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
