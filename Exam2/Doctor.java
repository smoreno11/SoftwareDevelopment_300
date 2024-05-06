/******************************************************************************
 * AUTHOR      : Saul Moreno
 * ASSIGNMENT# : Midterm 2
 * CLASS       : CSC 300
 * Due         : 5/5/24
 ******************************************************************************/

import java.util.*;

class Doctor {
    public static int doctorCounter = 0;
    private boolean isFree;
    private int doctorIDNumber;
    private int totalPatientsSeenByDoctor;
    private int timeRemainingForExam;
    private Patient assignedPatient;

    public Doctor() 
    {
        setDoctorIDNumber();
        setIsFree(true);
    }

    public boolean getIsFree() 
    {
        return isFree;
    }

    public void setIsFree(boolean isFree) 
    {
        this.isFree = isFree;
    }

    public int getDoctorIDNumber() 
    {
        return doctorIDNumber;
    }

    private void setDoctorIDNumber() 
    {
        doctorCounter++;
        this.doctorIDNumber = doctorCounter;
    }

    public Patient getAssignedPatient()
     {
        return assignedPatient;
    }

    public void setAssignedPatient(Patient assignedPatient) 
    {
        this.assignedPatient = assignedPatient;
        setIsFree(false);
    }

    public Patient removeAssignedPatient() 
    {
        Patient tempPatient = assignedPatient;
        assignedPatient = null;
        setIsFree(true);
        totalPatientsSeenByDoctor++;
        return tempPatient;
    }

    public int getTimeRemainingForExam() 
    {
        return timeRemainingForExam;
    }

    public void setTimeRemainingForExam(int timeRemainingForExam)
    {
        this.timeRemainingForExam = timeRemainingForExam;
    }

    public void decrementTimeRemainingForExam() 
    {
        timeRemainingForExam--;
    }

    @Override
    public String toString() {
        return "Doctor " + doctorIDNumber + " examines " + totalPatientsSeenByDoctor + " patients";
    }
}
