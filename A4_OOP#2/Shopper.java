/******************************************************************************
 * AUTHOR      : Saul Moreno
 * ASSIGNMENT# : 4
 * CLASS       : CSC 300
 * Due         : 3/3/24
 ******************************************************************************/
abstract class Shopper implements ShoppingTimeRemaining{
  private String shopperType;

  public Shopper()
  {
    setShopperType("");
  }

  public Shopper(String shopperTye)
  {
    setShopperType(shopperTye);
  }

  public void setShopperType(String shopperType)
  {
    this.shopperType = shopperType;
  }

  public String getShopperType()
  {
    return shopperType;
  }

  public abstract void setTimeIntoCheckoutLine(int value);

  public abstract int getTotalTimeCheckingOut();

}
