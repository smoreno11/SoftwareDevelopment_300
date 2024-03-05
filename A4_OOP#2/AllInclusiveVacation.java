public class AllInclusiveVacation extends Vacation {
  
  private String brand;
  private int rating; //from 1 to 5
  private double price;

  AllInclusiveVacation()
  {

  }

  AllInclusiveVacation(String destination, double budget, String brand, int rating, double pride)
  {
    super(destination, budget);
    setBrand(brand);
    setRating(rating);
    setPrice(pride);
  }
  
  public void setBrand(String brand)
  {
    this.brand = brand;
  }

  public String getBrand()
  {
    return brand;
  }

  public void setRating(int rating)
  {
    if(rating >= 1 && rating <= 5)
    {
      this.rating = rating;
    }
    else
    {
      throw new IllegalArgumentException( "Rating must be > 0 and <= 5");
    }
  }

  public int getRating()
  {
    return rating;
  }

  public void setPrice(double price)
  {
    if(price >= 0.0)
    {
      this.price = price;
    }
    else
    {
      throw new IllegalArgumentException( "Price must be >= 0.0");
    }
  }

  public String toString()
  {
    return super.toString() + "Brand: " + brand + "; Rating: " 
                            + rating + ": $" + String.format("%.2f",price) + "\n";
  }

  public double overBudget(){
    return getBudget() - price;
  }
}
