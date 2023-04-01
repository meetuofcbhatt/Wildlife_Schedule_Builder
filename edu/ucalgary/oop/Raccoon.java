package edu.ucalgary.oop;

public class Raccoon extends Nocturnal{
	private final int CAGECLEANINGDURATION = 5;
	
	public Raccoon(String name, int animalID) {
		super(name, animalID, "Raccoon", 5, 0);
	}
	
	public int getCageClean() {
		return this.CAGECLEANINGDURATION;
	}
}
