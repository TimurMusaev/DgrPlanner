import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

/**
 * main function
 * The main function takes the User.txt file and copies its contents into multiple variables to be
 * passed into the other classes which will then be used in the GUI.
 * @author Ian Castillo
 * @version 1.0
 * @since 11/25/21
 */
public class Main {

    /**
     * the main function reads through file and copies contents to multiple variables then passes to
     * other classes
     *
     * @param args unused
     * @param url used to find the User.txt file
     * @param users holds file information
     * @param numUsers number of user information in the file
     * @param username holds username for login, provided by the file
     * @param password holds password for login, provided by the file
     * @param userTitle holds title of user, used to determine users allowed functions
     * @param firstName holds first name of user, provided by the file
     * @param lastName holds last name of user, provided by the file
     * @param aNumber hold a number of user, provided by the file
     * @param major holds major of user, provided by the file
     * @param minor holds minor of user, provided by the file
     * @param courseNum holds course number for courses, provided by the file
     * @param courseName holds course name for courses, provided by the file
     * @param credits holds credits for courses, provided by the file
     * @param completion holds completion statues for courses, provided by thefile
     * @param grade holds grades for courses, provided by the file
     * @param preReq holds the pre-requisites course number for courses, provided by the file
     * @param token used to hold information from file then pass to necessary variable
     * @param user class function for student class to pass information from file
     * @param scan to scan information onto token variable
     * @param login used to scan input from user for logging in
     * @param use hold username entered by user
     * @param pass holds password entered by user
     * @param counter used while going through while loop and to end it
     * @param line used to go through each line of text in file
     * @param temp used to get ";" for the admin user
     */
    public static void main(String[] args) throws FileNotFoundException {
        File users = new File("User.txt");
        int numUsers=4;
        String[] username=new String[numUsers];
        String[] password=new String[numUsers];
        String[] userTitle=new String[numUsers];
        String firstName;
        String lastName;
        String aNumber;
        String major;
        String minor;
        String courseNum;
        String courseName;
        int credits;
        String completion;
        int grade = 0;
        String preReq;
        String[] token;
        Student[] user = new Student[numUsers];
        Scanner scan= new Scanner(users);
        Scanner login=new Scanner(System.in);
        String use;
        String pass;
        int counter=0;
        String line;
        String temp;


        for (int count=0;count<numUsers;count++)//used to allocate each part in array
            user[count]=new Student();

        while (!(line= String.valueOf(scan.hasNextLine())).equals(null))//while loop start by getting users info
        {
            username[counter] = scan.nextLine();
            password[counter] = scan.nextLine();

            token = scan.nextLine().split(",");
            firstName = token[token.length - 1];

            token = scan.nextLine().split(",");
            lastName = token[token.length - 1];

            token = scan.nextLine().split(",");
            aNumber = token[token.length - 1];

            token = scan.nextLine().split(",");
            major = token[token.length - 1];

            token = scan.nextLine().split(",");
            minor = token[token.length - 1];

            userTitle[counter] = scan.nextLine();
            temp=userTitle[counter];

            if (userTitle[counter].equals("Admin"))//checks if user is an Admin else they are a student
            {
                user[counter] = new Admin(username[counter], password[counter], firstName, lastName, aNumber, major, minor,userTitle[counter]);
                token = scan.nextLine().split(",");
                temp=token[token.length-1];
                counter++;
            }
            else
            {
                user[counter] = new Student(username[counter], password[counter], firstName, lastName, aNumber, major, minor,userTitle[counter]);
                while (!(line.equals(";"))) //records course infomation for the student;
                {
                    token = scan.nextLine().split(",");
                    courseNum = token[token.length - 1];

                    if(courseNum.equals(";"))
                    {
                        break;
                    }

                    token = scan.nextLine().split(",");
                    courseName = token[token.length - 1];

                    token = scan.nextLine().split(",");
                    credits = Integer.valueOf(token[token.length - 1]);

                    token = scan.nextLine().split(",");
                    completion = token[token.length - 1];

                    try {
                        token = scan.nextLine().split(",");
                        grade = Integer.valueOf(token[token.length - 1]);
                    } catch (NumberFormatException e)
                    {
                        grade=-1;
                    }

                    token = scan.nextLine().split(",");
                    preReq = token[token.length - 1];
                    user[counter].setClassInfo(courseNum, courseName, credits, completion, grade, preReq);
                }

                counter++;
                if(counter==numUsers)
                    break;
            }
        }

        LogInGUI l = new LogInGUI(user,counter);
        l.setVisible(true);
    }
}
