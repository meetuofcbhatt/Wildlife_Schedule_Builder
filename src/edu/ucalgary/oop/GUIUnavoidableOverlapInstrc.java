package edu.ucalgary.oop;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.sql.rowset.spi.TransactionalWriter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUIUnavoidableOverlapInstrc extends JFrame implements ActionListener{

    private JLabel instruction;
    private JComboBox<String> cb;
    private JButton confirm; 
    private JPanel instrucPanel;
    private JPanel selectionPanel;
    private JPanel confirmPanel;
    private ArrayList<Treatment> possibleTreatments;
    private String[] choices;

    public GUIUnavoidableOverlapInstrc(ArrayList<Treatment> givenTreatements){
        super("Please select one of the following tasks to modify");
        this.possibleTreatments = givenTreatements;
        setupUOIGUI(givenTreatements);
        setSize(500, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setupUOIGUI(ArrayList<Treatment> givenTreatments){

        instruction = new JLabel("Please select one of the following activities to shift: ");
        
        // ArrayList<Task> taskArray = new ArrayList<Task>();
        // taskArray.add(new Task(1, "this is task1",2, 3));
        // taskArray.add(new Task(1, "this is task2",2, 3));
        // taskArray.add(new Task(1, "this is task3",2, 3));

        String[] choices = {givenTreatments.get(0).getAnimalTask().getDescription(), givenTreatments.get(1).getAnimalTask().getDescription(), givenTreatments.get(2).getAnimalTask().getDescription()};
        
        cb = new JComboBox<String>(choices);
        cb.addActionListener(this);


        confirm = new JButton("Confirm");
        confirm.addActionListener(this);

        instrucPanel = new JPanel();
        instrucPanel.add(instruction);

        selectionPanel = new JPanel();
        selectionPanel.add(cb);

        confirmPanel = new JPanel();
        confirmPanel.add(confirm);

        this.add(instrucPanel, BorderLayout.NORTH);
        this.add(selectionPanel, BorderLayout.CENTER);
        this.add(confirmPanel, BorderLayout.PAGE_END);

    }

    public void actionPerformed(ActionEvent e){
        Object src = e.getSource();

        if(src == confirm){
            System.out.println(cb.getSelectedIndex());
            System.out.println(this.possibleTreatments.get(cb.getSelectedIndex()).getAnimalTask().getDescription());
            new GUIUnavoidableOverlap(this.possibleTreatments.get(cb.getSelectedIndex())).setVisible(true);       // need to get the right index somehow
        }



    }


    public static void main(String[] args){

        ArrayList<Treatment> testArr= new ArrayList<Treatment>();

        testArr.add(new Treatment(new Beaver("steve", 12), new Task(1, "example task 1", 2, 4), 3,12));
        testArr.add(new Treatment(new Beaver("guy", 123), new Task(1, "example task 2", 2, 4), 3,123));
        testArr.add(new Treatment(new Beaver("guy2", 1234), new Task(1, "example task 3", 3, 6), 2,1234));

        new GUIUnavoidableOverlapInstrc(testArr).setVisible(true);


    }
    

}
