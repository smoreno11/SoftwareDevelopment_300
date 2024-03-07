import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NameSearch {
  public static void main(String[] args) throws FileNotFoundException{
    // int boyNameCount;

    // File file = new File("boynames.txt");

    // boyNameCount = getNumNames(file);

    // System.out.println(boyNameCount);
    Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the name of the boy's file: ");
        String boysFileName = scanner.nextLine();

        System.out.print("Please enter the name of the girl's file: ");
        String girlsFileName = scanner.nextLine();

        String[] boyNames = getArray(boysFileName);
        String[] girlNames = getArray(girlsFileName);

        while (true) {
            System.out.print("Do you want to search for names? Enter Y or N: ");
            String userInput = scanner.nextLine().toUpperCase();

            if (userInput.equals("N")) {
                break;
            } else if (userInput.equals("Y")) {
                System.out.print("Enter a boy's name, or N if you do not wish to enter a boy's name: ");
                String boyNameInput = scanner.nextLine().toLowerCase();

                System.out.print("Enter a girl's name, or N if you do not wish to enter a girl's name: ");
                String girlNameInput = scanner.nextLine().toLowerCase();

                if (!boyNameInput.equals("n")) {
                    if (isFound(boyNameInput, boyNames)) {
                        System.out.println(boyNameInput + " is one of the most popular boy's names.");
                    } else {
                        System.out.println(boyNameInput + " is not one of the most popular boy's names.");
                    }
                }

                if (!girlNameInput.equals("n")) {
                    if (isFound(girlNameInput, girlNames)) {
                        System.out.println(girlNameInput + " is one of the most popular girl's names.");
                    } else {
                        System.out.println(girlNameInput + " is not one of the most popular girl's names.");
                    }
                }
            }
        }

        scanner.close();
    

    
    
}
  
public static String[] getArray(String fileName) {
  File file = new File(fileName);
  int numNames = getNumNames(file);

  String[] namesArray = new String[numNames];

  try (Scanner fileScanner = new Scanner(file)) {
      for (int i = 0; i < numNames; i++) {
          namesArray[i] = fileScanner.nextLine().toLowerCase();
      }
  } catch (FileNotFoundException error) {
      error.printStackTrace();
  }

  return namesArray;
}


// public static int getNumNames(File file) {
//         int count = 0;

//         try (Scanner fileScanner = new Scanner(file)) {
//             while (fileScanner.hasNextLine()) {
//                 fileScanner.nextLine();
//                 count++;
//             }
//         } catch (Exception e) {
//             e.printStackTrace();
//         }

//         return count;
//     }
public static int getNumNames(File file) {
  int count = 0;

  try (Scanner fileScanner = new Scanner(file)) {
      while (fileScanner.hasNextLine()) {
          fileScanner.nextLine();
          count++;
      }
  } catch (FileNotFoundException fail) {
      fail.printStackTrace();
  }

  return count;
}
    public static boolean isFound(String searchName, String[] namesArray) {
      for (String name : namesArray) {
          if (name.equalsIgnoreCase(searchName)) {
              return true;
          }
      }
      return false;
  }

}
