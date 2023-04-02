package edu.ucalgary.oop;

public class Scheduler {
    private Treatment[] treatments;

    public Scheduler(){
    }

    public void addTreatment(Treatment givenTreatment){
        if (treatments == null) {
            treatments = new Treatment[1];
            treatments[0] = givenTreatment;
        } else {
            Treatment[] newTreatments = new Treatment[treatments.length + 1];
            for (int i = 0; i < treatments.length; i++) {
                newTreatments[i] = treatments[i];
            }
            newTreatments[newTreatments.length - 1] = givenTreatment;
            treatments = newTreatments;
        }

    }
    
    public Treatment[] getTreatments(){
        return this.treatments;
    }
}
