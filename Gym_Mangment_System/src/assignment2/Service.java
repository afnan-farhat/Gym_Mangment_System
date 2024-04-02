/*
NAME:  Afnan Tariq Farhat
IDs: 2105973
SECTION: B9A
Assignment number: 2
 */
package assignment2;

public abstract class Service {

    //data feilds 
    private String ServiceID;
    private String ServiceName;
    private String Location;
    private double Price;

    // constructer 
    public Service(String ServiceID, String ServiceName, String Location, double Price) {
        this.setServiceID(ServiceID);
        this.setServiceName(ServiceName);
        this.setLocation(Location);
        this.setPrice(Price);
    }

    //methods
    public String getServiceID() {
        return ServiceID;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public String getLocation() {
        return Location;
    }

    public double getPrice() {
        return Price;
    }

    public void setServiceID(String ServiceID) {
        this.ServiceID = ServiceID;
    }

    public void setServiceName(String ServiceName) {
        this.ServiceName = ServiceName;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }
}
