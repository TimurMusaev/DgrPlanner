/**
 * Graphical Interface is in here.
 * That's where the boundaries and functionality
 * of interface are being set
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StudentGui extends JFrame implements ActionListener {
    //definition of interface elements
    JEditorPane CompleteList, InCompleteList, InfoList;
    JLabel TakenLbl, NonTakenLbl, InfoLbl;
    JScrollPane tablePane;
    JScrollPane tablePane2;
    JScrollPane tablePane3;
    JPanel jPanel;


    StudentGui(Student[] u, int counter) {
        //describing the interface
        super("Student");
        this.setSize(1200, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jPanel = new JPanel();
        jPanel.setLayout(null);
        jPanel.setBackground(Color.decode("#1b6ea1"));
        setResizable(false);

        TakenLbl = new JLabel("Complete:");
        TakenLbl.setBounds(610, 30, 275, 20);
        TakenLbl.setForeground(Color.decode("#FFFFFF"));
        jPanel.add(TakenLbl);

        NonTakenLbl = new JLabel("Incomplete:");
        NonTakenLbl.setBounds(610, 370, 275, 20);
        NonTakenLbl.setForeground(Color.decode("#FFFFFF"));
        jPanel.add(NonTakenLbl);

        InfoLbl = new JLabel("Info:");
        InfoLbl.setBounds(10, 180, 275, 20);
        InfoLbl.setForeground(Color.decode("#FFFFFF"));
        jPanel.add(InfoLbl);


        CompleteList = new JEditorPane();
        CompleteList.setEditable(false);
        CompleteList.setBackground(Color.decode("#e68e0b"));
        CompleteList.setForeground(Color.decode("#FFFFFF"));
        CompleteList.setText("");
        for(int i=0;i<u[counter].getCompletedClassesNum();i++)
        {
            CompleteList.setText(CompleteList.getText() + u[counter].getCompletedClasses()[i] + "\n\n");
        }

        InCompleteList = new JEditorPane();
        InCompleteList.setEditable(false);
        InCompleteList.setBackground(Color.decode("#e68e0b"));
        InCompleteList.setForeground(Color.decode("#FFFFFF"));
        InCompleteList.setText("");
        for(int i=0;i<u[counter].getInCompletedClassesNum();i++)
        {
            InCompleteList.setText(InCompleteList.getText() + u[counter].getInCompletedClasses()[i] + "\n\n");
        }

        InfoList = new JEditorPane();
        InfoList.setEditable(false);
        InfoList.setBackground(Color.decode("#e68e0b"));
        InfoList.setForeground(Color.decode("#FFFFFF"));
        InfoList.setText("");
        InfoList.setText("Name: "+u[counter].getFirstName()+"\n\nLast Name: "+u[counter].getLastName()+"\n\nA Number: "+u[counter].getaNumber()+"\n\nMajor:"+u[counter].getMajor()+"\n\nMinor: "+u[counter].getMinor());

        //creating output window
        tablePane = new JScrollPane(InfoList, tablePane.VERTICAL_SCROLLBAR_ALWAYS, tablePane.HORIZONTAL_SCROLLBAR_NEVER);
        tablePane.setBounds(10, 200, 550, 300);
        tablePane.getViewport().setBackground(Color.decode("#e68e0b"));
        jPanel.add(tablePane);

        tablePane2 = new JScrollPane(InCompleteList, tablePane2.VERTICAL_SCROLLBAR_ALWAYS, tablePane2.HORIZONTAL_SCROLLBAR_NEVER);
        tablePane2.setBounds(610, 390, 550, 300);
        tablePane2.getViewport().setBackground(Color.decode("#e68e0b"));
        jPanel.add(tablePane2);

        tablePane3 = new JScrollPane(CompleteList, tablePane3.VERTICAL_SCROLLBAR_ALWAYS, tablePane3.HORIZONTAL_SCROLLBAR_NEVER);
        tablePane3.setBounds(610, 50, 550, 300);
        tablePane3.getViewport().setBackground(Color.decode("#e68e0b"));
        jPanel.add(tablePane3);

        this.add(jPanel);
    }

    //That's where interface meets the class code.
    @Override
    public void actionPerformed(ActionEvent e) {
        //assigning actions to different input options
        switch (e.getActionCommand())
        {
        }
    }}