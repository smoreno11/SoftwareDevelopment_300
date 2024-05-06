/******************************************************************************
 * AUTHOR      : Saul Moreno
 * ASSIGNMENT# : Midterm 2
 * CLASS       : CSC 300
 * Due         : 5/5/24
 ******************************************************************************/

public class SeverePatient extends Patient {
    private String patientID;

    public SeverePatient(int arrivalTime) 
    {
        super(arrivalTime);
        setPatientType("SEVERE");
        setPatientID();
    }

    @Override
    public void setPatientID() 
    {
        idCounter++;
        this.patientID = "SEVERE " + idCounter;
    }

    @Override
    public String getPatientID() 
    {
        return patientID;
    }
}
