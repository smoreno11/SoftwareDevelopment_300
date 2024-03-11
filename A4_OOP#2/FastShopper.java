/******************************************************************************
 * AUTHOR      : Saul Moreno
 * ASSIGNMENT# : 4
 * CLASS       : CSC 300
 * Due         : 3/3/24
 ******************************************************************************/
import java.util.Random;

public class FastShopper extends Shopper{
  public static int fastShopperCounter = 0;
  public static final int TIMEWITHCHECKER = 1;

  private String fastShopperID;
  private int startTime;
  private int timeShopping;
  private int shoppingTimeRemaining;
  private int timeIntoCheckoutLine;
  private int timeOutOfCheckoutLine;
  private int endTime;
  private int totalTimeCheckingOut;
  private int totalTimeInStore;
  private Random randy;

  public FastShopper(int startTime)
  {
    super("FastShopper");
    randy = new Random(fastShopperCounter);

    setFastShopperID();
    setStartTime(startTime);
    setTimeShopping();
    setShoppingTimeRemaining(timeShopping);
  }

  //
  public int getTotalTimeCheckingOut()
  {
    return totalTimeCheckingOut;
  }
//
  public int getShoppingTimeRemaining()
  {
    return shoppingTimeRemaining;
  }
//
  public void setStartTime(int startTime)
  {
    this.startTime = startTime;
  }
//
  public void setShoppingTimeRemaining(int shoppingTimeRemaining)
  {
    this.shoppingTimeRemaining = shoppingTimeRemaining;
  }
//
  public void setTimeIntoCheckoutLine(int timeIntoCheckoutLine)
  {
    this.timeIntoCheckoutLine = timeIntoCheckoutLine;
  }
//
  private void setFastShopperID()
  {
    fastShopperCounter++;
    fastShopperID = getShopperType() + fastShopperCounter;
  }
//
  private void setTimeShopping()
  {
    timeShopping = randy.nextInt(6) + 1;
  }
//
  public void setTimeOutCheckoutLine(int value)
  {
    this.timeIntoCheckoutLine = value;
    calculateFinalDurations();
  }
//
  private void calculateFinalDurations()
  {
    endTime = timeIntoCheckoutLine + TIMEWITHCHECKER;
    totalTimeCheckingOut = Math.max(0, endTime - timeIntoCheckoutLine);
    totalTimeInStore = Math.max(0, endTime - startTime);
  }
 //
  public String toString()
  {
    return String.format("%14s %8d %10d %15d %15d %15d\n", 
    fastShopperID, startTime, endTime, timeShopping, totalTimeCheckingOut, totalTimeInStore);
  }

}