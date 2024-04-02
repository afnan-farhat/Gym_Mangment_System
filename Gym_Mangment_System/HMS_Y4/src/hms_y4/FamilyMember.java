package hms_y4;
import java.util.ArrayList;
import java.util.Arrays;
public class FamilyMember extends Member{
    private ArrayList<String> Family_members_names;
    public FamilyMember(){
    }
    
    public ArrayList<String> getFamily_members_names() {
        return Family_members_names;
    }

    public void setFamily_members_names(ArrayList<String> Family_members_names) {
        this.Family_members_names = Family_members_names;
    }

    @Override
    public String toString() {
        return "FamilyMembers{" +super.toString()+", Family_members_names="+Arrays.toString(getFamily_members_names().toArray())+"}";
    }   
}
