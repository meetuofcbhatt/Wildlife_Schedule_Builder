package edu.ucalgary.oop;

public class Treatment {

    private FeedingTime feedingTime;
    private final int ANIMALID;
    private int startHour;
    private Animal animalTreatment;
    private Task animalTask;

    public Treatment(Animal giveAnimal, Task givenAnimalTask, int givenStartHour, int animalID)
    {
        this.startHour = givenStartHour;
        this.animalTask = givenAnimalTask;
        this.animalTreatment = giveAnimal;
		this.ANIMALID = animalID;
    }

    public Task getAnimalTasks(){
        return this.animalTask;
    }

    public void setAnimalTasks(Task addedTasks){
        this.animalTask = addedTasks;
    }

}