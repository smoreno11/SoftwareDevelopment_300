import java.io.File; 
import java.io.FileWriter;  
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class URL {
  public static void main(String[] args) throws FileNotFoundException{
    
    String urlString = "";
    int index = 0;
    int firstPeriod = 0;
    int secondPeriod = 0;
    
    File file = new File("urlInput.txt");
    Scanner scan = new Scanner(file);

    try{
    FileWriter output = new FileWriter("urlOutput.txt");
    while(scan.hasNextLine()){
      urlString = scan.nextLine();
    while(urlString.charAt(index) != '.')
    {
      index++;
    }
    firstPeriod = index + 1;
    index = urlString.length() - 1;
    while(urlString.charAt(index) != '.')
    {
      index--;
    }
    secondPeriod = index;
     output.write( urlString + " " + urlString.substring(firstPeriod, secondPeriod) + "\n");
     index = 0;
    
  }
  output.close();
    scan.close();
    }
    catch(IOException fail)
    {
      System.out.println("THIS FAILED");
    }

    
  }
}
