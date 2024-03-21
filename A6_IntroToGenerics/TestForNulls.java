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
    Random randy = new Random(5);

    ArrayList<Integer> intArrayL = new ArrayList<>();
    for(int counter = 0; counter < 9 ; counter++)
    {
      intArrayL.add(randy.nextInt(11)+5);
    }
    System.out.println("It is " + hasNoNulls(intArrayL) + " that intArrayL has no null value");

    intArrayL.add(null);
    System.out.println("It is " + hasNoNulls(intArrayL) + " that intArrayL has no null value");

    System.out.println(intArrayL);

    ArrayList<String> stringArrayL = new ArrayList<>();
    for(int counter = 0; counter < 6; counter++ )
    {
      stringArrayL.add("wxy" + (randy.nextInt(19)+9));
    }
    System.out.println("It is " + hasNoNulls(stringArrayL) + " that stringArray had no null");

    stringArrayL.add(3, null);
    System.out.println("It is " + hasNoNulls(stringArrayL) + " that stringArray had no null");
    System.out.println(stringArrayL);


  }
}
