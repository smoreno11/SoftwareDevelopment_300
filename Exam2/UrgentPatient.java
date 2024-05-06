/******************************************************************************
 * AUTHOR      : Saul Moreno
 * ASSIGNMENT# : Midterm 2
 * CLASS       : CSC 300
 * Due         : 5/5/24
 ******************************************************************************/

public class UrgentPatient extends Patient {
    private String patientID;

    public UrgentPatient(int arrivalTime) 
    {
        super(arrivalTime);
        setPatientType("URGENT");
        setPatientID();
    }

    @Override
    public void setPatientID() 
    {
        idCounter++;
        this.patientID = "URGENT " + idCounter;
    }

    @Override
    public String getPatientID() 
    {
        return patientID;
    }
}
