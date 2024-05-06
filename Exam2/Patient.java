/******************************************************************************
 * AUTHOR      : Saul Moreno
 * ASSIGNMENT# : Midterm 2
 * CLASS       : CSC 300
 * Due         : 5/5/24
 ******************************************************************************/

import java.util.*;

public abstract class Patient implements Comparable<Patient> {
    public static int idCounter = 0;
    protected int arrivalTimeAtEmergencyFacility;
    protected int doctorStartTime;
    protected int waitTime;
    protected int examDuration;
    protected int totalTimeAtEmergencyFacility;
    protected String patientType;

    public Patient(int arrivalTime) 
    {
        setArrivalTimeAtEmergencyFacility(arrivalTime);
    }

    public int getArrivalTimeAtEmergencyFacility() 
    {
        return arrivalTimeAtEmergencyFacility;
    }

    public void setArrivalTimeAtEmergencyFacility(int arrivalTime)
    {
        this.arrivalTimeAtEmergencyFacility = arrivalTime;
    }

    public int getDoctorStartTime() 
    {
        return doctorStartTime;
    }

    public void setDoctorStartTime(int doctorStartTime) 
    {
        this.doctorStartTime = doctorStartTime;
        this.waitTime = doctorStartTime - arrivalTimeAtEmergencyFacility;
    }

    public int getWaitTime() 
    {
        return waitTime;
    }

    public int getExamDuration() 
    {
        return examDuration;
    }

    public void setExamDuration(int examDuration) 
    {
        this.examDuration = examDuration;
    }

    public int getTotalTimeAtEmergencyFacility() {

        return totalTimeAtEmergencyFacility;
    }

    public void setTotalTimeAtEmergencyFacility(int endTime) 
    {
        this.totalTimeAtEmergencyFacility = endTime - arrivalTimeAtEmergencyFacility;
    }

    public String getPatientType() 
    {
        return patientType;
    }

    public void setPatientType(String patientType) 
    {

        this.patientType = patientType;
    }

    public abstract void setPatientID();

    public abstract String getPatientID();

    @Override
    public int compareTo(Patient o) 
    {
        return this.patientType.compareTo(o.patientType);
    }
}
