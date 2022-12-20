/**
 * Graphical Interface is in here.
 * That's where the boundaries and functionality
 * of interface are being set
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LogInGUI extends JFrame implements ActionListener {
    //definition of interface elements

    JLabel LogInLbl, PasswordLbl;
    JTextPane LogInTxt,PasswordTxt;
    JButton LogInBtn;
    JPanel jPanel;
    Student[] user;
    int Size;

    LogInGUI(Student[] S,int NumOfUsers) {

        //describing the interface
        super("LogIn");
        this.setSize(1200, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Size=NumOfUsers;
        user=S;
        jPanel = new JPanel();
        jPanel.setLayout(null);
        jPanel.setBackground(Color.decode("#1b6ea1"));
        setResizable(false);

        //creating the place for user input
        LogInTxt = new JTextPane();
        LogInTxt.setBounds(500, 360, 200, 20);
        LogInTxt.setCaretColor(Color.decode("#600485"));
        LogInTxt.setBackground(Color.decode("#e68e0b"));
        LogInTxt.setForeground(Color.decode("#1b6ea1"));
        jPanel.add(LogInTxt);

        //creating the place for user input
        PasswordTxt = new JTextPane();
        PasswordTxt.setBounds(500, 400, 200, 20);
        PasswordTxt.setCaretColor(Color.decode("#600485"));
        PasswordTxt.setBackground(Color.decode("#e68e0b"));
        PasswordTxt.setForeground(Color.decode("#1b6ea1"));
        jPanel.add(PasswordTxt);

        LogInLbl = new JLabel("Username:");
        LogInLbl.setBounds(500, 340, 275, 20);
        LogInLbl.setForeground(Color.decode("#FFFFFF"));
        jPanel.add(LogInLbl);

        PasswordLbl = new JLabel("Password:");
        PasswordLbl.setBounds(500, 380, 275, 20);
        PasswordLbl.setForeground(Color.decode("#FFFFFF"));
        jPanel.add(PasswordLbl);


        //setting up buttons
        LogInBtn = new JButton("Log In");
        LogInBtn.setBounds(550, 440, 100, 20);
        LogInBtn.setBackground(Color.decode("#e68e0b"));
        LogInBtn.setForeground(Color.decode("#FFFFFF"));
        LogInBtn.addActionListener(this);
        jPanel.add(LogInBtn);


        this.add(jPanel);
    }

    //That's where interface meets the class code.
    @Override
    public void actionPerformed(ActionEvent e) {
        //assigning actions to different input options
        switch (e.getActionCommand()) {

            case "Log In":
            {

                if(!LogInTxt.getText().equals("") && !PasswordTxt.getText().equals(""))
                {

                    LogInCheck(LogInTxt.getText(), PasswordTxt.getText());
                }
            }
                break;

        }
    }

    public void LogInCheck(String use,String pass)
    {
        for(int i=0;i<Size;i++)
        {

            if (use.equals(user[i].getUsername()) && pass.equals(user[i].getPassword()) && user[i].getTitle().equals("UnderGraduate"))
            {
                StudentGui l1 = new StudentGui(user,i);
                l1.setVisible(true);
                setVisible(false);
            }
            else if(use.equals(user[i].getUsername()) && pass.equals(user[i].getPassword()) && user[i].getTitle().equals("Admin"))
            {
                AdminGui l2 = new AdminGui(user,i);
                l2.setVisible(true);
                setVisible(false);
            }
        }
    }
}