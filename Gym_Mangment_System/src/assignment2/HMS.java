/*
NAME:  Afnan Tariq Farhat
IDs: 2105973
SECTION: B9A
Assignment number: 2
 */
package assignment2;

import java.io.*; // File & FileNotFoundException & PrintWriter & 
import java.text.*; // ParseException & SimpleDateFormat
import java.util.*; // Collection & Scanner & ArrayList & Arrays & Date

public class HMS {

    // ID of all service and member  
    private static int SingleMemberID = 1000;
    private static int FamilyMemberID = 2000;
    private static int ClassID = 5000;
    private static int AmenityID = 6000;
    private static int RegisterNum = 0;

    // 2 ArrayList ti service & member  & serviceNames & registrations
    private static ArrayList<Member> member = new ArrayList<>();
    private static ArrayList<Service> service = new ArrayList<>();
    private static ArrayList<Service> ServiceNames;
    private static ArrayList<Registration> registrations = new ArrayList<>();

    // Counters for all classes
    private static int SingleMemberCounter; // 5
    private static int FamilyMemberCounter; // 5
    private static int ClassCounter; // 16
    private static int AmenityCounter; // 13
    private static int RegisterCounter;

    // List all service to using printSortedClass & printSortedAmenity
    private static Class[] listClass;
    private static Amenity[] listAmenity;

    // Location eigther Female or Male
    private static String Location = null;

    // Main Method
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        // Step 1: Read & Write on files
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");

        Scanner input = new Scanner(inputFile);
        PrintWriter fWrite = new PrintWriter(outputFile);

        // Check whether or not inputFile exist
        if (!inputFile.exists()) {
            System.out.println("The file does not exists, so the reading process failed");
            System.exit(0);
        }
        //################################################################################
        // Step 2: Calculate all counters
        String heading = "------------------- Welcome to Gym Mangment System -------------------";
        System.out.println(heading);
        fWrite.println(heading);

        // Part 1: The number of Single Members
        Scanner inputSingleMember_counter = new Scanner(inputFile);
        SingleMemberCounter = 0;
        while (inputSingleMember_counter.hasNextLine()) { // 5
            Scanner info = new Scanner(inputSingleMember_counter.nextLine());
            if (info.next().equalsIgnoreCase("Add_Single_Member")) {
                SingleMemberCounter++;
            }
        } // end while   

        // Part 2: The number of Family Members
        Scanner inputFamilyMember_counter = new Scanner(inputFile);
        FamilyMemberCounter = 0;
        while (inputFamilyMember_counter.hasNextLine()) { // 5
            Scanner info = new Scanner(inputFamilyMember_counter.nextLine());
            if (info.next().equalsIgnoreCase("Add_Family_Member")) {
                FamilyMemberCounter++;
            }
        } // end while 

        // Part 3: The number of Classes
        Scanner inputClass_counter = new Scanner(inputFile);
        ClassCounter = 0;
        while (inputClass_counter.hasNextLine()) { // 16
            Scanner info = new Scanner(inputClass_counter.nextLine()); //read other lines in first file 
            if (info.next().equalsIgnoreCase("Add_Class")) {
                ClassCounter++;
            }
        } // end while 

        // Part 4: The number of Amenities
        Scanner inputAmenity_counter = new Scanner(inputFile);
        AmenityCounter = 0;
        while (inputAmenity_counter.hasNextLine()) { // 13
            Scanner info = new Scanner(inputAmenity_counter.nextLine()); //read other lines in first file 
            if (info.next().equalsIgnoreCase("Add_Amenity")) {
                AmenityCounter++;
            }
        } // end while 

        // Part 5: The number of Registraction
        Scanner inputRegister_counter = new Scanner(inputFile);
        RegisterCounter = 0;
        while (inputRegister_counter.hasNextLine()) { // 5
            Scanner info = new Scanner(inputRegister_counter.nextLine()); //read other lines in first file 
            if (info.next().equalsIgnoreCase("Register")) {
                RegisterCounter++;
            }
        } // end while 

        //Close all input Scanner 
        inputSingleMember_counter.close();
        inputFamilyMember_counter.close();
        inputClass_counter.close();
        inputAmenity_counter.close();
        inputRegister_counter.close();

        //################################################################################
        // Step 3: Call other methods & classes 
        // Part 1: Calling Single Member Classes
        Scanner inputSingleMember = new Scanner(inputFile);
        for (int i = 0; i < SingleMemberCounter; i++) {
            while (inputSingleMember.hasNextLine()) {
                Scanner info = new Scanner(inputSingleMember.nextLine());

                while (info.next().equalsIgnoreCase("Add_Single_Member")) {

                    SingleMember s = getSingleMember(info);
                    member.add(s);
                    //Print value
                    System.out.println(s.toString());
                    fWrite.println(s.toString());

                    i++;
                    break;
                }// while GenerateInvoice

            }// end nasted while loop 

        }// end while loop
        inputSingleMember.close();

        //----------------------------------------------------
        // Part 2: Calling Family Member Classes
        Scanner inputFamilyMember = new Scanner(inputFile);
        for (int i = 0; i < FamilyMemberCounter; i++) {
            while (inputFamilyMember.hasNextLine()) {

                Scanner info = new Scanner(inputFamilyMember.nextLine());

                while (info.next().equalsIgnoreCase("Add_Family_Member")) {
                    FamilyMember f = getFamilyMember(info);
                    member.add(f);

                    //Print value
                    System.out.println(f.toString());
                    fWrite.println(f.toString());

                    i++;
                    break;
                }// while GenerateInvoice

            }// end nasted while loop 

        }// end while loop
        inputFamilyMember.close();

        //----------------------------------------------------
        // Part 3: Calling Class service 
        Scanner inputClass = new Scanner(inputFile);
        listClass = new Class[ClassCounter];

        for (int i = 0; i < ClassCounter; i++) {
            while (inputClass.hasNextLine()) {
                Scanner info = new Scanner(inputClass.nextLine());

                while (info.next().equalsIgnoreCase("Add_Class")) {

                    Class c = getClass(info);
                    service.add(c);

                    //Print value
                    System.out.println(c.toString());
                    fWrite.println(c.toString());

                    i++;
                    break;
                }// while GenerateInvoice

            }// end nasted while loop 

        }// end while loop
        inputClass.close();
        
        //----------------------------------------------------
        // Part 5: Calling Amenity service 
        Scanner inputAmenity = new Scanner(inputFile);
        listAmenity = new Amenity[AmenityCounter];

        for (int j = 0; j < AmenityCounter; j++) {
            while (inputAmenity.hasNextLine()) {
                Scanner info = new Scanner(inputAmenity.nextLine());

                while (info.next().equalsIgnoreCase("Add_Amenity")) {

                    Amenity a = getAmenityMember(info);
                    service.add(a);

                    //Print value
                    System.out.println(a.toString());
                    fWrite.println(a.toString());

                    j++;
                    break;
                }// while GenerateInvoice

            }// end nasted while loop 

        }// end while loop
        inputAmenity.close();

        //################################################################################
        //Step 4: Read all Registrationsge
        Scanner inputRegister = new Scanner(inputFile);
        for (int i = 0; i < RegisterCounter; i++) {
            while (inputRegister.hasNextLine()) {
                Scanner info = new Scanner(inputRegister.nextLine());

                while (info.next().equalsIgnoreCase("Register")) {
                    Member registerMember = CheckMember(info.next());
                    String headingSubmit;

                    // Member does not exist
                    if (registerMember == null) {
                        System.out.println("the member does not exist in the syetem");
                        while (true) {
                            Scanner inputSubmit = new Scanner(inputRegister.nextLine());

                            headingSubmit = inputSubmit.next();
                            if (headingSubmit.equalsIgnoreCase("submit")) {
                                break;
                            }
                            inputSubmit.next();
                        }
                    } // Member exists
                    if (registerMember != null) {
                        boolean ServiceFlag;
                        ServiceNames = new ArrayList<>();

                        while (true) {
                            Scanner inputServiceName = new Scanner(inputRegister.nextLine());

                            headingSubmit = inputServiceName.next();
                            // check

                            if (headingSubmit.equals("submit")) {
                                break;
                            }
                            String ServiceName = inputServiceName.next();
                            ServiceFlag = CheckServiceAdd(registerMember, ServiceName, fWrite);
                            if (ServiceFlag == false) {
                                System.out.println("The requested service " + ServiceName + " does not exist in the system");
                                fWrite.println("The requested service " + ServiceName + " does not exist in the system");
                            }
                        }
                        String RegisterID = registerMember.getID() + "00" + (++RegisterNum); //1001001
                        Registration registeration = new Registration(RegisterID, registerMember, ServiceNames);
                        registrations.add(registeration);

                        PrintReceipt(registeration, i, fWrite);
                    }
                    i++;
                    break;
                }
            }
        } //end while 
        inputRegister.close();
        
        //################################################################################
        // Step 5: Print Sorted Availables Services
        // Part 1: Print Sorted Classes
        Scanner inputSortClass = new Scanner(inputFile);
        while (inputSortClass.hasNextLine()) {
            Scanner info = new Scanner(inputSortClass.nextLine());
            while (info.next().equalsIgnoreCase("Print_Sort_Classes")) {
                PrintSortClass(service, fWrite);
                break;
            }
        }
        inputSortClass.close();
        System.out.println();
        fWrite.println();
        
        //----------------------------------------------------
        // Part 2: Print Sorted Amenities
        Scanner inputSortAmenity = new Scanner(inputFile);
        while (inputSortAmenity.hasNextLine()) {
            Scanner info = new Scanner(inputSortAmenity.nextLine());
            while (info.next().equalsIgnoreCase("Print_Sort_Amenities")) {
                PrintSortAmenity(service, fWrite);
                break;
            }
        }
        inputSortAmenity.close();
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        fWrite.println( "----------------------------------------------------------------------------------------------------------------");

        //----------------------------------------------------
        // Part 3: end the program, if you read "Quit"
        while (input.hasNextLine()) {
            Scanner lastLine = new Scanner(input.nextLine());
            if (lastLine.next().equalsIgnoreCase("Quit")) {
                System.out.println("Thank you for using Gym Management System, Good Bye! ");
                fWrite.println("Thank you for using Gym Management System, Good Bye! ");
            }
        }
        input.close();
        fWrite.close();

    } // End Main

    
    //############################################################################
    //METODS
    public static void PrintReceipt(Registration reg1, int counterReg, PrintWriter pen) {
        Registration reg = reg1;
        String dicreteLine = "-------------------------------------------------------------------";

        System.out.println("------------------------- Invoice Details -------------------------");
        pen.println("------------------------- Invoice Details -------------------------");
        System.out.println("Registration Reference Number:" + reg.getRegistrationID());
        pen.println("Registration Reference Number:" + reg.getRegistrationID());
        System.out.println("Member ID:" + reg.getMember().getID());
        pen.println("Member ID:" + reg.getMember().getID());
        System.out.println("Member name:" + reg.getMember().getName());
        pen.println("Member name:" + reg.getMember().getName());
        System.out.println(dicreteLine);
        pen.println(dicreteLine);
        System.out.printf("%-27s%-26s%-26s%-26s%n", "Service", "Original_Price",
                "Discount", "Final_price");
        pen.printf("%-27s%-26s%-26s%-26s%n", "Service", "Original_Price",
                "Discount", "Final_price");

        for (int i = 0; i < reg.getService().size(); i++) { // 4, 
            System.out.printf("%-27s%-26.2f%-26s%-26.2f%n", reg.getService().get(i).getServiceName(), reg.getService().get(i).getPrice(),
                    reg.getDiscount() * 100 + reg.LoyalityDiscount() * 100 + "%", reg.getFinalPrice(reg.getService().get(i)));
            pen.printf("%-27s%-26.2f%-26s%-26.2f%n", reg.getService().get(i).getServiceName(), reg.getService().get(i).getPrice(),
                    reg.getDiscount() * 100 + reg.LoyalityDiscount() * 100, reg.getFinalPrice(reg.getService().get(i)));
        }

        System.out.println(dicreteLine);
        pen.println(dicreteLine);
        System.out.println(reg.toString());
        pen.println(reg.toString());
        System.out.println(dicreteLine + "\n\n");
        pen.println(dicreteLine + "\n\n");

    } // end PrintReceipt

    private static SingleMember getSingleMember(Scanner input) throws ParseException {
        SingleMember s = null;
        while (input.hasNext()) {
            String MemberID = Integer.toString(++SingleMemberID);
            String Name = input.next();

            String Gender_S = input.next();
            char Gender = Gender_S.charAt(0);

            Date DateOfBirth = StringToDate(input.next());
            Date DateOfRegestration = StringToDate(input.next());

            String Address = input.next();
            String Phone = input.next();
            String MembershipType = input.next();

            s = new SingleMember(MemberID, Name, Gender, DateOfBirth, DateOfRegestration, Address, Phone, MembershipType);
        }
        return s;
    } // end getSingleMember

    private static FamilyMember getFamilyMember(Scanner input) throws ParseException {
        // change from FamilyMember to Member class
        FamilyMember f = null;
        while (input.hasNext()) {
            String ID = Integer.toString(++FamilyMemberID);
            String Name = input.next();

            String Gender_S = input.next();
            char Gender = Gender_S.charAt(0);

            Date DateOfBirth = StringToDate(input.next());
            Date DateOfRegestration = StringToDate(input.next());

            String Address = input.next();
            String Phone = input.next();

            // Add Family member to ArrayList
            ArrayList<String> Family_members = new ArrayList<>(Arrays.asList(input.next().split("/")));

            f = new FamilyMember(ID, Name, Gender, DateOfBirth, DateOfRegestration, Address, Phone, Family_members);
        }
        return f;
    } // end getFamilyMember

    private static Class getClass(Scanner input) {
        Class c = null;
        while (input.hasNext()) {
            String ServiceID = Integer.toString(++ClassID);

            String ServiceName = input.next();
            String location = input.next();
            double Price = input.nextDouble();
            int Capacity = input.nextInt();
            String Instructor = input.next();
            c = new Class(ServiceID, ServiceName, location, Price, Capacity, Instructor);
        }
        return c;
    } // end getClass

    private static Amenity getAmenityMember(Scanner input) {
        Amenity a = null;
        while (input.hasNext()) {
            String ServiceID = Integer.toString(++AmenityID);
            String AmenityName = input.next();
            String AmenityType = input.next();
            String location = input.next();
            String Restrication = input.next();
            double Price = input.nextDouble();
            a = new Amenity(ServiceID, AmenityName, location, Price, AmenityType, Restrication);
        }
        return a;
    } // end getAmenityMember

    public static Date StringToDate(String s) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy").parse(s);
    } // end StringToDate

    public static String DateToString(Date date) {
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    } // end DateToString

    public static Member CheckMember(String MemberID) {
        Member registerMember = null;
        for (int i = 0; i < member.size(); i++) { // 10
            if (member.get(i).getID().equals(MemberID)) {
                registerMember = member.get(i);
                if (registerMember.getGender() == 'F') {
                    Location = "Female-branch";
                } else {
                    Location = "Male-branch";
                }
            }
        }
        return registerMember;

    } // end CheckMember

    public static boolean CheckServiceAdd(Member registerMember, String ServiceName, PrintWriter pen) {
        for (int j = 0; j < service.size(); j++) { //29
            if ((ServiceName.equalsIgnoreCase(service.get(j).getServiceName()))) {
                if ((service.get(j).getLocation().equalsIgnoreCase(Location))) {
                    if (ServiceName.equalsIgnoreCase("Sauna")) {
                        if (CalculateYears(registerMember) < 18) {
                            pen.println("The requested service Sauna is not allowed for members below 18 years old");
                            return true;
                        }
                    }
                    if (ServiceName.equalsIgnoreCase("Daycare")) {
                        if (registerMember instanceof SingleMember) {
                            System.out.println("The requested service Daycare is not allowed for Single members");
                            pen.println("The requested service Daycare is not allowed for Single members");
                            return true;
                        }
                    }
                    ServiceNames.add(service.get(j));
                    return true;
                }
            }
        }
        return false;
    } //  end CheckServiceAdd

    public static void PrintSortClass(ArrayList arrayListClass, PrintWriter pen) {
        Collections.sort(arrayListClass);

        System.out.println("\n----------------------------------------- Classes Sorted By Price ------------------------------------------");
        pen.println("\n----------------------------------------- Classes Sorted By Price ------------------------------------------");
        System.out.printf("%-27s%-26s%-26s%-26s%n", "Class name", "Location", "Instructor", "Price");
        pen.printf("%-27s%-26s%-26s%-26s%n", "Class name", "Location", "Instructor", "Price");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        pen.println("----------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < arrayListClass.size(); i++) {
            if (arrayListClass.get(i) instanceof Class) {
                Class tempClass = (Class) arrayListClass.get(i);

                System.out.printf("%-27s%-26s%-26s%-26s%n", tempClass.getServiceName(), tempClass.getLocation(),
                        tempClass.getInstructor(), tempClass.getPrice());
                pen.printf("%-27s%-26s%-26s%-26s%n", tempClass.getServiceName(), tempClass.getLocation(),
                        tempClass.getInstructor(), tempClass.getPrice());
            }
        }
    } // end PrintSortClass

    public static void PrintSortAmenity(ArrayList arrayListAmenity, PrintWriter pen) {
        Collections.sort(arrayListAmenity);

        System.out.println("----------------------------------------- Amenities Sorted By Name ------------------------------------------");
        pen.println("----------------------------------------- Amenities Sorted By Name ------------------------------------------");
        System.out.printf("%-27s%-26s%-26s%-26s%n", "Amentiy name", "Location", "Restriction", "Price");
        pen.printf("%-27s%-26s%-26s%-26s%n", "Amentiy name", "Location", "Restriction", "Price");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        pen.println("----------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < arrayListAmenity.size(); i++) {
            if (arrayListAmenity.get(i) instanceof Amenity) {
                Amenity tempAmenity = (Amenity) arrayListAmenity.get(i);

                System.out.printf("%-27s%-26s%-26s%-26s%n", tempAmenity.getServiceName(), tempAmenity.getLocation(),
                        tempAmenity.getRestricition(), tempAmenity.getPrice());
                pen.printf("%-27s%-26s%-26s%-26s%n", tempAmenity.getServiceName(), tempAmenity.getLocation(),
                        tempAmenity.getRestricition(), tempAmenity.getPrice());
            }
        }
    } // end PrintSortAmenity

    public static double CalculateYears(Member registerMember) {
        double noOfRegestrationYeats = (registerMember.getDateOfRegestration().getTime());
        double noOfBirthYears = (registerMember.getDateOfBirth().getTime());
        double noOfYears = (noOfRegestrationYeats - noOfBirthYears) / (1000l * 60 * 60 * 24 * 365);

        return noOfYears;
    } // end CalculateYears
}
