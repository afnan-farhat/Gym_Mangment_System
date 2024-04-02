/*
NAME:  Afnan Tariq Farhat
IDs: 2105973
SECTION: B9A
Assignment number: 2
 */
package assignment2;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;

public class Registration {

    //data feilds
    private String RegistrationID;
    private Member member;
    private ArrayList<Service> service;
    private double LoyalityDiscount = 0;
    private double MemberDiscount = 0;
    private double finaltotalPrice = 0;

    // constructer
    public Registration(String RegistrationID, Member member, ArrayList<Service> service) {
        this.setRegistrationID(RegistrationID);
        this.setMember(member);
        this.setService(service);
    }

    // Methods
    public String getRegistrationID() {
        return RegistrationID;
    }

    public Member getMember() {
        return member;
    }

    public ArrayList<Service> getService() {
        return service;
    }

    public void setRegistrationID(String RegistrationID) {
        this.RegistrationID = RegistrationID;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setService(ArrayList<Service> service) {
        this.service = service;
    }

    public double gettOriginalPrice() {
        double OrginalTotalPrice = 0;
        for (int i = 0; i < this.getService().size(); i++) { // 4
            OrginalTotalPrice += this.getService().get(i).getPrice();
        }
        return OrginalTotalPrice;
    }

    public double getDiscount() {
        if (this.getMember() instanceof FamilyMember) {
            FamilyMember f = (FamilyMember) this.getMember();
            if (f.getFamily_Members_names().size() > 2) {
                this.MemberDiscount = 0.05;
            }
        }
        if (this.getMember() instanceof SingleMember) {
            SingleMember s = (SingleMember) this.getMember();
            if (s.getMembershipType().equalsIgnoreCase("VIP")) {
                this.MemberDiscount = 0.5;
            }
        }

        return this.MemberDiscount;
    }

    public double LoyalityDiscount() {
        LocalDate date = (this.getMember().getDateOfRegestration()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate curDate = LocalDate.now();

        Period period = date.until(curDate);

        double NoOfYears = period.getYears(); // 14 years 

        if (NoOfYears > 10) {
            this.LoyalityDiscount = 0.1;
        }
        return this.LoyalityDiscount;
    }

    public int getNumberOfDiscountservice() {
        if (this.getDiscount() == 0 && this.LoyalityDiscount() == 0) {
            return 0;
        }
        return this.service.size();
    }

    public double getFinalPrice(Service s) {
        //Normal Discount 
        double normal_discount = (s.getPrice() * this.getDiscount()); // 80
        // Loyality Discount
        double Loyality_discount = (s.getPrice() * this.LoyalityDiscount); //16

        return s.getPrice() - (normal_discount + Loyality_discount);
    }

    public double getFinalTotalPrice() {
        this.finaltotalPrice = 0;
        for (int i = 0; i < this.getService().size(); i++) { // 4
            this.finaltotalPrice += getFinalPrice(this.getService().get(i));
        }
        return this.finaltotalPrice;
    }

    public double getSavingAmount() {
        return (this.gettOriginalPrice() - this.getFinalTotalPrice());
    }

    @Override
    public String toString() {
        String reg
                = String.format("Number of discounted items:%o%n- Original Total Price:%.2f%n- Final Price:%.2f%n- Saving Amount:%.2f",
                        this.getNumberOfDiscountservice(), this.gettOriginalPrice(), this.getFinalTotalPrice(),
                        this.getSavingAmount());
        return reg;
    }

}
