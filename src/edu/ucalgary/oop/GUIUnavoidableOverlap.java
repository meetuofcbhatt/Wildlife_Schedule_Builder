package edu.ucalgary.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import java.util.concurrent.Semaphore;


public class GUIUnavoidableOverlap extends JFrame implements ActionListener, MouseListener{
    
    private JLabel instructions;
    private JPanel headerPanel;
    private JPanel submitPanel;
    private JLabel error;
    private JLabel durationInstr;
    private JLabel starttimeInstr;
    private JLabel deletedNotif;
    private JTextField starttimeInput;
    private JPanel reschedulePanel;
    private JPanel deletePanel;
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private JComboBox<String> cb; 
    private JLabel deleteAlert;
    private JButton deleteConfirm;
    private JButton rescheduleConfirm;


    
    public GUIUnavoidableOverlap(Treatment givenTreatment){
        super("Error: Unavoidable Overlap");
        setupUOGUI(givenTreatment);
        setSize(1250, 150);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setupUOGUI(Treatment givenTreatment){
        
        // setting up the header and main instruction panel
        instructions = new JLabel("The given schedule from the database makes it impossible to implement.");
        
        headerPanel = new JPanel();
        headerPanel.setLayout(new CardLayout());
        headerPanel.add(instructions);

        submitPanel = new JPanel();
        submitPanel.setLayout(new CardLayout());

        Semaphore semaphore = new Semaphore(0);

        // TODO: get the task with the error in it here, instead of this test one -- givenTreatment
        // Treatment trialTreatment = new Treatment(new Coyote("Jeff", 12), new Task(3, "example task", 3, 5), 3, 5);
        Treatment trialTreatment = givenTreatment;



        error = new JLabel("The error is with task: \"" + trialTreatment.getAnimalTask().getDescription() + "\"" + ", here are some of the possible changes to make to fix it:");

        submitPanel.add(error);

        // making the reschedule panel
        reschedulePanel = new JPanel();
        starttimeInstr = new JLabel("Start time: ");
        starttimeInput = new JTextField("e.g. 6", 15);
        rescheduleConfirm = new JButton("Confirm");
        rescheduleConfirm.addActionListener(this);

        starttimeInput.addMouseListener(this);


        // reschedulePanel.add(error);
        // reschedulePanel.add(cb);
        reschedulePanel.add(starttimeInstr);
        reschedulePanel.add(starttimeInput);
        reschedulePanel.add(rescheduleConfirm);

        // making the delete panel

        deletePanel = new JPanel();
        deletedNotif = new JLabel("The error causing task has been deleted.");
        deleteConfirm = new JButton("Confirm");
        deleteAlert = new JLabel("Are you sure you want to delete the task?");
        deletePanel.add(deleteAlert);
        deletePanel.add(deleteConfirm);

        deleteConfirm.addActionListener(this);

        // probably give the following notification after a successful delete
        // deletePanel.add(deletedNotif);
        
        // making the main panel with CardLayout
        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);
        mainPanel.add(reschedulePanel, "Reschedule Task");
        mainPanel.add(deletePanel, "Delete Task");

        // the dropdown menu

        JPanel menu = new JPanel();
        
        String[] choices = {"Reschedule Task", "Delete Task"};

        cb = new JComboBox<String>(choices);
        cb.addActionListener(this);

        menu.add(instructions);
        menu.add(error);
        menu.add(cb);
        // menu.setLayout(new SpringLayout());

        setLayout(new BorderLayout());

        this.add(menu, BorderLayout.NORTH);
        this.add(mainPanel, BorderLayout.CENTER);
        // this.add(reschedulePanel,BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e){
        cardLayout.show(mainPanel, (String)cb.getSelectedItem());
        
        if(((String)cb.getSelectedItem()).equals("Reschedule Task")){
            Object src = e.getSource();
            if(src == rescheduleConfirm){
                System.out.println("reschedule task");
                // the user input after they select confirm
                String givenstartHour = starttimeInput.getText();

                if(givenstartHour.matches("^-?[0-9]+$")){
                    System.out.println(givenstartHour);
                    // we will need to check if the hour is in between 0 and 24 later
                }
                else{
                    JOptionPane.showMessageDialog(this, givenstartHour + " is an invalid start hour, try again");
                }
    
    
                // TODO: put the code for modifying the duration and start hour here
            }


        }
        if(((String)cb.getSelectedItem()).equals("Delete Task")){
            Object src = e.getSource();

            if(src == deleteConfirm){
                // TODO: put the code for deleting the task from the data base here
                System.out.println("Delete button working");
            }
        }

        new GUIEWR().setVisible(true);

        this.dispose();


    }

    public void mouseClicked(MouseEvent event){
        if(event.getSource().equals(starttimeInput)){
            starttimeInput.setText("");
        }
    }

    public void mouseEntered(MouseEvent event){
        
    }

    public void mouseExited(MouseEvent event){
        
    }

    public void mousePressed(MouseEvent event){
        
    }

    public void mouseReleased(MouseEvent event){
        
    }
 

    public static void main(String[] args){
        // this main was made for the exclusive purpose of testing the GUI
        new GUIUnavoidableOverlap(new Treatment(new Coyote("cool guy", 123), new Task(1, "example task 2", 3, 5), 4, 123)).setVisible(true);
    }

}
