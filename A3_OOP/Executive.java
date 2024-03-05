import java.util.ArrayList;

public class Executive extends Manager {
  
  private double totalComp;

  public Executive(String name, String title, int id, int age, double salary)
  {
    super(name, title, id, age, salary);
    totalComp = 0.0;
  }

  public void setTotalComp(double companyProfits, double bonusPercentage)
  {
    double bonus = companyProfits * (bonusPercentage / 100.0);
    totalComp = getSalary() + bonus;
  }

  public double getTotalComp()
  {
    return totalComp;
  }

  public ArrayList<Employee> getManagedEmployees() 
  {
        return super.getManagedEmployees();
  }

  public String toString()
  {
    return super.toString().replace("Manager", "Executive");
  }

}
