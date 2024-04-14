/******************************************************************************
 * AUTHOR      : Saul Moreno
 * ASSIGNMENT# : 7
 * CLASS       : CSC 300
 * Due         : 4/13/24
 ******************************************************************************/
import java.util.ArrayList;
import java.util.Collections;

public class WorkerMaxSalaryTest {
  public static void main(String[] args) {
      ArrayList<Worker> workers = new ArrayList<>();
      workers.add(new Worker(10, "Maya", 25000, "Engineer"));
      workers.add(new Worker(120, "Jose", 45000, "Programmer"));
      workers.add(new Worker(210, "Abdul", 14000, "Analyst"));
      workers.add(new Worker(150, "Elissa", 24000, "Manager"));

      Collections.sort(workers);

      Worker maxSalaryWorker = workers.get(0);
      System.out.printf("Worker with max salary: %s%n", maxSalaryWorker);
  }
}