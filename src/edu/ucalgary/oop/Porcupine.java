package edu.ucalgary.oop;

public class Porcupine extends Crepuscular {
	private final int CAGECLEANINGDURATION = 10;
	
	public Porcupine(String name, int animalID) {
		super(name, animalID, "Porcupine", 5, 0);
	}
	
	public int getCageClean() {
		return this.CAGECLEANINGDURATION;
	}
}
