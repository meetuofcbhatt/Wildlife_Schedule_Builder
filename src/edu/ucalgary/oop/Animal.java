package edu.ucalgary.oop;

abstract class Animal {
	protected String name;
	private final String TIMEACTIVE;

	private FeedingTime feedingTime;
	private final String SPECIES;
	private final int ANIMALID;
	
	
	public Animal(String name, int animalID, String species, String timeActive,
			int feedingDuration, int prepTime, int startHour, int maxWindow) {
		this.name = name;
		this.TIMEACTIVE = timeActive;
		
		this.feedingTime = new FeedingTime(feedingDuration, prepTime, startHour, maxWindow);
		this.SPECIES = species;
		this.ANIMALID = animalID;
	}

	public void removeFeedingTime () {
		this.feedingTime = null;
	}

	public String getSpecies() {
		return this.SPECIES;
	}

	public void setName(String newName) {
		this.name = newName;
	}
	
	public FeedingTime getFeedingTime() {
		return this.feedingTime;
	}
	
	public void setFeedingTime(int feedingDuration, int prepTime, int startHour, int maxWindow) {
		this.feedingTime = new FeedingTime(feedingDuration, prepTime, startHour, maxWindow);
	}
	
	public String getName() {
		return this.name;
	}

	public int getAnimalID() {
		return this.ANIMALID;
	}
}
