package edu.ucalgary.oop;

public class Task {
    private int taskDuration;
	private int taskID;
	private String description;
	private int maxWindow;
    
    public Task(int id, String des, int duration, int maxWind)
    {
        this.taskID = id;
        this.taskDuration = duration;
        this.description = des;
        this.maxWindow = maxWind;
    }

    public void setTaskDuration(int duration){
        this.taskDuration = duration;
    }

    public void setDescription(String des){
        this.description = des;
    }

    public void setMaxWindow(int maxWind){
        this.maxWindow = maxWind;
    }

    public String getDescription(){
        return this.description;
    }

    public int getTaskDuration(){
        return this.taskDuration;
    }

    public int getMaxWindow(){
        return this.maxWindow;
    }

    public int getTaskID(){
        return this.taskID;
    }
}
