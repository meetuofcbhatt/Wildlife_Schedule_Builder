package edu.ucalgary.oop;

public class Fox extends Nocturnal{
	private final int CAGECLEANINGDURATION = 5;
	
	public Fox(String name, int animalID) {
		super(name, animalID, "fox", 5, 5);
	}
	
	public int getCageClean() {
		return this.CAGECLEANINGDURATION;
	}
}
