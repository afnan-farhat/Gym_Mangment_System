package hms_y4;
public class Class extends Service{
    private int capacity;
    private String Instructor;
    
    public Class(){
    }
    
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int Capacity) {
        capacity = Capacity;
    }

    public String getInstructor() {
        return Instructor;
    }

    public void setInstructor(String Instructor) {
        this.Instructor = Instructor;
    }
    @Override
    public int compareTo(Service o) {
        if(this.getPrice()==o.getPrice()){
            return 0;
        }
        if(this.getPrice()>o.getPrice()){
            return 1;
        }
        return -1;
    }  

    @Override
    public String toString() {
        return "Class{" +super.toString()+", capacity=" + getCapacity()+", Instructor=" + getInstructor() + '}';
    }    
}
