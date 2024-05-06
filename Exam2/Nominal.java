/******************************************************************************
 * AUTHOR      : Saul Moreno
 * ASSIGNMENT# : Midterm 2
 * CLASS       : CSC 300
 * Due         : 5/5/24
 ******************************************************************************/

class Nominal extends Patient 
{
  private String patientID;

  public Nominal(int arrivalTime) 
  {
      super(arrivalTime);
      setPatientType("NOMINAL ");
      setPatientID();
  }

  @Override
  public void setPatientID() 
  {
      idCounter++;
      patientID = patientType + idCounter;
  }

  @Override
  public String getPatientID() 
  {
      return patientID;
  }

  //Returns an int based on a reversal of the natural order for the String patientType
  @Override
  public int compareTo(Patient other) 
  {
      return -patientType.compareTo(other.getPatientType());
  }
}