package edu.ucalgary.oop;

import java.util.*;


public class Scheduler {

    private ArrayList<Treatment> treatments = new ArrayList<Treatment>();

    public Scheduler(Treatment givenTreatments){
        this.treatments.add(givenTreatments);
    }

    public void addTreatment(Treatment givenTreatment){

        // Should not need to use this code anymore, changed from an array to an ArrayList

        // if (treatments == null) {
        //     treatments = new Treatment[1];
        //     treatments[0] = givenTreatment;
        // } else {
        //     Treatment[] newTreatments = new Treatment[treatments.length + 1];
        //     for (int i = 0; i < treatments.length; i++) {
        //         newTreatments[i] = treatments[i];
        //     }
        //     newTreatments[newTreatments.length - 1] = givenTreatment;
        //     treatments = newTreatments;
        // }    
            
        this.treatments.add(givenTreatment);

    }
    
    public ArrayList<Treatment> getTreatments(){
        return this.treatments;
    }

    public void organize(){

        ArrayList<Treatment> treatmentarray = this.treatments;

        // sorting treatmentarray by startHour

        for (int i = 0; i < treatmentarray.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < treatmentarray.size(); j++) {
                if (treatmentarray.get(j).getStartHour() < treatmentarray.get(minIndex).getStartHour()) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Treatment temp = treatmentarray.get(i);
                treatmentarray.set(i, treatmentarray.get(minIndex));
                treatmentarray.set(minIndex, temp);
            }
        }

        // this.treatments = treatmentarray;

        ArrayList<Hour> organizedhours = new ArrayList<Hour>();                 // this should be sorted and cannot contain duplicates

        int currtime = treatmentarray.get(0).getStartHour();

        // for(int i = 0; i < treatmentarray.size(); i++){
            



        // }







    }

    public static void main(String[] args){
        

        Treatment treatment1 = new Treatment(new Beaver("hello", 2), new Task(1, "task1", 3, 4), 12, 2);
        Treatment treatment2 = new Treatment(new Beaver("hi", 2), new Task(1, "task2", 3, 4), 1, 2);
        Treatment treatment3 = new Treatment(new Beaver("bingus", 2), new Task(1, "task3", 3, 4), 5, 2);
        Treatment treatment4 = new Treatment(new Beaver("lastguy", 2), new Task(1, "task1", 3, 4), 3, 2);

        Scheduler testscheduler = new Scheduler(treatment1);
        testscheduler.addTreatment(treatment2);
        testscheduler.addTreatment(treatment3);
        testscheduler.addTreatment(treatment4);

        System.out.println("unordered");

        for(int i = 0; i < testscheduler.getTreatments().size(); i++){
            System.out.println(testscheduler.getTreatments().get(i).getStartHour());
        }


        testscheduler.organize();

        System.out.println("ordered");

        for(int i = 0; i < testscheduler.getTreatments().size(); i++){
            System.out.println(testscheduler.getTreatments().get(i).getStartHour());
        }
    }



}
