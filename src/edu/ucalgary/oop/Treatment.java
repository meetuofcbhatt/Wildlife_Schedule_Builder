package edu.ucalgary.oop;

public class Treatment {

    private final int ANIMALID;
    private int startHour;
    private Animal animalTreatment;
    private Task animalTask;

    public Treatment(Coyote giveAnimal, Task givenAnimalTask, int givenStartHour, int animalID)
    {
        this.startHour = givenStartHour;
        this.animalTask = givenAnimalTask;
        this.animalTreatment = giveAnimal;
		this.ANIMALID = animalID;
        if (givenAnimalTask.getTaskID() == 1) {
            giveAnimal.removeFeedingTime();
        }
    }

    public Treatment(Fox giveAnimal, Task givenAnimalTask, int givenStartHour, int animalID)
    {
        this.startHour = givenStartHour;
        this.animalTask = givenAnimalTask;
        this.animalTreatment = giveAnimal;
		this.ANIMALID = animalID;
        if (givenAnimalTask.getTaskID() == 1) {
            giveAnimal.removeFeedingTime();
        }
    }

    public Treatment(Porcupine giveAnimal, Task givenAnimalTask, int givenStartHour, int animalID)
    {
        this.startHour = givenStartHour;
        this.animalTask = givenAnimalTask;
        this.animalTreatment = giveAnimal;
		this.ANIMALID = animalID;
        if (givenAnimalTask.getTaskID() == 1) {
            giveAnimal.removeFeedingTime();
        }
    }


    public Treatment(Raccoon giveAnimal, Task givenAnimalTask, int givenStartHour, int animalID)
    {
        this.startHour = givenStartHour;
        this.animalTask = givenAnimalTask;
        this.animalTreatment = giveAnimal;
		this.ANIMALID = animalID;
        if (givenAnimalTask.getTaskID() == 1) {
            giveAnimal.removeFeedingTime();
        }
    }

    public Treatment(Beaver giveAnimal, Task givenAnimalTask, int givenStartHour, int animalID)
    {
        this.startHour = givenStartHour;
        this.animalTask = givenAnimalTask;
        this.animalTreatment = giveAnimal;
		this.ANIMALID = animalID;
        if (givenAnimalTask.getTaskID() == 1) {
            giveAnimal.removeFeedingTime();
        }
    }


    public Animal getAnimal(){
        return this.animalTreatment;
    }


    public Task getAnimalTask(){
        return this.animalTask;
    }

    public void setAnimalTask(Task addedTasks){
        this.animalTask = addedTasks;
    }

    public int getStartHour() {
        return this.startHour;
    }

    public void setStartHour(int givenStartHour) {
        this.startHour = givenStartHour;
    }
}