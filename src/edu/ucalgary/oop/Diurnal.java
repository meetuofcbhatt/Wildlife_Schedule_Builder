package edu.ucalgary.oop;

abstract class Diurnal extends Animal{
	public Diurnal(String name, int animalID, String species, 
			int feedingDuration, int prepTime) {
		super(name, animalID, species, "Diurnal", 
				feedingDuration, prepTime, 8, 3);
	}
}
