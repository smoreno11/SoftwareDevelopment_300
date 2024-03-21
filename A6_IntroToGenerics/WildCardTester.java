import java.util.ArrayList;


public class WildCardTester {

  public static void addDog(ArrayList<? super BrownDog> list, String name)
  {
    list.add(new BrownDog(name));
    System.out.println("Doggie named " + name + " was added");
  }

  public static void deleteDog(ArrayList<? extends Dog> list, String name)
  {
    list.remove(name);
    System.out.println("Doggie names " + name + " was removed");

  }



  public static void main(String[] args){




  }
  
}
