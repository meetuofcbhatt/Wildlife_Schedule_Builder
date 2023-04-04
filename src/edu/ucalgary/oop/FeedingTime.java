package edu.ucalgary.oop;

public class FeedingTime {
	private int feedingDuration;
	private int prepTime;
	private int startHour;
	private int maxWindow;
	
	public FeedingTime(int duration, int prep, int start, int maxWind) {
		this.feedingDuration = duration;
		this.prepTime = prep;
		this.startHour = start;
		this.maxWindow = maxWind;
	}
	
	public int getFeedingDuration() {
		return this.feedingDuration;
	}
	
	public void setFeedingDuration(int duration) {
		this.feedingDuration = duration;
	}
	
	public int getPrepTime() {
		return this.prepTime;
	}
	
	public void setPrepTime(int prep) {
		this.prepTime = prep;
	}
	
	public int getStartHour() {
		return this.startHour;
	}
	
	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}
	
	public int getMaxWindow() {
		return this.maxWindow;
	}
	
	public void setMaxWindow(int maxWindow) {
		this.maxWindow = maxWindow;
	}
}
