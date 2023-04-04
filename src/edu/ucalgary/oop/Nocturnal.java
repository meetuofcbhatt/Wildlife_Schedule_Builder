package edu.ucalgary.oop;

abstract class Nocturnal extends Animal {
	public Nocturnal(String name, int animalID, String species, 
			int feedingDuration, int prepTime) {
		super(name, animalID, species, "Nocturnal", 
				feedingDuration, prepTime, 0, 3);
	}
}