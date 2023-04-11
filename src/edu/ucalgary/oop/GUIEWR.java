package edu.ucalgary.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.sql.*;
import java.util.concurrent.locks.*;


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

        //count each animal type
        int coyCount = 0;
        int foxCount = 0;
        int porCount = 0;
        int beaCount = 0;
        int racCount = 0;
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
            
            Statement stmtAnimals = con.createStatement();
			ResultSet animals = stmtAnimals.executeQuery("SELECT * FROM ANIMALS");
            
            Statement stmtTreatments = con.createStatement();
            ResultSet treatments = stmtTreatments.executeQuery("SELECT * FROM TREATMENTS");
           
            Statement stmtSpecificTasks = con.createStatement();

            //create all the 

            // Create all the animals from the SQL
			while (animals.next()) {
                if (animals.getString("AnimalSpecies").equals("coyote")) {
                    allCoy.add(new Coyote(animals.getString("AnimalNickname"), animals.getInt("AnimalID")));
                    coyCount += 1;
                }
                if (animals.getString("AnimalSpecies").equals("beaver")) {
                    allBea.add(new Beaver(animals.getString("AnimalNickname"), animals.getInt("AnimalID")));
                    beaCount += 1;
                }
                if (animals.getString("AnimalSpecies").equals("fox")) {
                    allFox.add(new Fox(animals.getString("AnimalNickname"), animals.getInt("AnimalID")));
                    foxCount += 1;
                }
                if (animals.getString("AnimalSpecies").equals("porcupine")) {
                    allPor.add(new Porcupine(animals.getString("AnimalNickname"), animals.getInt("AnimalID")));
                    porCount += 1;
                }
                if (animals.getString("AnimalSpecies").equals("raccoon")) {
                    allRac.add(new Raccoon(animals.getString("AnimalNickname"), animals.getInt("AnimalID")));
                    racCount += 1;
                }
				System.out.println(animals.getString("AnimalID") + ", " + animals.getString("AnimalNickname") + ", " + animals.getString("AnimalSpecies"));
			}
            // Create new Treatments out of all the animals, and put them into an Arraylist
            // Currently wrong, not creating thing correctly
            // Plan: get treatments.getInt("TaskID"), Query to get the tasks
            while (treatments.next()) 
            {
                String taskToFind = "SELECT * FROM TASKS WHERE TaskID = " + treatments.getString("TaskID");
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

            // for (Treatment treatment: allTreatment) {
            //     System.out.println(treatment.getStartHourString());
            // }
            // for (Fox foxObj: allFox) {
            //     if (foxObj.getAnimalID() == 6) {
            //         if (foxObj.getFeedingTime() == null) {
            //             System.out.println("This is now null");
            //         }
            //     }
            // }
			con.close();
		} catch (SQLException e) {
			System.out.println("error happened");
			e.printStackTrace();
		}

        // JOptionPane.showMessageDialog(null, "this button works");
        // Treatment treatment1 = new Treatment(new Beaver("hello", 2), new Task(1, "task1", 3, 5), 12, 2);
        // Treatment treatment2 = new Treatment(new Beaver("hi", 2), new Task(1, "task2", 3, 3), 1, 2);
        // Treatment treatment3 = new Treatment(new Beaver("bingus", 2), new Task(1, "task3", 3, 2), 5, 2);
        // Treatment treatment4 = new Treatment(new Beaver("lastguy", 2), new Task(1, "task1", 3, 6), 3, 2);

        Scheduler testscheduler = new Scheduler(allTreatment, allCoy, allFox, allPor, allBea, allRac);
        // testscheduler.addTreatment(treatment2);
        // testscheduler.addTreatment(treatment3);
        // testscheduler.addTreatment(treatment4);

        System.out.println("unordered");

        for(int i = 0; i < testscheduler.getTreatments().size(); i++){
            System.out.println(testscheduler.getTreatments().get(i).getAnimalTask().getMaxWindow());
        }

        System.out.println("Hours: ");
        
        // call guiEWR at the end of the error loop.

        // while(true){
        //     try{
        //         testscheduler.organize();           // this should throw the unavoidable error exception
        //         // if you want to test the unavoidableoverlap exception just throw it here
        //         // throw new UnavoidableOverlapException();
        //         // cont = false;
        //         break;
        //     }
        //     catch(UnavoidableOverlapException e){
        //         Hour brokenHour = testscheduler.getBrokenHour();
    
        //         GUIUnavoidableOverlapInstrc gui = new GUIUnavoidableOverlapInstrc(brokenHour);          // change to brokenHour when done
        //         gui.setVisible(true);
        //         while(gui.isVisible()){
        //             try{
        //                 Thread.sleep(100);
        //             }
        //             catch(InterruptedException ex){
        //                 ex.printStackTrace();
        //             }
        //         }
        //         System.out.println("This is an unavoidable overlap in Hour: " + Integer.toString(brokenHour.getHour()));
        //         // break;
        //         continue;
        //     }
            
        // }

        try{
            testscheduler.organize();           // this should throw the unavoidable error exception
            // if you want to test the unavoidableoverlap exception just throw it here
            // throw new UnavoidableOverlapException();
        }
        catch(UnavoidableOverlapException e){
            Hour brokenHour = testscheduler.getBrokenHour();
            new GUIUnavoidableOverlapInstrc(brokenHour).setVisible(true);          // change to brokenHour when done
            System.out.println("This is an unavoidable overlap in Hour: " + Integer.toString(brokenHour.getHour()));
        }

        // put database exception

        // System.out.println("ordered");

        // for(int i = 0; i < testscheduler.getTreatments().size(); i++){
        //     System.out.println(testscheduler.getTreatments().get(i).getAnimalTask().getMaxWindow());
        // }

        // System.out.println("Test allTreatment Iteration");
        // for(int i = 0; i < allTreatment.size(); i++)
        // {
        //     System.out.println("i: " + Integer.toString(i) + "MaxWind: " + Integer.toString(allTreatment.get(i).getAnimalTask().getMaxWindow()));
        // }

       

        
        //rs is from the code that will get info from sql database.
        // while(rs.next())
        // {
        //     String[]AniSpec = {"coyote", "fox", "porcupine", "raccoon", "beaver"};
        //     if(AniSpec[0].equals(rs.getString("AnimalSpecies")))
        //     {
        //         //coyote
        //         //if this not an orphane object
        //         coy = coy + 1;
        //         allCoy.add(Coyote(rs.getString("AnimalNickname"), Integer.parseInt(rs.getString("AnimalID"))));
        //         //else 
        //         //coy = coy + count;
        //         //make appropriate amount of coyote obj and put them in allCoy
        //     }
        //     else if(AniSpec[1].equals(rs.getString("AnimalSpecies")))
        //     {
        //         //fox
        //         fo = fo + 1;
        //         allFox.add(Coyote(rs.getString("AnimalNickname"), Integer.parseInt(rs.getString("AnimalID"))));
        //     }
        //     else if(AniSpec[2].equals(rs.getString("AnimalSpecies")))
        //     {
        //         //porcupine
        //         por = por + 1;
        //         allPor.add(Coyote(rs.getString("AnimalNickname"), Integer.parseInt(rs.getString("AnimalID"))));
        //     }
        //     else if(AniSpec[3].equals(rs.getString("AnimalSpecies")))
        //     {
        //         //raccoon
        //         rac = rac + 1;
        //         allRac.add(Coyote(rs.getString("AnimalNickname"), Integer.parseInt(rs.getString("AnimalID"))));
        //     }
        //     else if(AniSpec[4].equals(rs.getString("AnimalSpecies")))
        //     {
        //         //beaver
        //         bea = bea + 1;
        //         allBea.add(Coyote(rs.getString("AnimalNickname"), Integer.parseInt(rs.getString("AnimalID"))));
        //     }
        //     else
        //     {
        //         //throw invalid animal type argument exception
        //     }
        // }

        // boolean error = false;
        // while(!error){
        //     try{
        //         new GUIEWR().setVisible(true);
        //         break;
        //     }
        //     catch(UnavoidableOverlapException e){                                         // this should be catch a custom exception for an unavoidable overlap
        //         System.out.println("Error GUI will be called here");
        //     }
        //     catch(DatabaseConnectionException e){
        //         System.out.println("Database connection error here");
        //         error = true;
        //     }
        // }
        // fetching from SQL database should be done here

        this.dispose();


    }




}
