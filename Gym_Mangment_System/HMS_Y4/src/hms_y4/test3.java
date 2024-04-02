/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hms_y4;

import assignment2.Amenity;
import assignment2.Class;
import assignment2.FamilyMember;
import assignment2.Member;
import assignment2.Registration;
import assignment2.Service;
import assignment2.SingleMember;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Afnan
 */
public class test3 {

    private static ArrayList<Member> member = new ArrayList<Member>();
    private static ArrayList<Service> service = new ArrayList<Service>();

    private static int SingleMemberCounter;
    // All arrays do not necessary (Delete)
    //listSingleMember & listFamilyMember, but do not delete listClass & listAmenity
    private static SingleMember[] listSingleMember;

    private static int FamilyMemberCounter;
    private static FamilyMember[] listFamilyMember;

    private static int ClassCounter;
    private static Class[] listClass;

    private static int AmenityCounter;
    private static Amenity[] listAmenity;

    private static int RegisterCounter;
    private static Registration[] listRegistration;

    static String Location = null;
    private static ArrayList<Service> RegisterService;
    private static ArrayList<Registration> registrations;

    // methods
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        // Step 1: Read & Write on files
        System.out.println("nn");
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
        // Step 2: Calculate all counters & Call other methods
        // Part 1: The number of Single Members
        String heading = "------------------- Welcome to Gym Mangment System -------------------";
        System.out.println(heading);
        fWrite.println(heading);

        Scanner inputSingleMember_counter = new Scanner(inputFile);
        SingleMemberCounter = 0;
        while (inputSingleMember_counter.hasNextLine()) { // 5
            Scanner info = new Scanner(inputSingleMember_counter.nextLine());
            if (info.next().equalsIgnoreCase("Add_Single_Member")) {
                SingleMemberCounter++;
            }
        } // end while   
        System.out.println("SingleMemberCounter = " + SingleMemberCounter);
        Scanner inputSingleMember = new Scanner(inputFile);

        for (int i = 0; i < SingleMemberCounter; i++) {
            System.out.println("f");
            while (inputSingleMember.hasNextLine()) {
                Scanner info = new Scanner(inputSingleMember.nextLine());
                System.out.println("b");
                if (info.next().equalsIgnoreCase("Add_Single_Member")) {
                    System.out.println("bc");
                    SingleMember s = getSingleMember(info, i + 1);
                    member.add(s);
                    //Print value
                    System.out.println(member.get(i));
                    fWrite.println(member.get(i));

                    i++;
                    fWrite.println();
                    break;
                }// while GenerateInvoice

            }// end nasted while loop 

        }// end while loop
        inputSingleMember_counter.close();
        inputSingleMember.close();

        //----------------------------------------------------
        // Part 2: The number of Family Members
        Scanner inputFamilyMember_counter = new Scanner(inputFile);
        FamilyMemberCounter = 0;
        while (inputFamilyMember_counter.hasNextLine()) { // 5
            Scanner info = new Scanner(inputFamilyMember_counter.nextLine());
            if (info.next().equalsIgnoreCase("Add_Family_Member")) {
                FamilyMemberCounter++;
            }
        } // end while 
        System.out.println("FamilyMemberCounter = " + FamilyMemberCounter);

        Scanner inputFamilyMember = new Scanner(inputFile);

        listFamilyMember = new FamilyMember[FamilyMemberCounter];

        for (int i = 0; i < FamilyMemberCounter; i++) {
            while (inputFamilyMember.hasNextLine()) {

                Scanner info = new Scanner(inputFamilyMember.nextLine());

                while (info.next().equalsIgnoreCase("Add_Family_Member")) {
                    FamilyMember f = getFamilyMember(info, i + 1);
                    member.add(f);

                    //Print value
                    System.out.println(member.get(i));
                    fWrite.println(member.get(i));

                    i++;
                    fWrite.println();
                    break;
                }// while GenerateInvoice

            }// end nasted while loop 

        }// end while loop

        inputFamilyMember_counter.close();
        inputFamilyMember.close();

        //----------------------------------------------------
        // Part 3: The number of classes
        Scanner inputClass_counter = new Scanner(inputFile);
        ClassCounter = 0;
        while (inputClass_counter.hasNextLine()) { // 16
            Scanner info = new Scanner(inputClass_counter.nextLine()); //read other lines in first file 
            if (info.next().equalsIgnoreCase("Add_Class")) {
                ClassCounter++;
            }
        } // end while 
        System.out.println("ClassCounter = " + ClassCounter);

        Scanner inputClass = new Scanner(inputFile);
        listClass = new Class[ClassCounter];

        for (int i = 0; i < ClassCounter; i++) {
            while (inputClass.hasNextLine()) {
                Scanner info = new Scanner(inputClass.nextLine());

                while (info.next().equalsIgnoreCase("Add_Class")) {

                    Class c = getClass(info, i + 1);
                    service.add(c);

                    //Print value
                    System.out.println(service.get(i));
                    fWrite.println(service.get(i));

                    i++;
                    fWrite.println();
                    break;
                }// while GenerateInvoice

            }// end nasted while loop 

        }// end while loop

        inputClass_counter.close();
        inputClass.close();
        //----------------------------------------------------
        // Part 4: The number of Amenities
        Scanner inputAmenity_counter = new Scanner(inputFile);
        AmenityCounter = 0;
        while (inputAmenity_counter.hasNextLine()) { // 13
            Scanner info = new Scanner(inputAmenity_counter.nextLine()); //read other lines in first file 
            if (info.next().equalsIgnoreCase("Add_Amenity")) {
                AmenityCounter++;
            }
        } // end while 
        System.out.println("AmenityCounter = " + AmenityCounter);

        Scanner inputAmenity = new Scanner(inputFile);

        listAmenity = new Amenity[AmenityCounter];

        for (int i = 0; i < AmenityCounter; i++) {
            while (inputAmenity.hasNextLine()) {
                Scanner info = new Scanner(inputAmenity.nextLine());

                while (info.next().equalsIgnoreCase("Add_Amenity")) {

                    Amenity a = getAmenityMember(info, i + 1);
                    service.add(a);

                    //Print value
                    System.out.println(service.get(i));
                    fWrite.println(service.get(i));

                    i++;
                    fWrite.println();
                    break;
                }// while GenerateInvoice

            }// end nasted while loop 

        }// end while loop
        inputAmenity_counter.close();
        inputAmenity.close();
    }

    private static SingleMember getSingleMember(Scanner input, int SingleMemberCounter) throws ParseException {

        SingleMember s = null;
        System.out.println("mm");
        while (input.hasNext()) {
            String MemberID = "100" + SingleMemberCounter;
            String Name = input.next();

            String Gender_S = input.next();
            char Gender = Gender_S.charAt(0);

            Date DateOfBirth = StringToDate(input.next());

            //ageOfSingleMembers[SingleMemberCounter - 1] = CalculateAge(DateOfBirth);
            //System.out.println("age = " + ageOfSingleMembers[SingleMemberCounter - 1]);

            Date DateOfRegestration = StringToDate(input.next());
            //NoOfRegistration[SingleMemberCounter - 1] = CalculateLoyality(DateOfRegestration);
            String Address = input.next();
            String Phone = input.next();
            String MembershipType = input.next();

            s = new SingleMember(MemberID, Name, Gender, DateOfBirth, DateOfRegestration, Address, Phone, MembershipType);
        }

        return s;

    } // end getSingleMember

    private static FamilyMember getFamilyMember(Scanner input, int FamilyMemberCounter) throws ParseException {

        // change from FamilyMember to Member class
        FamilyMember f = null;
        while (input.hasNext()) {

            String ID = "200" + FamilyMemberCounter;
            String Name = input.next();

            String Gender_S = input.next();
            char Gender = Gender_S.charAt(0);

            Date DateOfBirth = StringToDate(input.next());
            //ageOfFamilyMembers[FamilyMemberCounter - 1] = CalculateAge(DateOfBirth);
            //System.out.println("age = " + ageOfFamilyMembers[FamilyMemberCounter - 1]);

            Date DateOfRegestration = StringToDate(input.next());
            //NoOfRegistration[FamilyMemberCounter - 1] = CalculateLoyality(DateOfRegestration);

            String Address = input.next();
            String Phone = input.next();

            // Add Family member to ArrayList
            ArrayList<String> Family_members = new ArrayList<>();
            Family_members.add(input.next());

            f = new FamilyMember(ID, Name, Gender, DateOfBirth, DateOfRegestration, Address, Phone, Family_members);
        }
        return f;
    } // end getFamilyMember

    private static Class getClass(Scanner input, int ClassCounter) {

        Class c = null;
        while (input.hasNext()) {
            String ServiceID;
            ServiceID = (ClassCounter < 10) ? "500" + ClassCounter : "50" + ClassCounter;

            String ServiceName = input.next();
            String location = input.next();
            double Price = input.nextDouble();
            int Capacity = input.nextInt();
            String Instructor = input.next();
            c = new Class(ServiceID, ServiceName, location, Price, Capacity, Instructor);
        }
        return c;
    } // end getClass

    private static Amenity getAmenityMember(Scanner input, int AmenityCounter) {

        Amenity a = null;
        while (input.hasNext()) {

            String AmenityID;
            AmenityID = (AmenityCounter < 10) ? "600" + AmenityCounter : "60" + AmenityCounter;

            String AmenityName = input.next();
            String AmenityType = input.next();
            String location = input.next();
            String Restrication = input.next();
            double Price = input.nextDouble();
            a = new Amenity(AmenityID, AmenityName, location, Price, AmenityType, Restrication);
        }
        return a;
    } // end getAmenityMember

    public static Date StringToDate(String s) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy").parse(s);
    } // end StringToDate

    public static String DateToString(Date date) {
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    } // end DateToString

}
