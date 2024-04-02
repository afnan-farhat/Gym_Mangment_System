/*
NAME:  Afnan Tariq Farhat
IDs: 2105973
SECTION: B9A
Assignment number: 2
 */
package assignment2;

import java.util.*;


public class FamilyMember extends Member{

    //data feilds 
    private ArrayList<String> Family_Members_names;

    // constructer 
    public FamilyMember(String ID, String Name, char Gender, Date DateOfBirth, Date DateOfRegestration, String Address, String Phone, ArrayList<String> Family_Members_names) {
        super(ID, Name, Gender, DateOfBirth, DateOfRegestration, Address, Phone);
        this.Family_Members_names = Family_Members_names;
    }

    //methods

    public ArrayList<String> getFamily_Members_names() {
        return Family_Members_names;
    }
    

    public void setFamily_Members_names( ArrayList <String>  Family_Members_names) {
        this.Family_Members_names = Family_Members_names;
    }
    
    public String toString(){
        return "Command Add_Family_Member was successfully completed \n"
            + "FamilyMembers" + super.toString() + ", Family_members_names=" +
            getFamily_Members_names() + "}\n"
                + "----------------------------------------------------------------";  
    }
    

}
