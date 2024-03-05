public abstract class Vacation{
  private String destination;
  private double budget;

  //Default Constructor
  //More comments
  Vacation()
  {

  }

  Vacation(String destination, double budget)
  {
    setDestination(destination);
    setBudget(budget);
  }

  public void setDestination(String destination)
  {
    this.destination = destination;
  }

  public String getDestination(String destination)
  {
    return destination;
  }

  public void setBudget(double budget)
  {
    if(budget >= 0)
    {
      this.budget = budget;
    }
    else
    {
      throw new IllegalArgumentException( "Budget must be >= 0.0");
    }
  }

  public double getBudger()
  {
    return budget;
  }

  public String toString()
  {
    return "Destination: " + destination 
         + "; Budget: $" + String.format("%.2f",budget) + "\n";
  }

  public boolean equals(Object obj)
  {
    if(this == obj)
    {
      return true;
    }

    if (obj == null || getClass() != obj.getClass())
    {
      return false;
    }

    Vacation tempObject = (Vacation) obj;

    if(destination != null)
    {
      if(!destination.equalsIgnoreCase(tempObject.destination))
      {
        return false;
      }
    }
    else
    {
      if(tempObject.destination != null)
      {
        return false;
      }
    }

    return Math.abs(budget - tempObject.budget) < 0.0001;
  }

}