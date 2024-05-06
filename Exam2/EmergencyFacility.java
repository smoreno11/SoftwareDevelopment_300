/******************************************************************************
 * AUTHOR      : Saul Moreno
 * ASSIGNMENT# : Midterm 2
 * CLASS       : CSC 300
 * Due         : 5/5/24
 ******************************************************************************/

import java.util.*;
import java.io.PrintWriter;
import java.io.IOException;

public class EmergencyFacility {
    private Random randy;
    private PriorityQueue<Patient> waitingQ;
    private ArrayList<Patient> processedPatients;
    private Doctor[] doctors;
    private String facilityName;
    private int currentTime;

    public EmergencyFacility(String name, int seed, int numDoctors) {
        facilityName = name;
        randy = new Random(seed);
        waitingQ = new PriorityQueue<>(new PatientPriority());
        processedPatients = new ArrayList<>();
        createDoctors(numDoctors);
    }

    private void createDoctors(int numDoctors) {
        doctors = new Doctor[numDoctors];
        for (int i = 0; i < numDoctors; i++) {
            doctors[i] = new Doctor();
        }
    }

    public void openEmergencyFacility() {
        currentTime = 0;
        for (; currentTime < 10; currentTime++) {
            for (int i = 0; i < 10; i++) {
                int randomNumber = randy.nextInt(20) + 1;
                if (randomNumber < 8)
                    waitingQ.offer(new UrgentPatient(currentTime));
                else if (randomNumber < 16)
                    waitingQ.offer(new SeverePatient(currentTime));
                else
                    waitingQ.offer(new Nominal(currentTime));
            }
        }
    }

    public void operateEmergencyFacility(int durationForArriving) 
    {
        int endArrivalsTime = currentTime + durationForArriving;
        while (processedPatients.size() != Patient.idCounter || currentTime < endArrivalsTime)
        {
            if (currentTime < endArrivalsTime) {
                for (int i = 0; i < 6; i++)
                {
                    int randomNumber = randy.nextInt(20) + 1;
                    if (randomNumber < 7)
                        waitingQ.offer(new UrgentPatient(currentTime));
                    else if (randomNumber < 14)
                        waitingQ.offer(new SeverePatient(currentTime));
                    else
                        waitingQ.offer(new Nominal(currentTime));
                }
            }

            for (Doctor doctor : doctors) 
            {
                if (!doctor.getIsFree()) {
                    doctor.decrementTimeRemainingForExam();
                    if (doctor.getTimeRemainingForExam() == 0) {
                        Patient tempPatient = doctor.removeAssignedPatient();
                        tempPatient.setTotalTimeAtEmergencyFacility(currentTime);
                        processedPatients.add(tempPatient);
                    }
                }
            }

            for (Doctor doctor : doctors)
            {
                if (doctor.getIsFree() && !waitingQ.isEmpty()) {
                    Patient tempPatient = waitingQ.poll();
                    tempPatient.setDoctorStartTime(currentTime);
                    doctor.setAssignedPatient(tempPatient);
                    int examDuration = randy.nextInt(16) + 10; // Random number from 10 to 25
                    tempPatient.setExamDuration(examDuration);
                    doctor.setTimeRemainingForExam(examDuration);
                }
            }

            currentTime++;
        }//end while (processedPatients.size() != Patient.idCounter || currentTime < endArrivalsTime)
    }


    public void generateEmergencyFacilityResults(String outputFile) throws IOException {
        int totalUrgentTime = 0;
        int totalUrgentPatients = 0;
        int totalSevereTime = 0;
        int totalSeverePatients = 0;
        int totalNominalTime = 0;
        int totalNominalPatients = 0;
        int totalPatients = 0;
        int totalOverallTime = 0;
        double avgUrgentTime = 0;
        double avgSevereTime = 0;
        double avgNominalTime = 0;
        double avgOverallTime = 0;
    

        try (PrintWriter writer = new PrintWriter(outputFile)) 
        {
            writer.println("Data For Emergency Facility " + facilityName);
            writer.println();
            writer.println("Summary Data");
            for (Doctor doctor : doctors) 
            {
                writer.println(doctor);
            }
            writer.println();
    
            
            for (Patient patient : processedPatients) 
            {
                switch (patient.getPatientType()) {
                    case "URGENT":
                        totalUrgentTime += patient.getTotalTimeAtEmergencyFacility();
                        totalUrgentPatients++;
                        break;
                    case "SEVERE":
                        totalSevereTime += patient.getTotalTimeAtEmergencyFacility();
                        totalSeverePatients++;
                        break;
                    case "NOMINAL":
                        totalNominalTime += patient.getTotalTimeAtEmergencyFacility();
                        totalNominalPatients++;
                        break;
                    default:
                        break;
                }
                totalPatients++;
                totalOverallTime += patient.getTotalTimeAtEmergencyFacility();
            }
            
            if (totalUrgentPatients != 0) 
            {
                avgUrgentTime = (double) totalUrgentTime / totalUrgentPatients;
            }
           
            if (totalSeverePatients != 0) 
            {
                avgSevereTime = (double) totalSevereTime / totalSeverePatients;
            }
       
            if (totalNominalPatients != 0) 
            {
                avgNominalTime = (double) totalNominalTime / totalNominalPatients;
            }
            
            if (totalPatients != 0) 
            {
                avgOverallTime = (double) (totalUrgentTime + totalSevereTime + totalNominalTime) / totalPatients;
            }
    
            writer.println("The average total time at Emergency Facility per patient for " + totalUrgentPatients 
                            + " Urgent Patients is " + String.format("%.2f", avgUrgentTime) + " minutes");
            writer.println("The average total time at Emergency Facility per patient for " + totalSeverePatients 
                             + " Severe Patients is " + String.format("%.2f", avgSevereTime) + " minutes");
            writer.println("The average total time at Emergency Facility per patient for " + totalNominalPatients 
                                   + " Nominal Patients is " + String.format("%.2f", avgNominalTime) + " minutes");
            writer.println("The average total time in office per patient for " + totalPatients + " Patients is " 
                                                      + String.format("%.2f", avgOverallTime) + " minutes");
            writer.println();
            writer.println("  Patient ID       Patient TYPE    ARRIVAL TIME     WAIT TIME          EXAM TIME   TOTAL TIME");
            for (Patient patient : processedPatients) 
            {
                writer.printf("%13s %17s %15d %13d %15d %13d%n", patient.getPatientID(), 
                patient.getPatientType(), patient.getArrivalTimeAtEmergencyFacility(), patient.getWaitTime(), 
                patient.getExamDuration(), patient.getTotalTimeAtEmergencyFacility());
            }
        }
        }
    }
    