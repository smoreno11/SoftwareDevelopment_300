public class Country {
  
  private String countryName;
  
  Country(){
    this.countryName = "unkown";
  }

  Country(String countryName){
    setCountryName(countryName);;
  }

  public String getCountryName(){
    return countryName;
  }

  public void setCountryName(String countryName){
    this.countryName = countryName;
  }

  public String toString(){
    return String.format("The country for the Constellation is %s", countryName);
  }

}
