import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class WorkerMultiSortTest {
  public static void main(String[] args) {
      ArrayList<Worker> workers = new ArrayList<>();
      workers.add(new Worker(10, "Javier", 25000, "Programmer"));
      workers.add(new Worker(120, "Kwame", 45000, "Analyst"));
      workers.add(new Worker(210, "Teressa", 14000, "Programmer"));
      workers.add(new Worker(150, "Richard", 24000, "Engineer"));
      workers.add(new Worker(10, "Luis", 29000, "Programmer"));
      workers.add(new Worker(120, "Ali", 46000, "Analyst"));
      workers.add(new Worker(210, "Brenda", 9000, "Programmer"));
      workers.add(new Worker(150, "Patel", 22000, "Engineer"));

      Collections.sort(workers, new WorkerMultiSortComparator());

      Iterator<Worker> iterator = workers.iterator();
      while (iterator.hasNext()) {
          System.out.println(iterator.next());
      }
  }
}