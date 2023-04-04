package edu.ucalgary.oop;

abstract class Crepuscular extends Animal {
	
	public Crepuscular(String name, int animalID, String species, 
			int feedingDuration, int prepTime) {
		super(name, animalID, species, "Crepuscular", 
				feedingDuration, prepTime, 19, 3);
	}
}
