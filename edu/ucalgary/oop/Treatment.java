package edu.ucalgary.oop;

public class Treatment {

    private FeedingTime feedingTime;
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
    }

    public Treatment(Fox giveAnimal, Task givenAnimalTask, int givenStartHour, int animalID)
    {
        this.startHour = givenStartHour;
        this.animalTask = givenAnimalTask;
        this.animalTreatment = giveAnimal;
		this.ANIMALID = animalID;
    }

    public Treatment(Porcupine giveAnimal, Task givenAnimalTask, int givenStartHour, int animalID)
    {
        this.startHour = givenStartHour;
        this.animalTask = givenAnimalTask;
        this.animalTreatment = giveAnimal;
		this.ANIMALID = animalID;
    }


    public Treatment(Raccoon giveAnimal, Task givenAnimalTask, int givenStartHour, int animalID)
    {
        this.startHour = givenStartHour;
        this.animalTask = givenAnimalTask;
        this.animalTreatment = giveAnimal;
		this.ANIMALID = animalID;
    }

    public Treatment(Beaver giveAnimal, Task givenAnimalTask, int givenStartHour, int animalID)
    {
        this.startHour = givenStartHour;
        this.animalTask = givenAnimalTask;
        this.animalTreatment = giveAnimal;
		this.ANIMALID = animalID;
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

    public static void main(String[] args){
        
        Treatment testTreatment = new Treatment(new Coyote("hi", 1), new Task(0, "description", 123, 123), 0, 0);
        System.out.println(testTreatment.getAnimal().getName());
        


    }

    public int getStartHour() {
        return this.startHour;
    }

    public void setStartHour(int givenStartHour) {
        this.startHour = givenStartHour;
    }

}