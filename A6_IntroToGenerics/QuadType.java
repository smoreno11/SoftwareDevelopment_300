/******************************************************************************
 * AUTHOR      : Saul Moreno
 * ASSIGNMENT# : 6
 * CLASS       : CSC 300
 * Due         : 3/23/24
 ******************************************************************************/
class QuadType<F,S,T,U> {

  private F sideOne;
  private S sideTwo;
  private T sideThree;
  private U sideFour;

  QuadType(F sideOne, S sideTwo, T sideThree, U sideFour)
  {
    this.sideOne = sideOne;
    this.sideTwo = sideTwo;
    this.sideThree = sideThree;
    this.sideFour = sideFour;
  }

  public F getSideOne()
  {
    return sideOne;
  }

  public void setSideOne(F sideOne)
  {
    this.sideOne = sideOne;
  }

  public S getSideTwo()
  {
    return sideTwo;
  }

  public void setSideTwo(S sideTwo)
  {
    this.sideTwo = sideTwo;
  }

  public T getSideThree()
  {
    return sideThree;
  }

  public void setSideThree(T sideThree)
  {
    this.sideThree = sideThree;
  }

  public U getSideFour()
  {
    return sideFour;
  }

  public void setSideFour(U sideFour)
  {
    this.sideFour = sideFour;
  }
  
  public String toString()
  {
    return "<" + sideOne + ", " + sideTwo + ", " + sideThree + ", " + sideFour + ">";
  }

}
