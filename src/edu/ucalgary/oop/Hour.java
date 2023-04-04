package edu.ucalgary.oop;

import java.util.*;

public class Hour {
    private String hourstr;
    private int hour;
    private int minsleft = 60;
    private ArrayList<Treatment> hourtreatments = new ArrayList<Treatment>();
    private boolean backupvolunteer = false;

    public Hour(int givenhour){
        if(0 < givenhour  && givenhour >= 24){
            this.hour = givenhour;
            this.hourstr = givenhour + ":00";
        }
    }

    public void addTreatment(Treatment giveTreatment){
        this.hourtreatments.add(giveTreatment);
        this.minsleft -= giveTreatment.getAnimalTask().getTaskDuration();
    }
    
    public void addBackup(){
        // if(this.backupvolunteer){
        //     this.backupvolunteer = false;
        //     this.hour -= 60;
        // }
        // else{
        //     this.backupvolunteer = true;
        //     this.hour += 60;
        // }

        int netmins = 0;
            
        for(int i = 0; i < this.hourtreatments.size(); i++){
            netmins += hourtreatments.get(i).getAnimalTask().getTaskDuration();
        }

        if(netmins + 60 <= 120){
            this.backupvolunteer = true;
            this.minsleft += 60;
        }
        else{
            throw new IllegalArgumentException("Not enough time present within the hour");
        }


    }

    public int getHour(){
        return this.hour;
    }

    public String gethourStr(){
        return this.hourstr;
    }

    public int getminsleft(){
        return this.minsleft;
    }

    public boolean getBackupvolunteer(){
        return this.backupvolunteer;
    }


}
