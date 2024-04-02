package hms_y4;

import java.io.*; //File & FileNotFoundException & PrintWriter
import java.text.*; // ParseException & SimpleDateFormat
import java.util.*; // ArrayList & Date & Scanner

public class test {

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");
// c
        Scanner input = new Scanner(inputFile);

        Scanner inputSingleMember = new Scanner(inputFile);
        PrintWriter pen1 = new PrintWriter(outputFile);

        // Check whether or not inputPrint exist
        if (!inputFile.exists()) {
            System.out.println("The file does not exists, so the reading process failed");
            System.exit(0);
        }

        // Part 4: The number of Amenities
        Scanner inputRegister = new Scanner(inputFile);
        int RegisterCounter = 0;
        while (inputRegister.hasNextLine()) { // 13
            Scanner info = new Scanner(inputRegister.nextLine()); //read other lines in first file 
            if (info.next().equalsIgnoreCase("Register")) {
                RegisterCounter++;
            }
        } // end while 

        int SingleMemberCounter = 0;
        while (inputSingleMember.hasNextLine()) {
            Scanner info = new Scanner(inputSingleMember.nextLine());
            if (info.next().equalsIgnoreCase("Add_Single_Member")) {
                SingleMemberCounter++;
            }

        } // end while    

        Scanner inputFamilyMember = new Scanner(inputFile);

        int FamilyMemberCounter = 0;
        while (inputFamilyMember.hasNextLine()) {
            Scanner info = new Scanner(inputFamilyMember.nextLine());
            if (info.next().equalsIgnoreCase("Add_Family_Member")) {
                FamilyMemberCounter++;
            }
        } // end while 

//        
//        
//        FamilyMember[] listFamilyMember = new FamilyMember[FamilyMemberCounter];
//        Member f = null;
//
//        for (int i = 0; i < FamilyMemberCounter; i++) {
//            while (input.hasNextLine()) {
//                Scanner info = new Scanner(input.nextLine());
//
//                while (info.next().equalsIgnoreCase("Add_Family_Member")) {
//
//                    while (input.hasNext()) {
//
//                        String ID = "2001";
//                        String Name = input.next();
//
//                        String Gender_S = input.next();
//                        char Gender = Gender_S.charAt(0);
//
//                        String DateOfBirth_s = input.next();
//                        String DateOfRegestration_s = input.next();
//                        String Address = input.next();
//                        String Phone = input.next();
//
//                        // Add Family member to ArrayList
//                        ArrayList<String> Family_members = new ArrayList<String>();
//                        Family_members.add(input.next());
//
//                        f = new FamilyMember(ID, Name, Gender, StringToDate(DateOfBirth_s), StringToDate(DateOfRegestration_s), Address, Phone, Family_members);
//
////                    FamilyMember f = getFamilyMember(info, FamilyMemberCounter);
//                        listFamilyMember[i] = f;
//                        //print this values
//                        //( HERE X ) PrintReceipt(Registration reg, fWrite);
//                        i++;
//                        pen1.println();
//                        break;
//                    }// while GenerateInvoice
//
//                }// end nasted while loop 
//
//            }// end while loop
//            // change from FamilyMember to Member class
//
//        }
        Scanner inputClass = new Scanner(inputFile);

        // Part 3: The of classes
        int ClassCounter = 0;
        while (inputClass.hasNextLine()) {
            Scanner info = new Scanner(inputClass.nextLine()); //read other lines in first file 
            if (info.next().equalsIgnoreCase("Add_Class")) {
                ClassCounter++;
            }
        } // end while 
        Scanner inputAmenity = new Scanner(inputFile);

        int AmenityCounter = 0;
        while (inputAmenity.hasNextLine()) {
            Scanner info = new Scanner(inputAmenity.nextLine()); //read other lines in first file 
            if (info.next().equalsIgnoreCase("Add_Amenity")) {
                AmenityCounter++;
            }
        } // end while 

        System.out.println("Single Member Counter is: " + SingleMemberCounter);
        System.out.println("Family Member Counter is: " + FamilyMemberCounter);
        System.out.println("Class Counter is: " + ClassCounter);
        System.out.println("Amenity Counter is: " + AmenityCounter);
        System.out.println("Register Counter is: " + RegisterCounter);

// ________________________________________________________________________________________________
////PART 2:
//
//        Scanner inputRegistration = new Scanner(inputFile);
//
//        Registration[] listRegistration = new Registration[3];
//        ArrayList<String> ServiceName = new ArrayList<String>();
//
//        String MemberID = "";
//
//        for (int i = 0; i < 3; i++) {
//            while (inputRegistration.hasNextLine()) {
//                Scanner info = new Scanner(inputRegistration.nextLine());
//                //while (!info.next().equalsIgnoreCase("submit")) {
//                    if (info.next().equalsIgnoreCase("Register")) {
//                        MemberID = info.next();
//                    }
//                    while (info.next().equalsIgnoreCase("In") || info.next().equalsIgnoreCase("And")) {
//                        //StringBuilder sb = new StringBuilder(info.next());
//                        ServiceName.add(info.next());
//                    }
//                    Registration r = new Registration ( MemberID ,  MemberID, ServiceName);
//                    listRegistration[i] = r;
//                    System.out.println("MemberID: " + MemberID + "\nServiceName:" + ServiceName);
//                    i++;
//                //} // end submit loop
//
//            } //end while 
//        }
//        
    }

    public static Date StringToDate(String s) throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(s);

        return date;
    }

    public static String DateToString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String string = format.format(date);
        return string;
    }
}
