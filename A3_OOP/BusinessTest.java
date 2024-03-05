import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class BusinessTest {
  public static void main(String[] args){
    ArrayList<Employee> employeeAL = new ArrayList<>();
    ArrayList<Manager> managerAL = new ArrayList<>();
    ArrayList<Executive> executiveAL = new ArrayList<>();

    Scanner input = new Scanner(System.in);
    System.out.print("Please enter the name of the input file with employee name and data: ");
    String inputFileName = input.nextLine();

    try {
      Scanner fileScanner = new Scanner(new File(inputFileName));

      while(fileScanner.hasNext())
      {
        String name = fileScanner.next();
        String title = fileScanner.next();
        int id = fileScanner.nextInt();
        int age = fileScanner.nextInt();
        double salary = fileScanner.nextDouble();

        if (id >= 1 && id <= 2000) 
        {
          employeeAL.add(new Employee(name, title, id, age, salary));
        } 
        else if (id >= 2001 && id <= 3000) 
        {
          managerAL.add(new Manager(name, title, id, age, salary));
        } 
        else if (id >= 3001 && id <= 3500) 
        {
          executiveAL.add(new Executive(name, title, id, age, salary));
        }
        
      }

    }
    catch(FileNotFoundException leaves){
      System.out.println("File not found");
    }

    for (int i = 0; i < employeeAL.size(); i++) {
      Manager manager = managerAL.get(i % managerAL.size());
      manager.addManagedEmployee(employeeAL.get(i));
  }

  // Assign each Manager to an Executive in a round-robin fashion
  for (int i = 0; i < managerAL.size(); i++) {
      Executive executive = executiveAL.get(i % executiveAL.size());
      executive.addManagedEmployee(managerAL.get(i));
  }

  // Prompt user for company's profits and bonus percentage for Executives
  System.out.print("Please enter the total company profit for the year: $");
  double companyProfits = input.nextDouble();

  System.out.print("Please enter the executive bonus percentage for the year correct to 1 decimal place: ");
  double bonusPercentage = input.nextDouble();

  // Set total compensation for each Executive
  for (Executive executive : executiveAL) {
      executive.setTotalComp(companyProfits, bonusPercentage);
  }

  // Create output file and print results
  System.out.print("Please enter the name of the output file: ");
  String outputFileName = input.next();

  try {
      PrintWriter outputFile = new PrintWriter(new File(outputFileName));

      // Print total payroll for the business including bonuses
      double totalPayroll = 0.0;

      for (Employee employee : employeeAL) {
          totalPayroll += employee.getSalary();
      }

      for (Manager manager : managerAL) {
          totalPayroll += manager.getSalary();
      }

      for (Executive executive : executiveAL) {
          totalPayroll += executive.getTotalComp();
      }

      outputFile.println("Total Payroll (including bonuses): $" + totalPayroll + "\n");

      // Print attributes for each Executive, Manager, and Employee
      for (Employee employee : employeeAL) {
          outputFile.println(employee);
      }
      outputFile.println();

      for (Manager manager : managerAL) {
          outputFile.println(manager);
      }
      outputFile.println();

      for (Executive executive : executiveAL) {
          outputFile.println(executive);
      }
      outputFile.println();

      // Print direct report Managers for each Executive
      for (Executive executive : executiveAL) {
          outputFile.println("Direct Report Managers for Executive " + executive.getName() + ":");
          for (Manager manager : executive.getManagedEmployees()) {
              outputFile.println(manager);
          }
          outputFile.println();
      }

      // Print direct report Employees for each Manager
      for (Manager manager : managerAL) {
          outputFile.println("Direct Report Employees for Manager " + manager.getName() + ":");
          for (Employee employee : manager.getManagedEmployees()) {
              outputFile.println(employee);
          }
          outputFile.println();
      }

      outputFile.close();
  } catch (FileNotFoundException e) {
      System.out.println("Error creating output file.");
  }

  // Read in the percent raise for the managers
  System.out.print("Please enter the salary change for a Manager as a percentage: ");
  double percentRaise = input.nextDouble();

  // For each manager, raise the salary and print new attributes
  for (Manager manager : managerAL) {
      double originalSalary = manager.getSalary();
      manager.changeSalary(percentRaise);
      System.out.println("New attributes for Manager " + manager.getName() + " after " +
              percentRaise + "% raise:\n" + manager);
      System.out.println("Original Salary: $" + originalSalary + ", New Salary: $" + manager.getSalary() + "\n");
  }

  input.close();
}

}
