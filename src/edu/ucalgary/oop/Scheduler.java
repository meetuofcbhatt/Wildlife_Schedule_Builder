package edu.ucalgary.oop;

import java.util.*;
// import java.sql.*;

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

        // for (int i = 0; i < treatmentarray.size() - 1; i++) {
        //     int minIndex = i;
        //     for (int j = i + 1; j < treatmentarray.size(); j++) {
        //         if (treatmentarray.get(j).getStartHour() < treatmentarray.get(minIndex).getStartHour()) {
        //             minIndex = j;
        //         }
        //     }
        //     if (minIndex != i) {
        //         Treatment temp = treatmentarray.get(i);
        //         treatmentarray.set(i, treatmentarray.get(minIndex));
        //         treatmentarray.set(minIndex, temp);
        //     }
        // }

        // sorting treatmentarray by MaxWindow

        for (int i = 0; i < treatmentarray.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < treatmentarray.size(); j++) {
                if (treatmentarray.get(j).getAnimalTask().getMaxWindow() < treatmentarray.get(minIndex).getAnimalTask().getMaxWindow()) {
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

        // ArrayList<Hour> organizedhours = new ArrayList<Hour>(24);                 // this should be sorted and cannot contain duplicates




        // for(int i = 0; i < treatmentarray.size(); i++){
        //     for(int j = 0; j <= 24; j++){
        //         Hour temp_new_hour = new Hour(treatmentarray.get(i).getStartHour());
        //         if(treatmentarray.get(i).getStartHour() == j){

        //         }


        //     }



        // }

        ArrayList<Hour> completeHours = new ArrayList<Hour>(24);
        for(int i = 0; i < 24; i++)
        {
            completeHours.add(new Hour(i));
        }

        for(int i = 0; i < treatmentarray.size(); i++){
            

            Hour currtime = completeHours.get(treatmentarray.get(i).getStartHour());
            
            if(currtime.getminsleft() >= treatmentarray.get(i).getAnimalTask().getTaskDuration()){           // if hour has enough time in it
                currtime.addTreatment(treatmentarray.get(i));           // add treatment to the hour and update the completeHours list
                // completeHours.add(currtime.getHour(), currtime);
                // currtime = new Hour(currtime.getHour() + 1);
            }
            else{
                boolean placement = false;
                
                int maxWind = treatmentarray.get(i).getAnimalTask().getMaxWindow();

                for(int j = 0; j < maxWind; j++){
                    Hour tempHour = completeHours.get(treatmentarray.get(i).getStartHour() + j);
                    if(tempHour.getminsleft() >= treatmentarray.get(i).getAnimalTask().getTaskDuration()){
                        tempHour.addTreatment(treatmentarray.get(i));
                        placement = true;
                        break;
                    }
                    
                    // TODO: add an else here
                }

                if(placement == false){
                    
                    for(int k = 0; k < maxWind; k++){
                        Hour tempHour = completeHours.get(treatmentarray.get(i).getStartHour() + k); 
                        if(!tempHour.getBackupvolunteer()){
                            tempHour.addTreatment(treatmentarray.get(i));
                            placement = true;
                            break;
                        }
                    }

                    if(placement == false){
                        // make a custom exception here
                        System.out.println("Schedule not possible");
                    }


                }


            }


        }


        for(int l = 0; l < completeHours.size(); l++)
        {
            System.out.println("Hour " +Integer.toString(l)+ ": "+ Integer.toString(completeHours.get(l).getminsleft()));
        }



    }

    public static void main(String[] args){
        
        // try {
		// 	Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EWR","oop","password");
		// 	Statement stmt = con.createStatement();
		// 	ResultSet rs = stmt.executeQuery("SELECT * FROM ANIMALS");
		// 	while (rs.next()) {
		// 		System.out.println(rs.getString("AnimalID") + ", " + rs.getString("AnimalNickname") + ", " + rs.getString("AnimalSpecies"));
		// 	}
		// 	con.close();
		// } catch (SQLException e) {
		// 	System.out.println("error happened");
		// 	e.printStackTrace();
		// }

        Treatment treatment1 = new Treatment(new Beaver("hello", 2), new Task(1, "task1", 3, 5), 12, 2);
        Treatment treatment2 = new Treatment(new Beaver("hi", 2), new Task(1, "task2", 3, 3), 1, 2);
        Treatment treatment3 = new Treatment(new Beaver("bingus", 2), new Task(1, "task3", 3, 2), 5, 2);
        Treatment treatment4 = new Treatment(new Beaver("lastguy", 2), new Task(1, "task1", 3, 6), 3, 2);

        Scheduler testscheduler = new Scheduler(treatment1);
        testscheduler.addTreatment(treatment2);
        testscheduler.addTreatment(treatment3);
        testscheduler.addTreatment(treatment4);

        System.out.println("unordered");

        for(int i = 0; i < testscheduler.getTreatments().size(); i++){
            System.out.println(testscheduler.getTreatments().get(i).getAnimalTask().getMaxWindow());
        }

        System.out.println("Hours: ");
        testscheduler.organize();

        System.out.println("ordered");

        for(int i = 0; i < testscheduler.getTreatments().size(); i++){
            System.out.println(testscheduler.getTreatments().get(i).getAnimalTask().getMaxWindow());
        }
    }



}
