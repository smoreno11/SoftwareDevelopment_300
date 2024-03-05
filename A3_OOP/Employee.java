public class Employee {

  private String name;
  private String title;
  private int id;
  private int age;
  private double salary;
  
  Employee()
  {

  }

  Employee(String name, String title, int id, int age, double salary)
  {
    setName(name);
    setTitle(title);
    setId(id);
    setAge(age);
    setSalary(salary);

  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public int getAge()
  {
    return age;
  }

  public void setAge(int age)
  {
    this.age = age;
  }

  public double getSalary()
  {
    return salary;
  }

  public void setSalary(double salary)
  {
    this.salary = salary;
  }

  public void changeSalary(double percent)
  {
    salary = salary * (1.0 + (percent / 100.0));
  }

  public String toString()
  {
    return "Employee: Name: " + name + ", ID: " + id + ", Age: " + age 
         + ", Salary: $" + salary + ", Title: " + title;
  } 

}
