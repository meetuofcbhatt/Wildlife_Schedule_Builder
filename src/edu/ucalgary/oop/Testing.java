package edu.ucalgary.oop;
/**
 * This Testing class is resposible for testing the contructors and methods of the all the classes in the program
 * All of the tests together will allow of the major functionality to be thorughly tested to make sure they work and any/all expcetions are
 * caught properly.
 * @author SahibThethi
 * @author Brian Chu
 * @version 2
 * @since April 2023
 */
import static org.junit.Assert.*;
import org.junit.*;
import java.util.regex.*;
import java.util.ArrayList;


public class Testing {


    /**
    * Test case for testing the Animal constructors and the setName method.
    */
    @Test
    public void testAnimalConstructorsAndSetName() {
        // Constructs a copy of each animal
        Coyote coyote = new Coyote("coyote", 1);
        Beaver beaver = new Beaver("beaver", 1);
        Fox fox = new Fox("fox", 1);
        Porcupine porcupine = new Porcupine("porcupine", 1);
        Raccoon raccoon = new Raccoon("raccoon", 1);
        // Tests if the names created are correct, also uses the getName function from Animal
        assertEquals("Coyote was not created with the correct name", "coyote", coyote.getName());
        assertEquals("Beaver was not created with the correct name", "beaver", beaver.getName());
        assertEquals("Fox was not created with the correct name", "fox", fox.getName());
        assertEquals("Porcupine was not created with the correct name", "porcupine", porcupine.getName());
        assertEquals("Raccoon was not created with the correct name", "raccoon", raccoon.getName());
        // Tests if the IDs created are correct, also uses the getAnimalID function from Animal
        assertEquals("Coyote was not created with the correct ID", 1, coyote.getAnimalID());
        assertEquals("Beaver was not created with the correct ID", 1, beaver.getAnimalID());
        assertEquals("Fox was not created with the correct ID", 1, fox.getAnimalID());
        assertEquals("Porcupine was not created with the correct ID", 1, porcupine.getAnimalID());
        assertEquals("Raccoon was not created with the correct ID", 1, raccoon.getAnimalID());


        coyote.setName("name");


        assertEquals("The setName function did not set to the correct name", "name", coyote.getName());
    }
   
    /**
     * This test method tests the species identification of Animal objects, It checks whether the species identification of each animal is
     * set correctly or not by using the assertEquals method to compare the actual and expected species identification strings.
     */
    @Test
    public void testGetSpecies() {
        Coyote coyote = new Coyote("coyote", 1);
        Beaver beaver = new Beaver("beaver", 1);
        Fox fox = new Fox("fox", 1);
        Porcupine porcupine = new Porcupine("porcupine", 1);
        Raccoon raccoon = new Raccoon("raccoon", 1);


        assertEquals("Coyote was not created with the correct Species identification", "Coyote", coyote.getSPECIES());
        assertEquals("Beaver was not created with the correct Species identification", "Beaver", beaver.getSPECIES());
        assertEquals("Fox was not created with the correct Species identification", "Fox", fox.getSPECIES());
        assertEquals("Porcupine was not created with the correct Species identification", "Porcupine", porcupine.getSPECIES());
        assertEquals("Raccoon was not created with the correct Species identification", "Raccoon", raccoon.getSPECIES());
    }
    /**
     *  This test method tests the creating of FeedingTime objects for all the possible animals and ensures that the feeding times are correctly
     * inialized with the ecpected values.
     */
    @Test
    public void testFeedingTimeCreation() {
        Coyote coyote = new Coyote("coyote", 1);
        Beaver beaver = new Beaver("beaver", 1);
        Fox fox = new Fox("fox", 1);
        Porcupine porcupine = new Porcupine("porcupine", 1);
        Raccoon raccoon = new Raccoon("raccoon", 1);


        assertEquals("Coyote was not created with the correct FeedingDuration", 5, coyote.getFeedingTime().getFeedingDuration());
        assertEquals("Coyote was not created with the correct MaxWindow", 3, coyote.getFeedingTime().getMaxWindow());
        assertEquals("Coyote was not created with the correct PrepTime", 10, coyote.getFeedingTime().getPrepTime());
        assertEquals("Coyote was not created with the correct StartHour", 19, coyote.getFeedingTime().getStartHour());


        assertEquals("Beaver was not created with the correct FeedingDuration", 5, beaver.getFeedingTime().getFeedingDuration());
        assertEquals("Beaver was not created with the correct MaxWindow", 3, beaver.getFeedingTime().getMaxWindow());
        assertEquals("Beaver was not created with the correct PrepTime", 0, beaver.getFeedingTime().getPrepTime());
        assertEquals("Beaver was not created with the correct StartHour", 8, beaver.getFeedingTime().getStartHour());


        assertEquals("Fox was not created with the correct FeedingDuration", 5, fox.getFeedingTime().getFeedingDuration());
        assertEquals("Fox was not created with the correct MaxWindow", 3, fox.getFeedingTime().getMaxWindow());
        assertEquals("Fox was not created with the correct PrepTime", 5, fox.getFeedingTime().getPrepTime());
        assertEquals("Fox was not created with the correct StartHour", 0, fox.getFeedingTime().getStartHour());


        assertEquals("Porcupine was not created with the correct FeedingDuration", 5, porcupine.getFeedingTime().getFeedingDuration());
        assertEquals("Porcupine was not created with the correct MaxWindow", 3, porcupine.getFeedingTime().getMaxWindow());
        assertEquals("Porcupine was not created with the correct PrepTime", 0, porcupine.getFeedingTime().getPrepTime());
        assertEquals("Porcupine was not created with the correct StartHour", 19, porcupine.getFeedingTime().getStartHour());
       
        assertEquals("Raccoon was not created with the correct FeedingDuration", 5, raccoon.getFeedingTime().getFeedingDuration());
        assertEquals("Raccoon was not created with the correct MaxWindow", 3, raccoon.getFeedingTime().getMaxWindow());
        assertEquals("Raccoon was not created with the correct PrepTime", 0, raccoon.getFeedingTime().getPrepTime());
        assertEquals("Raccoon was not created with the correct StartHour", 0, raccoon.getFeedingTime().getStartHour());
    }


    /**
     * This test method tests the cage cleaning duration for all the possible animals in the database. It ensures that Coyote, Beaver, Fox,
     * and Raccoon should have a cage cleaning duration of 5, while Porcupine should have a duration of 10.
     */
    @Test
    public void testCageClean() {
        Coyote coyote = new Coyote("coyote", 1);
        Beaver beaver = new Beaver("beaver", 1);
        Fox fox = new Fox("fox", 1);
        Porcupine porcupine = new Porcupine("porcupine", 1);
        Raccoon raccoon = new Raccoon("raccoon", 1);


        assertEquals("Coyote was not created with the correct Cage cleaning duration", 5, coyote.getCageClean());
        assertEquals("Beaver was not created with the correct Cage cleaning duration", 5, beaver.getCageClean());
        assertEquals("Fox was not created with the correct Cage cleaning duration", 5, fox.getCageClean());
        assertEquals("Porcupine was not created with the correct Cage cleaning duration", 10, porcupine.getCageClean());
        assertEquals("Raccoon was not created with the correct Cage cleaning duration", 5, raccoon.getCageClean());
    }


    /**
     * This test method tests the functionality of creating a kit feeding treatment for a Animal object. It will check if the kit feeding
     * removed a feeding time object through Animal and Treatment.
     */
    @Test
    public void testCreateKitFeeding() {
        Coyote coyote = new Coyote("coyote", 1);


        Treatment newTreat = new Treatment(coyote, new Task(1, "Kit feeding", 30, 2), 1, 1);


        assertEquals("Creating a treatment with Kit Feeding did not remove Feeding Time from the animal, Tested from Animal", null, coyote.getFeedingTime());
        assertEquals("Creating a treatment with Kit Feeding did not remove Feeding Time from the animal, Tested from Treatment", null, newTreat.getAnimal().getFeedingTime());
    }
    /**
     * Test the functionality of the the Task Class
     * Sets up a Task object with given properties, modifies some properties and asserts their values
     */
    @Test
    public void testingTask() {
        // create a Task object with given properties
        Task task = new Task(1, "Task 1", 5, 10);
    // test the setTaskDuration() method
        task.setTaskDuration(10);
        assertEquals("Task duration should be equal to 10 after calling setTaskDuration() method.", 10, task.getTaskDuration());
    // test the setDescription() method
        task.setDescription("Updated Task Description");
        assertEquals("Description should be equal to 'Updated Task Description' after calling setDescription() method.","Updated Task Description", task.getDescription());
    // test the setMaxWindow() method
        task.setMaxWindow(20);
        assertEquals("Max window should be equal to 20 after calling setMaxWindow() method.",20, task.getMaxWindow());
        // test the getTaskID() method
        assertEquals("Task ID should be equal to 1.", 1, task.getTaskID());
    }


/**
 * This test method tests the functionality of getAnimal() from the Treatment class.
 */
    @Test
    public void testingTreatmentGetAnimal() {
        Coyote coyote = new Coyote("Coyote", 1);
        Treatment treatment = new Treatment(coyote, new Task(0, "description", 123, 123), 0, 0);
        assertEquals("treatment.getAnimal() did not return the correct animal.", coyote, treatment.getAnimal());


    }


    /**
     * The method tests to ensure that the expected task for a given treatment is return using the getAnimalTask() method.
     */
    @Test
    public void testTreatmentGetAnimalTask() {
        Task task = new Task(0, "description", 123, 123);
        Treatment treatment = new Treatment(new Coyote("Coyote", 1), task, 0, 0);
        assertEquals("The getAnimalTask() method did not return the expected task for the given treatment.",task, treatment.getAnimalTask());
    }


    /**
     * Tests the functionality of setting and retrieving the animal task for a Treatment object.
     */
    @Test
    public void testTreatmentSetAnimalTask() {
        Task task1 = new Task(0, "description", 123, 123);
        Task task2 = new Task(1, "description", 123, 123);
        Treatment treatment = new Treatment(new Coyote("Coyote", 1), task1, 0, 0);
        assertEquals("The initial getAnimalTask() did not return the right value", treatment.getAnimalTask());
        treatment.setAnimalTask(task2);
        assertEquals("The new getAnimalTask() did not return the right value",task2, treatment.getAnimalTask());
    }


    /**
     * Tests the getStartHour method  to ensure that it return the correct start hour for a given treatment.
     */
    @Test
    public void testTreatmentGetStartHour() {
        Treatment treatment = new Treatment(new Coyote("Coyote", 1), new Task(0, "description", 123, 123), 1, 0);
        assertEquals("The start hour of the treatment should be 1",1, treatment.getStartHour());
    }


    /**
     * This method tests the functionality of the setStartHour method in the Treatment class. It ensure that a new hour updates over the old hour.
     */
    @Test
    public void testTreatmentSetStartHour() {
        Treatment treatment = new Treatment(new Coyote("Coyote", 1), new Task(0, "description", 123, 123), 0, 0);
        assertEquals("Initial start hour should be 0",0, treatment.getStartHour());
        treatment.setStartHour(1);
        assertEquals("Start hour should be updated to 1",1, treatment.getStartHour());
    }
    //Creating global objects to be used in the methods below
    private Treatment treatment1;
    private Treatment treatment2;
    private Scheduler scheduler;


    /**
     * This method sets up the initial state for the test by creating instances of Coyote and Fox, creating instances of Treatment for each
     * animal, and initializing the scheduler with treatment1. This method is annotated with @Before, which means that it will be executed
     * before each test method.
     */
    @Before
    public void setUp() {
        Coyote coyote = new Coyote("oscar", 1);
        Fox fox = new Fox("adam", 2);
        treatment1 = new Treatment(coyote, new Task(2, "Rebandage leg wound", 20, 1), 10, 1);
        treatment2 = new Treatment(fox, new Task(9, "Eyedrops", 35 , 1), 11, 2);
        scheduler = new Scheduler(treatment1);
    }
    /**
     * Tests the addition of a new treatment object to the scheduler's list of treatments.
     */
    @Test
    public void testAddTreatment() {
        scheduler.addTreatment(treatment2);
        ArrayList<Treatment> treatments = scheduler.getTreatments();
        assertEquals("The treatment.size() did not return the correct value",2, treatments.size());
        assertTrue("The list of treatments should contain the previously added treatment1",treatments.contains(treatment1));
        assertTrue("The list of treatments should contain the newly added treatment2",treatments.contains(treatment2));
    }
   
    /**
     * Tests the functionality of the organize() method in the schedulers class. This method adds a new treatment (treatment2) to the scheduler,
     *  calls the organize() method and then checks if the treatments are properly organized.
     * @throws UnavoidableOverlapException if there is an unavoidable overlap between two treatments
     */
    @Test
    public void testOrganize() throws UnavoidableOverlapException {
        scheduler.addTreatment(treatment2);
        scheduler.organize();
        ArrayList<Treatment> treatments  = scheduler.getTreatments();
        assertEquals( "Expected the treatments ArrayList to have size 2, but instead it had size <actual size>",2, treatments.size());
        assertEquals("Expected the first treatment to be <expected treatment>, but instead it was <actual treatment>",treatment1, treatments.get(0));
        assertEquals("Expected the second treatment to be <expected treatment>, but instead it was <actual treatment>",treatment2, treatments.get(1));
    }
   
    // @Test(expected = UnavoidableOverlapException.class)
    // public void testOrganizeWithOverlap() throws UnavoidableOverlapException {
    //     Beaver beaver = new Beaver("john", 3);
    //     Treatment treatment3 = new Treatment(beaver, new Task(9, "Eyedrops", 35, 1), 11, 3);
    //     scheduler.addTreatment(treatment2);
    //     scheduler.addTreatment(treatment3);
    //     scheduler.organize();
    // }
   
}













