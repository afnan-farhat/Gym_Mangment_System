package hms_y4;
import java.util.ArrayList;
import java.util.Date;
public class Registeration {
    private String RegisterationID;
    private Member member;
    private ArrayList<Service> service;
    private double LoyalityDiscount = 0;
    private double MembersDiscount = 0;
    private double finaltotalPrice = 0;
    public Registeration(){
        service = new ArrayList<>();
    }
    public String getRegisterationID() {
        return RegisterationID;
    }

    public void setRegisterationID(String RegisterationID) {
        this.RegisterationID = RegisterationID;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public ArrayList<Service> getService() {
        return service;
    }

    public void setService(ArrayList<Service> service) {
        this.service = service;
    }
    
    public double getOriginalPrice() {
        double OriginalTotalPrice = 0;
        for(int i=0;i<=this.getService().size()-1;i++){
            OriginalTotalPrice += this.getService().get(i).getPrice();
        }
        return OriginalTotalPrice;
    }

    public double LoyalityDiscount() {
        if((new Date().getTime()-(this.getMember().getDateOfRegisteration()).getTime())/(1000l * 60 * 60 * 24 * 365)>10){
            this.LoyalityDiscount = .1;
        }
        return this.LoyalityDiscount;
    }
    
    public double getMemberDiscount() {
        if(this.getMember() instanceof SingleMember){
            SingleMember SM = (SingleMember)this.getMember();
            if(SM.getMembershipType().equalsIgnoreCase("VIP")){
                this.MembersDiscount = .5;   
            }
        }
        if(this.getMember() instanceof FamilyMember){
            FamilyMember FM = (FamilyMember)this.getMember();
            if(FM.getFamily_members_names().size()>2){
                this.MembersDiscount = .05;
            }
        }
       return this.MembersDiscount;
    }

    public double getFinalPrice(Service s) {
        return  s.getPrice()-(s.getPrice()*this.getMemberDiscount()+s.getPrice()*this.LoyalityDiscount());
    }
    
    public double getTotalFinalPrice() {
        this.finaltotalPrice =0;
        for(int i =0;i<=this.getService().size()-1;i++){
            this.finaltotalPrice += getFinalPrice(this.getService().get(i));
        }
        return this.finaltotalPrice;
    }

    public int getNumberOfDiscountservice() {
        if(this.getMemberDiscount() ==0 &&this.LoyalityDiscount()==0){
            return 0;
        }
        return this.service.size();
    }
    public double getSavingAmount(){
        return this.getOriginalPrice()-this.getTotalFinalPrice();
    }  
}
