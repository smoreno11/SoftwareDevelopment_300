import java.util.Random;

class Satellite {
  
  private static Random randy = new Random(6);
  private String satelliteName;
  int satelliteOrbitHeight;

  Satellite(){
    this.satelliteName = "unkown";
  }

  Satellite(String satelliteName){
    setSatelliteName(satelliteName);
    setSatelliteOrbitHeight(generateRandomHeight());
  }

  public String getSatelliteName(){
    return satelliteName;
  }

  public void setSatelliteName(String satelliteName){
    this.satelliteName = satelliteName;
  }

  public int getSatelliteOrbitHeight(){
    return satelliteOrbitHeight;
  }

  public void setSatelliteOrbitHeight(int satelliteOrbitHeight){
    this.satelliteOrbitHeight = satelliteOrbitHeight;
  }

  public String toString(){
    return String.format("The satellilte named %s has a maximum orbital height of %d", satelliteName, satelliteOrbitHeight);
  }
   
  public int generateRandomHeight(){
    int height;
    height = randy.nextInt(111) + 150;
    return height;
  }

  public boolean equals(Object obj){
    
    Satellite compareSat = (Satellite) obj;  
    boolean compare;

      if(this.satelliteName.equals(compareSat.satelliteName) && 
         this.satelliteOrbitHeight == compareSat.satelliteOrbitHeight){
          return compare = true;
      }
      else
      {
        return compare = false;
      }
  }

}