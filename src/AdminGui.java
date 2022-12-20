/**
 * Graphical Interface is in here.
 * That's where the boundaries and functionality
 * of interface are being set
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdminGui extends JFrame implements ActionListener {
    //definition of interface elements
    JEditorPane InfoList, InCompleteList, StudentList;
    JButton searchBtn, addBtn;
    JLabel CourseNumLbl, gradeLbl;
    JTextPane CourseNumTxt, gradeTxt, SearchTxt;
    JScrollPane tablePane;
    JScrollPane tablePane2;
    JScrollPane tablePane3;
    JPanel jPanel;
    Student[] objectList;
    int count;
    //Book b = new Book();

    AdminGui(Student[] u,int counter) {
        //describing the interface
        super("Admin");
        this.setSize(1200, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        objectList=u;
        count=counter;
        jPanel = new JPanel();
        jPanel.setLayout(null);
        jPanel.setBackground(Color.decode("#1b6ea1"));
        setResizable(false);



        //creating the place for user input
        SearchTxt = new JTextPane();
        SearchTxt.setBounds(10, 10, 400, 20);
        SearchTxt.setCaretColor(Color.decode("#600485"));
        SearchTxt.setBackground(Color.decode("#e68e0b"));
        SearchTxt.setForeground(Color.decode("#1b6ea1"));
        jPanel.add(SearchTxt);

        //creating the place for user input
        CourseNumTxt = new JTextPane();
        CourseNumTxt.setBounds(610, 410, 300, 20);
        CourseNumTxt.setCaretColor(Color.decode("#600485"));
        CourseNumTxt.setBackground(Color.decode("#e68e0b"));
        CourseNumTxt.setForeground(Color.decode("#1b6ea1"));
        jPanel.add(CourseNumTxt);

        //creating the place for user input
        gradeTxt = new JTextPane();
        gradeTxt.setBounds(610, 450, 300, 20);
        gradeTxt.setCaretColor(Color.decode("#600485"));
        gradeTxt.setBackground(Color.decode("#e68e0b"));
        gradeTxt.setForeground(Color.decode("#1b6ea1"));
        jPanel.add(gradeTxt);

        CourseNumLbl = new JLabel("Course Num to add to completed:");
        CourseNumLbl.setBounds(610, 390, 275, 20);
        CourseNumLbl.setForeground(Color.decode("#FFFFFF"));
        jPanel.add(CourseNumLbl);

        gradeLbl = new JLabel("Grade:");
        gradeLbl.setBounds(610, 430, 275, 20);
        gradeLbl.setForeground(Color.decode("#FFFFFF"));
        jPanel.add(gradeLbl);


        InfoList = new JEditorPane();
        InfoList.setEditable(false);
        InfoList.setBackground(Color.decode("#e68e0b"));
        InfoList.setForeground(Color.decode("#FFFFFF"));

        InCompleteList = new JEditorPane();
        InCompleteList.setEditable(false);
        InCompleteList.setBackground(Color.decode("#e68e0b"));
        InCompleteList.setForeground(Color.decode("#FFFFFF"));


        StudentList = new JEditorPane();
        StudentList.setEditable(false);
        StudentList.setBackground(Color.decode("#e68e0b"));
        StudentList.setForeground(Color.decode("#FFFFFF"));

        for(int i=0;i<4;i++)
        {
            StudentList.setText(StudentList.getText() + u[i].getaNumber() + "\n\n");
        }

        //creating output window
        tablePane = new JScrollPane(InfoList, tablePane.VERTICAL_SCROLLBAR_ALWAYS, tablePane.HORIZONTAL_SCROLLBAR_NEVER);
        tablePane.setBounds(10, 50, 550, 300);
        tablePane.getViewport().setBackground(Color.decode("#e68e0b"));
        jPanel.add(tablePane);

        tablePane2 = new JScrollPane(InCompleteList, tablePane2.VERTICAL_SCROLLBAR_ALWAYS, tablePane2.HORIZONTAL_SCROLLBAR_NEVER);
        tablePane2.setBounds(10, 390, 550, 300);
        tablePane2.getViewport().setBackground(Color.decode("#e68e0b"));
        jPanel.add(tablePane2);

        tablePane3 = new JScrollPane(StudentList, tablePane3.VERTICAL_SCROLLBAR_ALWAYS, tablePane3.HORIZONTAL_SCROLLBAR_NEVER);
        tablePane3.setBounds(610, 50, 550, 300);
        tablePane3.getViewport().setBackground(Color.decode("#e68e0b"));
        jPanel.add(tablePane3);

        //setting up buttons
        searchBtn = new JButton("Search by ANumber");
        searchBtn.setBounds(410, 10, 200, 20);
        searchBtn.setBackground(Color.decode("#e68e0b"));
        searchBtn.setForeground(Color.decode("#FFFFFF"));
        searchBtn.addActionListener(this);
        jPanel.add(searchBtn);

        addBtn = new JButton("Add Course");
        addBtn.setBounds(610, 490, 175, 20);
        addBtn.setBackground(Color.decode("#e68e0b"));
        addBtn.setForeground(Color.decode("#FFFFFF"));
        addBtn.addActionListener(this);
        jPanel.add(addBtn);



        this.add(jPanel);
    }

    //That's where interface meets the class code.
    @Override
    public void actionPerformed(ActionEvent e) {
        //assigning actions to different input options
        switch (e.getActionCommand()) {

            case "Search by ANumber":
                if (!SearchTxt.getText().equals("")) {
                    InfoList.setText("");
                    InCompleteList.setText("");
                    Admin l= new Admin(objectList[count].getUsername(),objectList[count].getPassword(),objectList[count].getFirstName(),objectList[count].getLastName(),objectList[count].getaNumber()
                    , objectList[count].getMajor(),objectList[count].getMinor(),objectList[count].getTitle());
                    String searchString= SearchTxt.getText();
                    Student search1 = l.search(objectList,4,searchString);
                    int searchIndex=l.searchNum(objectList,4,searchString);
                    InfoList.setText("Name: "+search1.getFirstName()+"\n\nLast Name: "+search1.getLastName()+"\n\nA Number: "+search1.getaNumber()+"\n\nMajor:"+search1.getMajor()+"\n\nMinor: "+search1.getMinor());
                    for(int i=0;i<objectList[searchIndex].getInCompletedClassesNum();i++)
                    {
                        InCompleteList.setText(InCompleteList.getText() + objectList[searchIndex].getInCompletedClasses()[i] + "\n\n");
                    }
                }
                break;

            case"Add Course":
                if(!CourseNumTxt.getText().equals("")&&!gradeTxt.getText().equals("")&&!SearchTxt.getText().equals("")) {

                    Admin l= new Admin(objectList[count].getUsername(),objectList[count].getPassword(),objectList[count].getFirstName(),objectList[count].getLastName(),objectList[count].getaNumber()
                            , objectList[count].getMajor(),objectList[count].getMinor(),objectList[count].getTitle());
                    String searchString= SearchTxt.getText();
                    int searchIndex=l.searchNum(objectList,4,searchString);
                    InCompleteList.setText("");
                    objectList[searchIndex].makeCourseComplete(gradeTxt.getText(),CourseNumTxt.getText());
                    for(int i=0;i<objectList[searchIndex].getInCompletedClassesNum();i++)
                    {
                        InCompleteList.setText(InCompleteList.getText() + objectList[searchIndex].getInCompletedClasses()[i] + "\n\n");
                    }

                }

                break;
        }
    }}