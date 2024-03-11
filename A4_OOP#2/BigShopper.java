/******************************************************************************
 * AUTHOR      : Saul Moreno
 * ASSIGNMENT# : 4
 * CLASS       : CSC 300
 * Due         : 3/3/24
 ******************************************************************************/
import java.util.Random;

public class BigShopper extends Shopper{
  public static int bigShopperCounter = 0;
  public static final int TIMEWITHCHECKER = 2;
  
  private String bigShopperID;
  private int startTime;
  private int timeShopping;
  private int shoppingTimeRemaining;
  private int timeIntoCheckoutLine;
  private int timeOutOfCheckoutLine;
  private int endTime;
  private int totalTimeCheckingOut;
  private int totalTimeInStore;
  private Random randy;

  public BigShopper(int startTime) 
  {
    super("BigShopper");
    randy = new Random(bigShopperCounter);
    setBigShopperID();
    setStartTime(startTime);
    setTimeShopping();
    setShoppingTimeRemaining(timeShopping);
  }

  private void setBigShopperID() 
  {
    bigShopperCounter++;
    bigShopperID = getShopperType() + bigShopperCounter;
  }

  private void setStartTime(int startTime) 
  {
    this.startTime = startTime;
  }

  private void setTimeShopping() 
  {
    timeShopping = randy.nextInt(11) + 5;
  }

  public void setTimeOutOfCheckoutLine(int time) 
  {
    timeOutOfCheckoutLine = time;
    calculateFinalDurations();
  }

  private void calculateFinalDurations() 
  {
    endTime = timeOutOfCheckoutLine + TIMEWITHCHECKER;
    totalTimeCheckingOut = endTime - timeIntoCheckoutLine;
    totalTimeInStore = endTime - startTime;
  }

  public int getTotalTimeCheckingOut() 
  {
    return totalTimeCheckingOut;
  }

  public int getShoppingTimeRemaining() 
  {
    return shoppingTimeRemaining;
  }

  public void setShoppingTimeRemaining(int timeRemaining) 
  {
    shoppingTimeRemaining = timeRemaining;
  }

  public void setTimeIntoCheckoutLine(int time) 
  {
    timeIntoCheckoutLine = time;
  }

  public String toString() 
  {
    return String.format("%14s %8d %10d %15d %15d %15d\n", 
    bigShopperID, startTime, endTime, timeShopping, totalTimeCheckingOut, totalTimeInStore);
  }

}
