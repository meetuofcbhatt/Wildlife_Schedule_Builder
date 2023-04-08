package edu.ucalgary.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;


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

        // do the SQL connection here

        // JOptionPane.showMessageDialog(null, "this button works");
        Treatment treatment1 = new Treatment(new Beaver("hello", 2), new Task(1, "task1", 3, 5), 12, 2);
        Treatment treatment2 = new Treatment(new Beaver("hi", 2), new Task(1, "task2", 3, 3), 1, 2);
        Treatment treatment3 = new Treatment(new Beaver("bingus", 2), new Task(1, "task3", 3, 2), 5, 2);
        Treatment treatment4 = new Treatment(new Beaver("lastguy", 2), new Task(1, "task1", 3, 6), 3, 2);

        Scheduler testscheduler = new Scheduler(treatment1);
        testscheduler.addTreatment(treatment2);
        testscheduler.addTreatment(treatment3);
        testscheduler.addTreatment(treatment4);

        System.out.println("unordered");

        for(int i = 0; i < testscheduler.getTreatments().size(); i++){
            System.out.println(testscheduler.getTreatments().get(i).getAnimalTask().getMaxWindow());
        }

        System.out.println("Hours: ");
        try{
            testscheduler.organize();           // this should throw the unavoidable error exception
            // if you want to test the unavoidableoverlap exception just throw it here
        }
        catch(UnavoidableOverlapException e){
            new GUIUnavoidableOverlap().setVisible(true);
            
            System.out.println("This is an unavoidable overlap");
        }
        // put database exception

        System.out.println("ordered");

        for(int i = 0; i < testscheduler.getTreatments().size(); i++){
            System.out.println(testscheduler.getTreatments().get(i).getAnimalTask().getMaxWindow());
        }



        //count each animal type
        int coy = 0;
        int fo = 0;
        int por = 0;
        int bea = 0;
        int rac = 0;
        //make animal list
        ArrayList<Animal> allCoy = new ArrayList<Animal>();
        ArrayList<Animal> allFox = new ArrayList<Animal>();
        ArrayList<Animal> allPor = new ArrayList<Animal>();
        ArrayList<Animal> allBea = new ArrayList<Animal>();
        ArrayList<Animal> allRac = new ArrayList<Animal>();
       

        
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



    }


}
