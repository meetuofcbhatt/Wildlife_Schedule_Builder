package edu.ucalgary.oop;
import java.util.ArrayList;

import javax.swing.text.DefaultStyledDocument.ElementSpec;
public class printSchedule 
{
    private Scheduler schedule;

    public static void main(String []args)
    {
        //make treatment objects here.
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
        testscheduler.organize();

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



    }
}
