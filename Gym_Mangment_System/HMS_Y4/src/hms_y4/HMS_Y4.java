package hms_y4;
import java.io.*;
import java.text.*;
import java.util.*;
public class HMS_Y4 {
    static SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy"); 
    static int SingleMemberID = 1000;
    static int FamilyMemberID = 2000;
    static int ClassID = 5000;
    static int AmenityID = 6000;
    static int RegisterNum = 0;
    static PrintWriter Output_PrintWiter;
    static String Location = null;
    static ArrayList<Member> members  = new ArrayList<>();
    static ArrayList<Service> services  = new ArrayList<>();
    static ArrayList<Registeration> registerations  = new ArrayList<>();
    static ArrayList<Service> registeredservices;
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        File input_File=new File("input.txt");
        if(input_File.exists() == true){
            Scanner InputScanner=new Scanner(input_File);
            File OutputFile=new File("Output.txt");
            Output_PrintWiter=new PrintWriter(OutputFile);
            Output_PrintWiter.println("--------------- Welcome to Gym Mangment System ---------------");
            
            while(InputScanner.hasNext()){
                String Command = InputScanner.next();
                switch (Command) {
                    case "Add_Single_Member":
                        Output_PrintWiter.println("Command Add_Single_Member was successfully completed");
                        String[] Inputs = InputScanner.nextLine().split(" ");
                        SingleMember Single_Member = new SingleMember();
                        Single_Member.setID(++SingleMemberID);
                        Single_Member.setName(Inputs[1]);
                        Single_Member.setGender(Inputs[2].charAt(0));
                        Single_Member.setDateOfBirth(formatter.parse(Inputs[3]));
                        Single_Member.setDateOfRegisteration(formatter.parse(Inputs[4]));
                        Single_Member.setAddress(Inputs[5]);
                        Single_Member.setPhone(Inputs[6]);
                        Single_Member.setMembershipType(Inputs[7]);
                        members.add(Single_Member);
                        Output_PrintWiter.println(Single_Member.toString());
                        Output_PrintWiter.println("----------------------------------------------------------------");
                        break;
                    case "Add_Family_Member":
                        Output_PrintWiter.println("Command Add_Family_Member was successfully completed");
                        Inputs = InputScanner.nextLine().split(" ");
                        FamilyMember Family_Member = new FamilyMember();
                        Family_Member.setID(++FamilyMemberID);
                        Family_Member.setName(Inputs[1]);
                        Family_Member.setGender(Inputs[2].charAt(0));
                        Family_Member.setDateOfBirth(formatter.parse(Inputs[3]));
                        Family_Member.setDateOfRegisteration(formatter.parse(Inputs[4]));
                        Family_Member.setAddress(Inputs[5]);
                        Family_Member.setPhone(Inputs[6]);
                        Family_Member.setFamily_members_names(new ArrayList<>(Arrays.asList(Inputs[7].split("/"))));
                        members.add(Family_Member);
                        Output_PrintWiter.println(Family_Member.toString());
                        Output_PrintWiter.println("----------------------------------------------------------------");
                        break;
                    case "Add_Class":
                        Output_PrintWiter.println("Command Add_Class was successfully completed");
                        Inputs = InputScanner.nextLine().split(" ");
                        Class  New_Class = new Class();
                        New_Class.setServiceID(++ClassID);
                        New_Class.setServiceName(Inputs[1]);
                        New_Class.setLocation(Inputs[2]);
                        New_Class.setPrice(Double.parseDouble(Inputs[3]));
                        New_Class.setCapacity(Integer.parseInt(Inputs[4]));
                        New_Class.setInstructor(Inputs[5]);
                        services.add(New_Class);
                        Output_PrintWiter.println(New_Class.toString());
                        Output_PrintWiter.println("----------------------------------------------------------------");
                        break;
                    case "Add_Amenity":
                        Output_PrintWiter.println("Command Add_Amenity was successfully completed");
                        Inputs = InputScanner.nextLine().split(" ");
                        Amenity amenity = new Amenity();
                        amenity.setServiceID(++AmenityID);
                        amenity.setServiceName(Inputs[1]);
                        amenity.setAmenity_Type(Inputs[2]);
                        amenity.setLocation(Inputs[3]);
                        amenity.setRestriction(Inputs[4]);
                        amenity.setPrice(Double.parseDouble(Inputs[5]));
                        services.add(amenity);
                        Output_PrintWiter.println(amenity.toString());
                        Output_PrintWiter.println("----------------------------------------------------------------");
                        break;
                    case "Register":
                        Member registeredmember = CheckMember(InputScanner.nextInt());
                        String CommandSubmit;
                        if(registeredmember == null){
                            Output_PrintWiter.println("the member does not exist in the system");
                            while(true){
                                CommandSubmit = InputScanner.next();
                                if(CommandSubmit.equals("submit")){
                                    break;
                                }
                                InputScanner.next();
                            }
                        }
                        if(registeredmember != null){
                            boolean ServiceFlag;
                            registeredservices  = new ArrayList<>();
                            while(true){
                                CommandSubmit = InputScanner.next();
                                if(CommandSubmit.equals("submit")){
                                    break;
                                }
                                String ServiceName = InputScanner.next();
                                ServiceFlag = CheckServiceAdd(registeredmember,ServiceName);
                                if(ServiceFlag == false){
                                    Output_PrintWiter.println("The requested service "+ServiceName+" does not exist in the system");
                                }   
                            }
                            Registeration registeration = new Registeration();
                            registeration.setRegisterationID(registeredmember.getID()+"00"+ (++RegisterNum));
                            registeration.setMember(registeredmember);
                            registeration.setService(registeredservices);
                            registerations.add(registeration);
                            Print_Recipet(registeration); 
                        }
                        break;
                    case "Print_Sort_Classes":
                        Collections.sort(services);
                        Output_PrintWiter.println("----------------------------------------- Classes Sorted By Price ------------------------------------------");
                        Output_PrintWiter.format("%-20s%-15s%-25s%-5s%n","Class name","Location","Instructor","Price");
                        Output_PrintWiter.println("----------------------------------------------------------------------------------------------------------------");
                        for(int i=0;i<=services.size()-1;i++){
                            if(services.get(i) instanceof Class){
                                Class classes = (Class)services.get(i);
                                Output_PrintWiter.format("%-20s%-15s%-25s%-5.1f%n",classes.getServiceName(),classes.getLocation(),classes.getInstructor(),classes.getPrice());
                            }
                        }   
                        Output_PrintWiter.println("----------------------------------------------------------------------------------------------------------------\n");
                        break;
                    case "Print_Sort_Amenities":
                        Collections.sort(services);
                        Output_PrintWiter.println("----------------------------------------- Amenities Sorted By Name ------------------------------------------");
                        Output_PrintWiter.format("%-20s%-15s%-25s%-5s%n","Amenity name","Location","Restriction","Price");
                        Output_PrintWiter.println("----------------------------------------------------------------------------------------------------------------");
                        for(int i=0;i<=services.size()-1;i++){
                            if(services.get(i) instanceof Amenity){
                                amenity = (Amenity)services.get(i);
                                Output_PrintWiter.format("%-20s%-15s%-25s%-5.1f%n",amenity.getServiceName(),amenity.getLocation(),amenity.getRestriction(),amenity.getPrice());
                            }
                        }   
                        Output_PrintWiter.println("----------------------------------------------------------------------------------------------------------------");
                        break;
                    case "Quit":
                        Output_PrintWiter.println("Thank you for using Gym Management System, Good Bye!");
                        Output_PrintWiter.close();
                        System.exit(0);
                    default:
                        break;     
                }
            }
        }
    }
    public static void Print_Recipet(Registeration registeration){
        Output_PrintWiter.println("------------------------- Invoice Details -------------------------");
        Output_PrintWiter.println("Registration Reference Number:"+registeration.getRegisterationID());
        Output_PrintWiter.println("Member ID:"+registeration.getMember().getID());
        Output_PrintWiter.println("Member name:"+registeration.getMember().getName());
        Output_PrintWiter.println("-------------------------------------------------------------------");
        Output_PrintWiter.format("%-25s%-15s%-15s%-15s%n","Service","Original_Price","Discount","Final_price");
        for(int i=0;i<=registeration.getService().size()-1;i++){
            Output_PrintWiter.format("%-25s%-15.2f%.1f%%%15.2f%n",registeration.getService().get(i).getServiceName(),registeration.getService().get(i).getPrice(),registeration.getMemberDiscount()*100+registeration.LoyalityDiscount()*100,registeration.getFinalPrice(registeration.getService().get(i)));
        }
        Output_PrintWiter.println("-------------------------------------------------------------------");
        Output_PrintWiter.printf("Number of discounted items: %d%n- Original Total Price: %.2f%n- Final Price: %.2f%n- Saving Amount: %.2f%n",registeration.getNumberOfDiscountservice(),registeration.getOriginalPrice(),registeration.getTotalFinalPrice(),registeration.getSavingAmount());
        Output_PrintWiter.println("-------------------------------------------------------------------");  
    }
    public static Member CheckMember(int MemberID){
        Member registeredmember = null;
        for(int i =0;i<=members.size()-1;i++){
            if(members.get(i).getID() == MemberID){
                registeredmember = members.get(i);
                if(registeredmember.getGender() == 'F'){
                    Location = "Female-branch";
                }else{
                    Location = "Male-branch";
                }
            }
        }
        return registeredmember;
    }
    public static boolean CheckServiceAdd(Member registeredmember,String ServiceName){
        for ( int j=0;j<=services.size()-1;j++){
            if((ServiceName.equalsIgnoreCase(services.get(j).getServiceName()))){
                if((services.get(j).getLocation().equalsIgnoreCase(Location))){
                    if(ServiceName.equalsIgnoreCase("Sauna")){
                        if((((registeredmember.getDateOfRegisteration()).getTime())-((registeredmember.getDateOfBirth()).getTime()))/ (1000l * 60 * 60 * 24 * 365)<18){
                            Output_PrintWiter.println("The requested service Sauna is not allowed for members below 18 years old");
                            return true;
                        }
                    }
                    if(ServiceName.equalsIgnoreCase("Daycare")){ 
                        if(registeredmember instanceof SingleMember){
                            Output_PrintWiter.println("The requested service Daycare is not allowed for Single members");
                            return true;
                        }
                    }
                    registeredservices.add(services.get(j));
                    return true;
                }
            }
        }
        return false;
    } 
}

