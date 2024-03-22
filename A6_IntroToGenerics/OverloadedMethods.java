/******************************************************************************
 * AUTHOR      : Saul Moreno
 * ASSIGNMENT# : 6
 * CLASS       : CSC 300
 * Due         : 3/23/24
 ******************************************************************************/
// Printing array elements using overloaded methods.

public class OverloadedMethods 
{ 
	// method printArray to print Integer array 

	public static <T> void printArray(T[] inputArray) 
	{ 
		// display array elements 	
		for (T element : inputArray) 
		{ 
			System.out.printf("%s ", element); 	
		} 		
		System.out.printf("\n"); 	
	} 
	
	public static void main(String[] args) 
	{ 
		// create arrays of Integer, Double and Character 
		Integer[] integerArray =  {1, 2, 3, 4, 5, 6}; 
		Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7}; 
		Character[] characterArray = {'H', 'E', 'L', 'L', 'O'}; 
		System.out.printf("Array integerArray contains: "); 
		printArray(integerArray); //pass an Integer array 
		System.out.printf("Array doubleArray contains: "); 
		printArray(doubleArray); //pass a Double array 
		System.out.printf("Array characterArray contains: "); 
		printArray(characterArray); // pass a Character array 
	} 
}