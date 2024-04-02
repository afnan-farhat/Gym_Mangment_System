/*
NAME:  Afnan Tariq Farhat
IDs: 2105973
SECTION: B9A
Assignment number: 2
 */

package assignment2;

import java.text.*;
import java.util.*;

public abstract class Member {
    //data feilds
    private String ID;
    private String Name;
    private char Gender;
    private Date DateOfBirth;
    private Date DateOfRegestration;
    private String Address;
    private String Phone; 
    
    //constructer 
    public Member (String ID, String Name, char Gender, Date DateOfBirth, Date DateOfRegestration, String Address, String Phone){
        this.ID = ID;
        this.Name = Name;
        this.Gender = Gender;
        this.DateOfBirth =DateOfBirth;
        this.DateOfRegestration = DateOfRegestration;
        this.Address = Address;
        this.Phone = Phone;
    }

    //Methods
    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public char getGender() {
        return Gender;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public Date getDateOfRegestration() {
        return DateOfRegestration;
    }

    public String getAddress() {
        return Address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setGender(char Gender) {
        this.Gender = Gender;
    }

    public void setDateOfBirth(Date DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public void setDateOfRegestration(Date DateOfRegestration) {
        this.DateOfRegestration = DateOfRegestration;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }
    
    @Override
    public String toString() {
        return "{ID=" + ID + ", Name=" + Name + ", Gender=" + Gender + ", DateOfBirth=" + DateToString(DateOfBirth) + 
                ", DateOfRegestration=" + DateToString(DateOfRegestration) + ", Address="+ Address+", Phone=" + Phone ;
    }
    
    public static String DateToString(Date date){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
        String Date_string = format.format(date);  
        return Date_string;
    }
    
}
