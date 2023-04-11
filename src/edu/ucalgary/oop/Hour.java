package edu.ucalgary.oop;

import java.util.*;



public class Hour {
    private String hourstr;
    private int hour;
    private int minsleft = 60;
    private ArrayList<Treatment> hourtreatments = new ArrayList<Treatment>();
    private boolean backupvolunteer = false;

    public Hour(int givenhour){
        if(0 <= givenhour && givenhour < 24){
            this.hour = givenhour;
            this.hourstr = Integer.toString(givenhour) + ":00";
        }
    }

    public void addTreatment(Treatment giveTreatment){
        this.hourtreatments.add(giveTreatment);
        this.minsleft -= giveTreatment.getAnimalTask().getTaskDuration();
    }
    public void addFeedingTask(Treatment feedingTreat, int aniNumb, String nameString)
    {
        //basically, use FeedingTime obj in Treatment Obj to calculate the correct duration for the Task obj 'AnimalTask' and add that to feedTreat, which will go to it's approriate treatment obj ArrayList in hour.
        int dur = feedingTreat.getAnimal().getFeedingTime().getFeedingDuration();
        int prep = feedingTreat.getAnimal().getFeedingTime().getPrepTime();
        int maxWind = feedingTreat.getAnimal().getFeedingTime().getMaxWindow();
        int calcDuration = prep + (aniNumb * dur);
        //descrption of task needs to have names of coyote
        
        String descriptionTask = "Feeding - " + feedingTreat.getAnimal().getSpecies() + " (" + Integer.toString(aniNumb) + ": " + nameString + ")";

        Task taskToAdd = new Task(0, descriptionTask, calcDuration, maxWind);
        feedingTreat.setAnimalTask(taskToAdd);
        this.hourtreatments.add(feedingTreat);
        this.minsleft -= calcDuration;
    }
    public void printTreatment()
    {
        for(int i = 0; i < hourtreatments.size(); i++)
        {
            if(hourtreatments.get(i).getAnimalTask().getDescription() != null)
            {
                System.out.println(hourtreatments.get(i).getAnimalTask().getDescription());
            }
        }
    }

    public String getInfo()
    {
        String finalResult = "";
        //logic for adding onto the finalResult.

        if(this.hourtreatments.size() > 0)//only execute this if there is something in this hour in the first place.
        {
            finalResult = finalResult + this.hourstr;

            if(this.backupvolunteer)
            {
                finalResult = finalResult + " [+ backup volunteer]\n";
            }
            else
            {
                finalResult = finalResult + "\n";
            }

            for(int i = 0; i < hourtreatments.size(); i++)
            {
                //goes through how treatment ArrayList. if the treatments don't have 
                if(hourtreatments.get(i).getAnimalTask().getDescription() != null)
                {
                    if(hourtreatments.get(i).getAnimalTask().getTaskID() != 0)//not cageClean nor feedingTask
                    {
                        finalResult = finalResult + "* " + hourtreatments.get(i).getAnimalTask().getDescription() + " ("+hourtreatments.get(i).getAnimal().getName() + ")\n";
                    }
                    else
                    {
                        finalResult = finalResult + "* " + hourtreatments.get(i).getAnimalTask().getDescription() + "\n";
                    }
                }
                else if(i == hourtreatments.size() - 1)
                {
                    finalResult = finalResult + "* " + hourtreatments.get(i).getAnimalTask().getDescription();
                }
            }

            finalResult = finalResult + "\n";

        }
        System.out.print(finalResult);
        return finalResult;
    }

    // public String hourStr()
    // {
    //     String finalResult = this.gethourStr();
    // }
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
            new GUIBackupVolunteerConfirmation(this).setVisible(true);
            this.backupvolunteer = true;
            this.minsleft += 60;
        }
        else{
            throw new IllegalArgumentException("Not enough time present within the hour");
        }


    }

    public int getHourTreatmentsSize()
    {
        return this.hourtreatments.size();
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

    public ArrayList<Treatment> getTreatments(){
        return this.hourtreatments;
    }

    public static void main(String[] args)
    {
        Hour newHour = new Hour(2);//hour for 2am

        Fox newFox = new Fox("One, Two, and Three", 6);
        Task newTask = new Task(1, "Kit Feeding", 30, 2);
        //add this treat to hour of 2am
        Treatment newTreat = new Treatment(newFox, newTask, 2, 6);//at 2 am
        newHour.addTreatment(newTreat);

        //add their feeding times to the hour of 2am
        Coyote newCoyote = new Coyote("Coyote1", 1);
        Beaver newBeaver = new Beaver("Beaver1", 2);
        Fox anotherFox = new Fox("Fox1", 3);
        Porcupine newPor = new Porcupine("Por1", 4);
        Raccoon newRac = new Raccoon("Rac1", 5);

        Task coyFeedTask = new Task(0, "something", 5, 3);
        Task beaFeedTask = new Task(0, "something", 5, 3);
        Task foxFeedTask = new Task(0, "something", 5, 3);
        Task porFeedTask = new Task(0, "something", 5, 3);
        Task racFeedTask = new Task(0, "something", 5, 3);
        //
        Treatment coyFeed = new Treatment(newCoyote, coyFeedTask, 2, 0);
        Treatment beaFeed = new Treatment(newBeaver, beaFeedTask, 2, 0);
        Treatment foxFeed = new Treatment(anotherFox, foxFeedTask, 2, 0);
        Treatment porFeed = new Treatment(newPor, porFeedTask, 2, 0);
        Treatment racFeed = new Treatment(newRac, racFeedTask, 2, 0);


        newHour.addFeedingTask(coyFeed, 1, "Feeding - coyote (1: Coyote1)");
        newHour.addFeedingTask(beaFeed, 1, "Feeding - beaver (1: Beaver1)");
        // newHour.addFeedingTask(foxFeed, 1, "Feeding - fox (1: Fox1)");
        newHour.addFeedingTask(porFeed, 1, "Feeding - porcupine (1: Por1)");
        newHour.addFeedingTask(racFeed, 1, "Feeding - raccoon (1: Rac1)");

        // assertEquals(0, newHour.getminsleft());

        newHour.getInfo();
    }
}