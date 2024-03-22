/******************************************************************************
 * AUTHOR      : Saul Moreno
 * ASSIGNMENT# : 6
 * CLASS       : CSC 300
 * Due         : 3/23/24
 ******************************************************************************/
public class QuadTypeTest {
  public static void main(String[] args)
  {

    QuadType<Integer, String, Boolean, Double> quad = new QuadType<>(1,"one",true,1.40);
    System.out.println("Original QuadType: " + quad);

    quad.setSideOne(2);
    quad.setSideTwo("second");
    quad.setSideThree(false);
    quad.setSideFour(9.97);

    System.out.println("Modified QuadType: " + quad);

  }
}
