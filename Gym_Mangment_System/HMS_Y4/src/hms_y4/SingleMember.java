package hms_y4;
public class SingleMember extends Member{
    private String MembershipType;
    public SingleMember(){
    }
    public String getMembershipType() {
        return MembershipType;
    }

    public void setMembershipType(String MembershipType) {
        this.MembershipType = MembershipType;
    }
    

    @Override
    public String toString() {
        return "SingleMembers info {"+super.toString()+", MembershipType=" + getMembershipType() + '}';
    }
    
}
