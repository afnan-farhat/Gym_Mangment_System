/*
NAME:  Afnan Tariq Farhat
IDs: 2105973
SECTION: B9A
Assignment number: 2
 */
package assignment2;

public class Class extends Service implements Comparable <Service>{

    //data feilds
    private int capacity;
    private String Instructor;

    // constructer
    public Class(String ServiceID, String ServiceName, String Location, double Price, int capacity, String Instructor) {
        super(ServiceID, ServiceName, Location, Price);
        this.capacity = capacity;
        this.Instructor = Instructor;
    }

    // methods
    public int getCapacity() {
        return capacity;
    }

    public String getInstructor() {
        return Instructor;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setInstructor(String Instructor) {
        this.Instructor = Instructor;
    }

    @Override
    public String toString() {

        return "Command Add_Class was successfully completed \n"
                + "Class{ServiceID=" + super.getServiceID() + ", ServiceName="
                + super.getServiceName() + ", Location=" + super.getLocation() + ", Price=" + super.getPrice()
                + ", capacity=" + capacity + ", Instructor=" + Instructor + "}\n"
                + "----------------------------------------------------------------";
    }

    @Override
    public int compareTo(Service o) {
        if (this.getPrice() > o.getPrice()) {
            return 1;
        } else if (this.getPrice() < o.getPrice()) {
            return -1;
        } else {
            return 0;
        }
    }

}
