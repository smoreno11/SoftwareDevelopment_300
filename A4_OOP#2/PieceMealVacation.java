/******************************************************************************
 * AUTHOR      : Saul Moreno
 * ASSIGNMENT# : 4
 * CLASS       : CSC 300
 * Due         : 3/3/24
 ******************************************************************************/
import java.util.Arrays;

public class PieceMealVacation extends Vacation{
  private String[] items;
  private double[] costs;

  PieceMealVacation(String destination, double budget, String[] items, double[] costs)
  {
    super(destination, budget);
    setItems(items);
    setCosts(costs);
  }

  public void setItems(String[] items)
  {
    this.items = Arrays.copyOf(items, items.length);
  }

  public String[] getItems()
  {
    return items.clone();
  }

  public void setCosts(double[] newCosts)
  {
    costs = new double[items.length];

    for(int i = 0; i < items.length; i++)
    {
      if(i < newCosts.length)
      {
        costs[i] = newCosts[i];
      }
      else
      {
        costs[i] = 0.0;
      }
    }
  }

  public double[] getCosts()
  {
    return Arrays.copyOf(costs, costs.length);
  }

  public String toString()
  {
    StringBuilder itemization = new StringBuilder(super.toString());

    for(int i = 0; i < items.length; i++)
    {
      itemization.append(String.format("%s:$%.2f\n",items[i],costs[i]));
    }

    return itemization.toString();
  }

  public boolean equals(Object obj)
  {
    if(!super.equals(obj))
    {
      return false;
    }

    PieceMealVacation compMeal = (PieceMealVacation) obj;

    return Arrays.equals(items, compMeal.items) && 
           Arrays.equals(costs, compMeal.costs);
  }

  public double overBudget()
  {
    double sum = 0.0;

    for(double cost: costs)
    {
      sum += cost;
    }
    return sum - getBudget();
  }

}
