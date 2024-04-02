package hms_y4;
public abstract class Service implements Comparable<Service>{
    private int ServiceID;
    private String ServiceName;
    private String Location;
    private double Price;
    public Service(){
    }
    public int getServiceID() {
        return ServiceID;
    }

    public void setServiceID(int ServiceID) {
        this.ServiceID = ServiceID;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String ServiceName) {
        this.ServiceName = ServiceName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    @Override
    public String toString() {
        return  "ServiceID=" + getServiceID() +", ServiceName=" + getServiceName()+", Location=" + getLocation()+", Price=" + getPrice();
    }
    
    
}
