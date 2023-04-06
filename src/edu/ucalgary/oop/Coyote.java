package edu.ucalgary.oop;

public class Coyote extends Crepuscular {
	private final int CAGECLEANINGDURATION = 5;
	
	public Coyote(String name, int animalID) { 
		super(name, animalID, "Coyote", 5, 10);
	}
	
	public int getCageClean() {
		return this.CAGECLEANINGDURATION;
	}
}