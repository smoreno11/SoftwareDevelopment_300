/******************************************************************************
 * AUTHOR      : Saul Moreno
 * ASSIGNMENT# : Midterm 2
 * CLASS       : CSC 300
 * Due         : 5/5/24
 ******************************************************************************/

import java.util.Scanner;
import java.io.IOException;
public class ModelEmergencyFacility {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the Emergency Facility:");
        String name = scanner.nextLine();
        System.out.println("Please enter a seed value as an int:");
        int seed = scanner.nextInt();
        System.out.println("Please enter the number of doctors as an int:");
        int numDoctors = scanner.nextInt();
        System.out.println("Please enter the number of minutes to keep the Emergency Facility open:");
        int durationForArriving = scanner.nextInt();
        System.out.println("Please enter the name of the output file:");
        String outputFile = scanner.next();

        EmergencyFacility emergencyFacility = new EmergencyFacility(name, seed, numDoctors);
        emergencyFacility.openEmergencyFacility();
        emergencyFacility.operateEmergencyFacility(durationForArriving);
        emergencyFacility.generateEmergencyFacilityResults(outputFile);
    }
}