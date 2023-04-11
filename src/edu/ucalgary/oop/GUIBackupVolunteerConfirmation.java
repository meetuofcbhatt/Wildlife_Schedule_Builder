package edu.ucalgary.oop;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GUIBackupVolunteerConfirmation extends JFrame implements ActionListener{

    private JLabel warning;
    private JButton confirm;
    private JPanel instrucPanel;
    private JPanel confirmPanel;

    public GUIBackupVolunteerConfirmation(Hour givenHour){
        super("Please confirm the backup volunteer availability");
        System.out.println(givenHour.gethourStr());
        setupGUI(givenHour);
        setSize(600, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setupGUI(Hour givenHour){
        
        warning = new JLabel("At " + givenHour.gethourStr() + " a backup volunteer is needed, please confirm their availability");
        confirm = new JButton("Confirm");
        confirm.addActionListener(this);

        instrucPanel = new JPanel();
        instrucPanel.add(warning);

        confirmPanel = new JPanel();
        confirmPanel.add(confirm);

        this.add(instrucPanel, BorderLayout.NORTH);
        this.add(confirmPanel, BorderLayout.CENTER);

    }

    public void actionPerformed(ActionEvent e){
        this.dispose();
    }

    public static void main(String[] args){
        new GUIBackupVolunteerConfirmation(new Hour(2)).setVisible(true);
    }

}
