package edu.ucalgary.oop;

public class Beaver extends Diurnal{
	private final int CAGECLEANINGDURATION = 5;
	
	public Beaver(String name, int animalID) {
		super(name, animalID, "beaver", 5, 0);
	}
	
	public int getCageClean() {
		return this.CAGECLEANINGDURATION;
	}
}
