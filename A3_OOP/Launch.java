import java.util.Scanner;

public class Launch {
  public static void main(String[] args) {

      String countryName;
      String satelliteConstellation;

      Scanner userInput = new Scanner(System.in);
      System.out.print("Please enter the name of the Country: ");
      countryName = userInput.nextLine();
      System.out.print("Please enter the name of the Satellite Constellation ");
      satelliteConstellation = userInput.nextLine();

      SatConstellation constellationExample = new SatConstellation(satelliteConstellation, countryName);
      System.out.println(constellationExample);

      if (constellationExample.getNumSatellites() > 1) 
      {
        
        Satellite firstSatellite = constellationExample.getSatellite(0);
      
        if (constellationExample.equals(firstSatellite)) 
        {
          System.out.println("Satellite that matches the first satellite:\n" + constellationExample);
        } 
        else 
        {
          System.out.println("There is no satellite that matches the first satellite.");
        }

        for (int arrayCounter = 1; arrayCounter < constellationExample.getNumSatellites(); arrayCounter++) 
        {
          Satellite currentSatellite = constellationExample.getSatellite(arrayCounter);

          if (arrayCounter == constellationExample.getNumSatellites() - 1) 
          {
            currentSatellite.setSatelliteName(firstSatellite.getSatelliteName());
            currentSatellite.setSatelliteOrbitHeight(firstSatellite.getSatelliteOrbitHeight());
              
            if (currentSatellite.equals(firstSatellite)) 
            {
              System.out.println("The satellite named " + currentSatellite.getSatelliteName() +
              " has a maximum orbital height of " + currentSatellite.getSatelliteOrbitHeight() +
              " miles and equals the first satellite in the ArrayList.");
            } 
            else 
            {
              System.out.println("There are no satellites to compare.");
            }
          }
        }
    }
  }
}
