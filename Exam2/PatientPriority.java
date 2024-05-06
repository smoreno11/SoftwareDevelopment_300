/******************************************************************************
 * AUTHOR      : Saul Moreno
 * ASSIGNMENT# : Midterm 2
 * CLASS       : CSC 300
 * Due         : 5/5/24
 ******************************************************************************/

import java.util.Comparator;

class PatientPriority implements Comparator<Patient> 
{
  @Override
  public int compare(Patient p1, Patient p2) 
  {
      if (p1.getPatientType().equals(p2.getPatientType())) 
      {
          return p1.getArrivalTimeAtEmergencyFacility() - p2.getArrivalTimeAtEmergencyFacility();
      } 
      else 
      {
          return p1.compareTo(p2);
      }
  }
}