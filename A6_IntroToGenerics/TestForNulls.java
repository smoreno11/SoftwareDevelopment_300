import java.util.ArrayList;
import java.util.Random;

public class TestForNulls {

  public static boolean hasNoNulls(ArrayList<?> list)
  {
    for(Object value : list)
    {
      if (value == null)
      {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args){

    long seed = 5;
    Random randy = new Random(seed);

    ArrayList<Integer> intArrayL = new ArrayList<>();
    for(int counter = 0; counter < 9 ; counter++)
    {
      intArrayL.add(randy.nextInt(5,16));
    }
    System.out.println("It is " + hasNoNulls(intArrayL) + " that intArrayL has no null value");

    intArrayL.add(null);
    System.out.println("It is " + hasNoNulls(intArrayL) + " that intArrayL has no null value");

    System.out.println(intArrayL);

    ArrayList<String> stringArrayL = new ArrayList<>();
    for(int counter = 0; counter < 6; counter++ )
    {
      stringArrayL.add("wxy" + (randy.nextInt(9,28)));
    }
    System.out.println("It is " + hasNoNulls(stringArrayL) + " that stringArray had no null");

    stringArrayL.add(3, null);
    System.out.println("It is " + hasNoNulls(stringArrayL) + " that stringArray had no null");
    System.out.println(stringArrayL);


  }
}
