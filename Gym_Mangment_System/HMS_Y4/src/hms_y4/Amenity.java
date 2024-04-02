package hms_y4;
public class Amenity extends Service{
    private String Amenity_type;
    private String Restriction;
    
    public Amenity(){
    }
    
    public String getAmenity_Type() {
        return Amenity_type;
    }

    public void setAmenity_Type(String Amenity_Type) {
        Amenity_type = Amenity_Type;
    }

    public String getRestriction() {
        return Restriction;
    }

    public void setRestriction(String Restriction) {
        this.Restriction = Restriction;
    }
    
    @Override
    public int compareTo(Service o) {
        if(this.getServiceName().compareTo(o.getServiceName())==0){
            return 0;
        }
        if(this.getServiceName().compareTo(o.getServiceName())>0){
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Amenity{" +super.toString()+", Amenity_type=" + getAmenity_Type()+", Restriction=" + getRestriction() + '}';
    }  
}
