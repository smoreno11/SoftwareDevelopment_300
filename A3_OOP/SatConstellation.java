import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class SatConstellation {

  private String satConstellationName;
  Country country;
  private ArrayList<Satellite> satelliteList = new ArrayList<>();

  SatConstellation(){
    this.satConstellationName = "unknown";
    this.country = new Country();
  }

  SatConstellation(String satConstellationName, String countryName){
    setConstellationName(satConstellationName);
    this.country = new Country(countryName);
    createSatellite();
  }

  public String getSatConstellationName(){
    return satConstellationName;
  }

  public void setConstellationName(String satConstellationName){
    this.satConstellationName = satConstellationName;
  }

  public String toString(){
    String output = "The name of " + country.getCountryName() + "'s satellite constellation is " + 
                    satConstellationName + "\n";
    for(Satellite satellite : satelliteList){
      output += "The satellite named " + satellite.getSatelliteName() +
                " has a maximum orbital height of " + satellite.getSatelliteOrbitHeight() +
                " miles\n";
    }
    return output;
  }

  public void createSatellite(){
    
    Scanner input = new Scanner(System.in);
    System.out.print("Please enter file to read in Satellite List from: ");
    String fileName = input.nextLine();
    
    try{
      File file = new File(fileName);
      Scanner fileScanner = new Scanner(file);
      
      while(fileScanner.hasNextLine()){
        String satelliteName = fileScanner.nextLine();
        Satellite satellite = new Satellite(satelliteName);
        satelliteList.add(satellite);
      }
      fileScanner.close();
    }
    catch(FileNotFoundException failed){
      System.out.println("File not found : " + fileName);
    }
  }

  public int getNumSatellites(){
    return satelliteList.size();
  }

  public Satellite getSatellite(int index){
    if(index < 0 || index >= satelliteList.size()){
      System.out.println("Satellite does not exist");
      return null;
    }
    return satelliteList.get(index);
  }

}
