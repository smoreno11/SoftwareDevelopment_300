import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner;

class CreditCardTransactions {
  public static void main(String[] args) throws FileNotFoundException{
    String purchase = "";
    String tempPurchase = "";
    String pricing = "";
    double price = 0.0;
    double tempPrice = 0.0;

      File file = new File("credit_transactions.txt");
      Scanner scan = new Scanner(file);

      while(scan.hasNext()){
        tempPurchase = scan.next();
        pricing = scan.next();
        tempPrice = Double.parseDouble(pricing);

        if(price < tempPrice)
        {
          purchase = tempPurchase;
          price = tempPrice;
        }

      }
      scan.close();
      System.out.println(purchase + " " + price);
    
  }
}