package edu.ucalgary.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.sql.*;


public class GUIEWR extends JFrame implements ActionListener{

    private JLabel instructions;

    public GUIEWR(){
        super("Generate a Schedule");
        setupGUI();
        setSize(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public void setupGUI(){
        instructions = new JLabel("Please click the button in order to generate tomorrow's schedule");
        JButton generateSchedule = new JButton("Generate");
        generateSchedule.addActionListener(this);

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());

        headerPanel.add(instructions);
        submitPanel.add(generateSchedule);
        
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(submitPanel, BorderLayout.PAGE_END);

    }

    public void actionPerformed(ActionEvent event){

        //make animal list
        ArrayList<Coyote> allCoy = new ArrayList<>();
        ArrayList<Fox> allFox = new ArrayList<>();
        ArrayList<Porcupine> allPor = new ArrayList<>();
        ArrayList<Beaver> allBea = new ArrayList<>();
        ArrayList<Raccoon> allRac = new ArrayList<>();

        ArrayList<Treatment> allTreatment = new ArrayList<>();
        
        // do the SQL connection here
        try {
			// Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/EWR","oop","password");
            Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EWR","oop","password");
            
            PreparedStatement stmtAnimals = con.prepareStatement("SELECT * FROM ANIMALS");
			ResultSet animals = stmtAnimals.executeQuery();
            
            PreparedStatement stmtTreatments = con.prepareStatement("SELECT * FROM TREATMENTS");
            ResultSet treatments = stmtTreatments.executeQuery();
           
            

            //create all the 

            // Create all the animals from the SQL
			while (animals.next()) {
                if (animals.getString("AnimalSpecies").equals("coyote")) {
                    allCoy.add(new Coyote(animals.getString("AnimalNickname"), animals.getInt("AnimalID")));
                }
                if (animals.getString("AnimalSpecies").equals("beaver")) {
                    allBea.add(new Beaver(animals.getString("AnimalNickname"), animals.getInt("AnimalID")));
                }
                if (animals.getString("AnimalSpecies").equals("fox")) {
                    allFox.add(new Fox(animals.getString("AnimalNickname"), animals.getInt("AnimalID")));
                }
                if (animals.getString("AnimalSpecies").equals("porcupine")) {
                    allPor.add(new Porcupine(animals.getString("AnimalNickname"), animals.getInt("AnimalID")));
                }
                if (animals.getString("AnimalSpecies").equals("raccoon")) {
                    allRac.add(new Raccoon(animals.getString("AnimalNickname"), animals.getInt("AnimalID")));
                }
				System.out.println(animals.getString("AnimalID") + ", " + animals.getString("AnimalNickname") + ", " + animals.getString("AnimalSpecies"));
			}
            // Create new Treatments out of all the animals, and put them into an Arraylist
            // Currently wrong, not creating thing correctly
            // Plan: get treatments.getInt("TaskID"), Query to get the tasks
            while (treatments.next()) 
            {
                String taskToFind = "SELECT * FROM TASKS WHERE TaskID = " + treatments.getString("TaskID");
                PreparedStatement stmtSpecificTasks = con.prepareStatement(taskToFind);
                ResultSet specificTask = stmtSpecificTasks.executeQuery(taskToFind);
                // System.out.println(treatments.getString("AnimalID") + ", " + treatments.getString("StartHour") + ", " + treatments.getString("TaskID"));
                while (specificTask.next()) 
                {
                    // System.out.println(specificTask.getString("TaskID") + ", " + specificTask.getString("Description") + 
                    // ", " + specificTask.getString("Duration") + ", " + specificTask.getString("MaxWindow"));
                    for (Coyote coyoteAnimal: allCoy) {
                        if (coyoteAnimal.getAnimalID() == treatments.getInt("AnimalID")) 
                        {
                            allTreatment.add(new Treatment(coyoteAnimal, new Task(specificTask.getInt("TaskID"), 
                                specificTask.getString("Description"), specificTask.getInt("Duration"), 
                                specificTask.getInt("MaxWindow")), 
                                treatments.getInt("StartHour"), treatments.getInt("AnimalID")));
                        }
                    }
                    for (Beaver beaverAnimal: allBea) {
                        if (beaverAnimal.getAnimalID() == treatments.getInt("AnimalID")) {
                            allTreatment.add(new Treatment(beaverAnimal, new Task(specificTask.getInt("TaskID"), 
                                specificTask.getString("Description"), specificTask.getInt("Duration"), 
                                specificTask.getInt("MaxWindow")), 
                                treatments.getInt("StartHour"), treatments.getInt("AnimalID")));
                        }
                    }
                    for (Fox foxAnimal: allFox) {
                        if (foxAnimal.getAnimalID() == treatments.getInt("AnimalID")) {
                            allTreatment.add(new Treatment(foxAnimal, new Task(specificTask.getInt("TaskID"), 
                                specificTask.getString("Description"), specificTask.getInt("Duration"), 
                                specificTask.getInt("MaxWindow")), 
                                treatments.getInt("StartHour"), treatments.getInt("AnimalID")));
                        }
                    }
                    for (Porcupine porcupineAnimal: allPor) {
                        if (porcupineAnimal.getAnimalID() == treatments.getInt("AnimalID")) {
                            allTreatment.add(new Treatment(porcupineAnimal, new Task(specificTask.getInt("TaskID"), 
                                specificTask.getString("Description"), specificTask.getInt("Duration"), 
                                specificTask.getInt("MaxWindow")), 
                                treatments.getInt("StartHour"), treatments.getInt("AnimalID")));
                        }
                    }
                    for (Raccoon raccoonAnimal: allRac) 
                    {
                        if (raccoonAnimal.getAnimalID() == treatments.getInt("AnimalID")) {
                            allTreatment.add(new Treatment(raccoonAnimal, new Task(specificTask.getInt("TaskID"), 
                                specificTask.getString("Description"), specificTask.getInt("Duration"), 
                                specificTask.getInt("MaxWindow")), 
                                treatments.getInt("StartHour"), treatments.getInt("AnimalID")));
                        }
                    }
                }
            }

			con.close();
		} catch (SQLException e) {
			System.out.println("error happened");
			e.printStackTrace();
		}


        Scheduler testscheduler = new Scheduler(allTreatment, allCoy, allFox, allPor, allBea, allRac);

        System.out.println("unordered");

        for(int i = 0; i < testscheduler.getTreatments().size(); i++){
            System.out.println(testscheduler.getTreatments().get(i).getAnimalTask().getMaxWindow());
        }

        System.out.println("Hours: ");
        

        try{
            testscheduler.organize();           // this can throw the unavoidable error exception
        }
        catch(UnavoidableOverlapException e){
            Hour brokenHour = testscheduler.getBrokenHour();
            new GUIUnavoidableOverlapInstrc(brokenHour).setVisible(true);          // change to brokenHour when done
            System.out.println("This is an unavoidable overlap in Hour: " + Integer.toString(brokenHour.getHour()));
        }


        this.dispose();


    }




}
