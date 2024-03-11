/******************************************************************************
 * AUTHOR      : Saul Moreno
 * ASSIGNMENT# : 4
 * CLASS       : CSC 300
 * Due         : 3/3/24
 ******************************************************************************/

import java.io.IOException;
import java.util.Scanner;

public class ModelSupermarket {
  public static void main(String [] args) throws IOException
	{
		Scanner keyboard = new Scanner(System.in);

		System.out.printf("Please enter the name of the Supermarket: \n");
		String superName = keyboard.nextLine();

		System.out.printf("Please enter an int for the seed: ");
		int seed = keyboard.nextInt();
		
    Supermarket superM = new Supermarket(superName, seed);
		
    System.out.printf("Please enter the name of the output file for Supermarket results: ");
		String outputFile = keyboard.next();
		
    System.out.printf("Please enter the number of minutes to operate the Supermarket: ");
		int minutes = keyboard.nextInt();
		
    superM.openSupermarket();
		superM.operateSupermarket(minutes);		
		superM.generateSupermarketResults(outputFile);
	}
}
