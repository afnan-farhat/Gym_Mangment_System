package hms_y4;
import java.text.SimpleDateFormat;
import java.util.Date;
public abstract class Member {
    private int ID;
    private String Name;
    private char Gender;
    private Date DateOfBirth;
    private Date DateOfRegisteration;
    private String Address;
    private String Phone;
    public Member(){
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public char getGender() {
        return Gender;
    }

    public void setGender(char Gender) {
        this.Gender = Gender;
    }

    public Date getDateOfBirth() {
        return this.DateOfBirth;
    }

    public void setDateOfBirth(Date DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public Date getDateOfRegisteration() {
        return DateOfRegisteration;
    }

    public void setDateOfRegisteration(Date DateOfRegisteration) {
        this.DateOfRegisteration = DateOfRegisteration;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    @Override
    public String toString() {
        return "ID=" + getID()+", Name=" + getName()+", Gender=" + getGender()+", DateOfBirth=" +DateToString(getDateOfBirth())+", DateOfRegisteration=" + DateToString(getDateOfRegisteration())+", Address=" + this.getAddress()+", Phone=" + this.getPhone();
    }
    public static String DateToString(Date date){
        return new SimpleDateFormat("dd/MM/YYYY").format(date);
    }   
}
