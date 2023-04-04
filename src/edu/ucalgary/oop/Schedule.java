package edu.ucalgary.oop;

public class Schedule {
    private String day;
    private Treatment [] orderedTreatment;
    private Scheduler finalScheduler;
    
    public Schedule(Scheduler givenScheduler){
        this.finalScheduler = givenScheduler;
    }

}
