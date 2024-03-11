/******************************************************************************
 * AUTHOR      : Saul Moreno
 * ASSIGNMENT# : 4
 * CLASS       : CSC 300
 * Due         : 3/3/24
 ******************************************************************************/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Supermarket {
    private String superName;
    private int bigCheckerOccupied = 0;
    private int fastCheckerOccupied = 0;
    private ArrayList<Shopper> currentShoppers = new ArrayList<>();
    private ArrayList<BigShopper> bigCheckOut = new ArrayList<>();
    private ArrayList<FastShopper> fastCheckOut = new ArrayList<>();
    private ArrayList<Shopper> doneShopping = new ArrayList<>();
    private Random randy;

    public Supermarket(String superName, int seed) {
        setSuperName(superName);
        randy = new Random(seed);

    }

    public void setSuperName(String superName)
	{
		this.superName = superName;
	}

    public void openSupermarket() 
    {
      for (int i = 0; i < 14; i++) 
      {
        if (i % 3 == 0) 
        {
          currentShoppers.add(new BigShopper(0));
        } 
        else 
        {
          currentShoppers.add(new FastShopper(0));
        }
      }
    }

    public void operateSupermarket(int minutes) 
    {
        int minCounter = 1;

        while (!currentShoppers.isEmpty() || !bigCheckOut.isEmpty() || !fastCheckOut.isEmpty())
        {
          if (minCounter <= minutes && minCounter % 5 == 0) 
          {
              for (int i = 0; i < 9; i++) 
              {
                if (i % 3 == 0) 
                {
                  currentShoppers.add(new BigShopper(minCounter));
                } 
                else 
                {
                  currentShoppers.add(new FastShopper(minCounter));
                }
              }
          }

            // Processing the shoppers
          for (int i = 0; i < currentShoppers.size(); i++) 
          {
            Shopper tempShopper = currentShoppers.get(i);
            tempShopper.setShoppingTimeRemaining(tempShopper.getShoppingTimeRemaining() - 1);

            if (tempShopper.getShoppingTimeRemaining() == 0) 
            {
              if (tempShopper instanceof BigShopper) 
              {
                BigShopper tempBig = (BigShopper) tempShopper;
                tempBig.setTimeIntoCheckoutLine(minCounter);
                bigCheckOut.add(tempBig);
              } 
              else 
              {
                FastShopper tempFast = (FastShopper) tempShopper;
                tempFast.setTimeIntoCheckoutLine(minCounter);
                fastCheckOut.add(tempFast);
              }
          
              currentShoppers.remove(tempShopper);
              i--; 
            }// end if (tempShopper.getShoppingTimeRemaining() == 0) 
          } //end for (int i = 0; i < currentShoppers.size(); i++) 

          // Processing the Big Checkout
          if (!bigCheckOut.isEmpty() && bigCheckerOccupied == 0) 
          {
            BigShopper tempBig = bigCheckOut.remove(0);
            tempBig.setTimeOutOfCheckoutLine(minCounter);
            doneShopping.add(tempBig);
            bigCheckerOccupied = BigShopper.TIMEWITHCHECKER;
          } 
          else if (bigCheckerOccupied != 0) 
          {
            bigCheckerOccupied--;
          }

          // Processing the Fast Checkout
          if(!fastCheckOut.isEmpty() && fastCheckerOccupied == 0) 
          {
                FastShopper tempFast = fastCheckOut.remove(0);
                tempFast.setTimeOutCheckoutLine(minCounter);
                doneShopping.add(tempFast);
                fastCheckerOccupied = FastShopper.TIMEWITHCHECKER;
          } 
          else if (fastCheckerOccupied != 0) 
          {
                fastCheckerOccupied--;
          }

          minCounter++;
        }// end while (!currentShoppers.isEmpty() || !bigCheckOut.isEmpty() || !fastCheckOut.isEmpty())
    }// end  public void operateSupermarket(int minutes) 

    public void generateSupermarketResults(String outputFileName) throws IOException
	{
		File outputFile= new File(outputFileName);
		PrintWriter outputWriter = new PrintWriter(outputFile);
		
		outputWriter.printf("Data For Supermarket %s\n", superName);
		outputWriter.printf("%13s %15s %10s %15s %15s %15s\n", "Shopper ID", "Start Time", "End Time",  "Time Shopping", "Checkout Time",  "Time In Store");
		
		int numOfBigShoppers = 0;
		int checkOutTime =0; 
		int numOfFastShoppers =0;
		int checkOutFastTime =0; 
		double averageBigQueueTime; 
    double averageFastQueueTime;
		Iterator <Shopper> shoppingIter = doneShopping.iterator();
		while(shoppingIter.hasNext())
		{
			Shopper tempShopper = shoppingIter.next();
			outputWriter.printf("%s", tempShopper);
			if(tempShopper instanceof BigShopper)
			{
				numOfBigShoppers++;
				checkOutTime = checkOutTime + tempShopper.getTotalTimeCheckingOut();
			}
			else
			{
				numOfFastShoppers++;
				checkOutFastTime = checkOutFastTime + tempShopper.getTotalTimeCheckingOut();
			}
     // outputWriter.print("\n");
		}
		averageBigQueueTime = (double)checkOutTime/numOfBigShoppers;
		averageFastQueueTime = (double)checkOutFastTime/numOfFastShoppers;
		outputWriter.printf("The average time checking out on the Big Queue for %d Shoppers is %4.2f minutes\n", BigShopper.bigShopperCounter, averageBigQueueTime);
		outputWriter.printf("The average time checking out on the Fast Queue for %d Shoppers is %4.2f minutes\n", FastShopper.fastShopperCounter, averageFastQueueTime);	
		outputWriter.close();
	}
}
