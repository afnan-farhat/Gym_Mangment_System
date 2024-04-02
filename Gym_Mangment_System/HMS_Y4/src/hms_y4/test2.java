package hms_y4;

import assignment2.Class;
import assignment2.Service;
import static assignment2.HMS.PrintSortClass;
import java.io.*;
import java.util.*;

public class test2 {

    private static ArrayList<Service> service = new ArrayList<Service>();
    private static int ClassCounter;
    private static Class[] listClass;

    public static void sort1(int[] arrayName) {
        int temp;
        for (int i = 0; i < arrayName.length - 1; i++) {
            if (arrayName[i] > arrayName[i + 1]) {
                temp = arrayName[i];
                arrayName[i] = arrayName[i + 1];
                arrayName[i + 1] = temp;
                i = -1;
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        File inputFile = new File("input.txt");

        int[] arrayName = new int[10];
        for (int i = 0; i < arrayName.length; i++) {
            arrayName[i] = (int) (Math.random() * 100);
        }

        //____________________________
        // Part 3: The number of classes
//        Scanner inputClass_counter = new Scanner(inputFile);
//        int ClassCounter = 0;
//        while (inputClass_counter.hasNextLine()) { // 16
//            Scanner info = new Scanner(inputClass_counter.nextLine()); //read other lines in first file 
//            if (info.next().equalsIgnoreCase("Add_Class")) {
//                ClassCounter++;
//            }
//        } // end while 
//
//        Scanner inputClass = new Scanner(inputFile);
//        Class[] listClass = new Class[ClassCounter];
//        ArrayList<Class> arrayListClass = new ArrayList<>(Arrays.asList(listClass));
//
//        for (int i = 0; i < ClassCounter; i++) {
//            while (inputClass.hasNextLine()) {
//                Scanner info = new Scanner(inputClass.nextLine());
//
//                while (info.next().equalsIgnoreCase("Add_Class")) {
//
//                    Class c = getClass(info, i + 1);
//                    listClass[i] = c;
//                    System.out.println(listClass[i]);
//
//                    //Print value
//                    System.out.println(listClass[i]);
//
//                    i++;
//                    break;
//                }// while GenerateInvoice
//
//            }// end nasted while loop 
//
//        }// end while loop
// Part 3: The number of classes
        Scanner inputClass_counter = new Scanner(inputFile);
        ClassCounter = 0;
        while (inputClass_counter.hasNextLine()) { // 16
            Scanner info = new Scanner(inputClass_counter.nextLine()); //read other lines in first file 
            if (info.next().equalsIgnoreCase("Add_Class")) {
                ClassCounter++;
            }
        } // end while 

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

                    i++;
                    break;
                }// while GenerateInvoice

            }// end nasted while loop 

        }// end while loop

        inputClass_counter.close();
        inputClass.close();

        System.out.println("part 2\n\n " );

        Scanner inputSortClass = new Scanner(inputFile);

        //Delet arrayListClass
        ArrayList<Class> arrayListClass = new ArrayList<>(Arrays.asList(listClass));

        while (inputSortClass.hasNextLine()) {
            Scanner info = new Scanner(inputSortClass.nextLine());
            //while (!info.next().equalsIgnoreCase("Quit")) {

            //for (int i = 0; i < ClassCounter + AmenityCounter; i++) {
            if (info.next().equalsIgnoreCase("Print_Sort_Classes")) {
                System.out.println("----------------------------------------- Classes Sorted By Price ------------------------------------------");
                System.out.printf("%-27s%-26s%-26s%-26s%n", "Class name", "Location", "Instructor", "Price");
                System.out.println("----------------------------------------------------------------------------------------------------------------");

                for (int i = 0; i < service.size(); i++) {
                    PrintSortClass(arrayListClass, i);
                }
            }
        }

        inputSortClass.close();
    }

    // ---------------------------------------------------------------------------
    public static void PrintSortClass(ArrayList  arrayListClass, int ClassCounter) {
        Collections.sort(arrayListClass);
        for (int i = 0; i < arrayListClass.size(); i++) {
            if (arrayListClass.get(i) instanceof Class) {
                Class tempClass = (Class) arrayListClass.get(i);

                System.out.printf("%-27s%-26s%-26s%-26s%n", tempClass.getServiceName(), tempClass.getLocation(),
                        tempClass.getInstructor(), tempClass.getPrice());
            }

        }
    }

    private static Class getClass(Scanner input, int ClassCounter) {

        Class c = null;
        while (input.hasNext()) {
            String ServiceID;
            ServiceID = (ClassCounter < 10) ? "500" + ClassCounter : "50" + ClassCounter;

            String ServiceName = input.next();
            String Location = input.next();
            double Price = input.nextDouble();
            int Capacity = input.nextInt();
            String Instructor = input.next();
            c = new Class(ServiceID, ServiceName, Location, Price, Capacity, Instructor);
        }
        return c;
    } // end getClass

}
