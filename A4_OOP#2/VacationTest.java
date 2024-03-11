/******************************************************************************
 * AUTHOR      : Saul Moreno
 * ASSIGNMENT# : 4
 * CLASS       : CSC 300
 * Due         : 3/3/24
 ******************************************************************************/
public class VacationTest {
  public static void main(String[] args){
    AllInclusiveVacation aiv1 = new AllInclusiveVacation("Orland", 1000.00, "Disney", 4, 989.49);
    System.out.println("The first all-inclusive vacation is:");
    System.out.print(aiv1);

    double overBudget = aiv1.overBudget();
    if(Math.abs(overBudget) < 0.0001)
    {
      System.out.println("It is on budget");
    }
    else if(overBudget > 0)
    { 
      System.out.printf("It is under budget by $%.2f%n", Math.abs(overBudget));
    }
    else
    {
      System.out.printf("It is over budget by $%.2f%n", Math.abs(overBudget));
    }

    AllInclusiveVacation aiv2 = new AllInclusiveVacation("Bahamas", 2000.00, "ClubMed", 4, 2049.99);
    System.out.println("\nThe second all-inclusive vacation is:");
    System.out.print(aiv2);

    double otherOverBudget = aiv2.overBudget();
    if(Math.abs(otherOverBudget) < 0.0001)
    {
      System.out.println("It is on budget");
    }
    else if(otherOverBudget > 0)
    { 
      System.out.printf("It is under budget by $%.2f%n", Math.abs(otherOverBudget));
    }
    else
    {
      System.out.printf("It is over budget by $%.2f%n", Math.abs(otherOverBudget));
    }

    System.out.print("\n");
    aiv2.setBrand(aiv1.getBrand());
    aiv2.setPrice(aiv1.getPrice());

    if(aiv1.equals(aiv2))
    {
      System.out.println("aiv1 and aiv2 are now equal");
    }
    else
    {
      System.out.println("aiv1 and aiv2 are not equal");
    }

    aiv2.setDestination(aiv1.getDestination());
    aiv2.setBudget(aiv1.getBudget());

    if(aiv1.equals(aiv2))
    {
      System.out.println("aiv1 and aiv2 are now equal");
    }
    else
    {
      System.out.println("aiv1 and aiv2 are not equal");
    }

    System.out.print("\n");

    String[] itemsList1 = {"hotel", "meals", "airfare", "windsurfing"};
    double[] costsList1 = {750.00, 250.00, 400.00};
    PieceMealVacation pmv1 = new PieceMealVacation("Miami", 1500.00, itemsList1, costsList1);
    System.out.println("The first piecemeal vacation is:");
    System.out.print(pmv1);

    double overBudgetPmv1 = pmv1.overBudget();
    if(Math.abs(overBudgetPmv1) < 0.0001)
    {
      System.out.println("It is on budget");
    }
    else if(overBudgetPmv1 < 0)
    { 
      System.out.printf("It is under budget by $%.2f%n", Math.abs(overBudgetPmv1));
    }
    else
    {
      System.out.printf("It is over budget by $%.2f%n", Math.abs(overBudgetPmv1));
    }

    System.out.print("\n");
    String[] itemsList2 = {"hotel", "meals", "airfare", "windsurfing"};
    double[] costsList2 = {750.00, 250.00, 400.00, 120.00, 200.00};
    PieceMealVacation pmv2 = new PieceMealVacation("Miami", 1500.00, itemsList2, costsList2);
    System.out.println("The second piecemeal vacation is:");
    System.out.print(pmv2);

    double overBudgetPmv2 = pmv2.overBudget();
    if(Math.abs(overBudgetPmv2) < 0.0001)
    {
      System.out.println("It is on budget");
    }
    else if(overBudgetPmv2 < 0)
    { 
      System.out.printf("It is under budget by $%.2f%n", Math.abs(overBudgetPmv2));
    }
    else
    {
      System.out.printf("It is over budget by $%.2f%n", Math.abs(overBudgetPmv2));
    }

    System.out.print("\n");
    if(pmv1.equals(pmv2))
    {
      System.out.println("aiv1 and aiv2 are now equal");
    }
    else
    {
      System.out.println("aiv1 and aiv2 are not equal");
    }

    pmv2.setItems(itemsList1);
    pmv2.setCosts(costsList1);
    if(pmv1.equals(pmv2))
    {
      System.out.println("aiv1 and aiv2 are now equal");
    }
    else
    {
      System.out.println("aiv1 and aiv2 are not equal");
    }


  }
}
