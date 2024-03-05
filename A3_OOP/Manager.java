import java.util.ArrayList;

public class Manager extends Employee{
  
  private ArrayList<Employee> managedEmployees;

  public Manager(String name, String title, int id, int age, double salary)
  {
    super(name, title, id, age, salary);
    managedEmployees = new ArrayList<>();

  }

  public void addManagedEmployee(Employee employee) 
  {
    managedEmployees.add(employee);
  }

  public int getManangedEmployeesListSize()
  {
    return managedEmployees.size();
  }

  public Employee getManagedEmployeeAtIndex(int index)
  {
    if (index >= 0 && index < managedEmployees.size())
    {
      return managedEmployees.get(index);
    }
    else
    {
      System.out.println("Nothing in the array");
      return null;
    }
  }

  public ArrayList<Employee> getManagedEmployees()
  {
    return managedEmployees;
  }

  public String toString()
  {
    return super.toString().replace("Employee", "Manager");
  }

}
