/******************************************************************************
 * AUTHOR      : Saul Moreno
 * ASSIGNMENT# : 6
 * CLASS       : CSC 300
 * Due         : 3/23/24
 ******************************************************************************/
import java.util.ArrayList;

public class WildCardTester {

  public static void addDog(ArrayList<? super BrownDog> list, String name)
  {
    list.add(new BrownDog(name));
    System.out.println("Doggie named " + name + " was added");
  }

  public static void deleteDog(ArrayList<? extends Dog> list, String name)
  {
    int next = 0;
    while(next < list.size())
    {
      Dog dogName = list.get(next);
      if(dogName.toString().equals(name))
      {
        list.remove(next);
        System.out.println("Doggie names " + name + " was removed");
      }
      else
      {
        next++;
      }

    }
    
  }

  public static void printAll(ArrayList<?> list)
  {
    for(Object obj : list)
    {
      System.out.print(obj + " ");
    }
    System.out.print("\n");    
  }

  public static void main(String[] args){

    ArrayList<Animal> animalList = new ArrayList<>();
    ArrayList<BrownDog> brownDogList = new ArrayList<>();

    addDog(animalList, "GreyHound");
    addDog(brownDogList, "Boxer");
    addDog(brownDogList, "Spaniel");
    addDog(brownDogList, "Dachsund");
    System.out.println("The list of animals:");
    printAll(animalList);
    System.out.println("The list of Brown Dogs:");
    printAll(brownDogList);

    deleteDog(brownDogList, "Boxer");

    System.out.println("The list of Brown Dogs after a deletion of the first Dog in the list:");
    printAll(brownDogList);


  }
  
}
