/*
NAME:  Afnan Tariq Farhat
IDs: 2105973
SECTION: B9A
Assignment number: 2
 */
package assignment2;

public class Amenity extends Service implements Comparable <Service>{

    //data feilds 
    private String Amentiy_type;
    private String Restricition;

    // constructer 
    public Amenity(String ServiceID, String ServiceName, String Location, double Price, String Amentiy_type, String Restricition) {
        super(ServiceID, ServiceName, Location, Price);
        this.Amentiy_type = Amentiy_type;
        this.Restricition = Restricition;
    }

    //methods
    public String getAmentiy_type() {
        return this.Amentiy_type;
    }

    public void setAmentiy_type(String Amentiy_type) {
        this.Amentiy_type = Amentiy_type;
    }

    public String getRestricition() {
        return this.Restricition;
    }

    public void setRestricition(String Restricition) {
        this.Restricition = Restricition;

    }

    @Override
    public String toString() {
        return "Command Add_Amenity was successfully completed \n"
                + "Amenity{ServiceID=" + super.getServiceID() + ", ServiceName="
                + super.getServiceName() + ", Location=" + super.getLocation() + ", Price=" + super.getPrice()
                + ", Amentiy_type=" + Amentiy_type + ", Restricition=" + Restricition + "}\n"
                + "----------------------------------------------------------------";
    }

    @Override
    public int compareTo(Service s) {
        if (this.getServiceName().compareTo(s.getServiceName()) > 0) {
            return 1;
        } else if (this.getServiceName().compareTo(s.getServiceName()) < 0) {
            return -1;
        } else {
            return 0;
        }
    }

}
