/*
NAME:  Afnan Tariq Farhat
IDs: 2105973
SECTION: B9A
Assignment number: 2
 */
package assignment2;

import java.util.*;

public class SingleMember extends Member {

    //data feilds
    private String MembershipType;

    // constructer  
    public SingleMember(String ID, String Name, char Gender, Date DateOfBirth, Date DateOfRegestration, String Address, String Phone, String MembershipType) {
        super(ID, Name, Gender, DateOfBirth, DateOfRegestration, Address, Phone);
        this.MembershipType = MembershipType;
    }

    // methods
    public String getMembershipType() {
        return MembershipType;
    }

    public void setMembershipType(String MembershipType) {
        this.MembershipType = MembershipType;
    }

    @Override
    public String toString() {
        return  "SingleMembers info " + super.toString() + ", MembershipType=" + MembershipType + "}\n"
                + "----------------------------------------------------------------";
    }
    
    

}
