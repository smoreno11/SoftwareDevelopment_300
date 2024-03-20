import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class ReverseOrderIntegersWithArrayList{
  public static void main(String[] args){
    
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Please enter the file name containing a list of integers: ");
    String intFile = keyboard.nextLine();
    keyboard.close();

    File inputFile = new File(intFile);

    ArrayList<Integer> integerList = new ArrayList<>();

    if (!inputFile.exists())
    {
      System.out.println("File does not exitst");
    }
    else if (inputFile.length() == 0)
    {
      System.out.println("File is empty");
    }
    else
    {
      try {
        keyboard = new Scanner(new File(intFile));
        while(keyboard.hasNextInt())
        {
          int count = keyboard.nextInt();
          listSort(integerList, count);
          System.out.println(count);
        }
        keyboard.close();

        System.out.println("Output Using Enhanced For:");
        for(Integer go: integerList)
        {
          System.out.println(go);
        }

        System.out.println("Output Using The Iterator:");
        for(int i = 0; i < integerList.size(); i++)
        {
          System.out.println(integerList.get(i));
        }

      } 
      catch (FileNotFoundException bad)
      {
        System.out.println("ERROR! could not input ");
      }
    }

  }

  public static void listSort(ArrayList<Integer> list, int num)
  {
    if(list.isEmpty() || num >= list.get(0))
    {
      list.add(0,num);
    }
    else 
    {
      int i = 0;
      while(i< list.size() && num < list.get(i))
      {
        i++;
      }
      list.add(i,num);
    }
  }

}