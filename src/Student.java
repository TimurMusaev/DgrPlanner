/**
 * Student function
 *This function records a students first and last name, Anumber, major and minor, and all course information,
 * all information sent from main, also has funciton to find classes completed and number of credits earned
 *
 * @param firstName hold students first name
 * @param lastName holds students last name
 * @param aNumber holds students Anumber
 * @param major holds students major
 * @param minor holds students minor
 * @param courseNum holds all course numbers for courses
 * @param courseName holds all course names for courses
 * @param credits holds all credits available for courses
 * @param completion holds all completion statuses for courses
 * @param grade holds all grades for courses
 * @param preReq holds all pre-requisites for courses
 * @param count used to go through arrays
 */
public class Student
{
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String aNumber;
    private String major;
    private String minor;
    private String userTitle;
    String[] courseNum=new String[21];
    String[] courseName=new String[21];
    int[] credits=new int[21];
    String[] completion=new String[21];
    int[] grade=new int[21];
    String[] preReq=new String[21];
    int count=0;

    /**
     * constructor function
     * used to set students basic information
     * @param firstName sets the students first name
     * @param lastName sets the students last name
     * @param aNumber sets the students Anumber
     * @param major sets the students major
     * @param minor sets the students minor
     */
    public Student( String username, String password, String firstName, String lastName, String aNumber, String major, String minor, String title)
    {
        this.username=username;
        this.password=password;
        this.firstName=firstName;
        this.lastName=lastName;
        this.aNumber=aNumber;
        this.major=major;
        this.minor=minor;
        this.userTitle=title;
    }

    /**
     * constructor function
     * allocates all student information
     */
    public Student()
    {
        firstName="";
        lastName="";
        aNumber="";
        major="";
        minor="";
        for(int counter=0; counter<4; counter++)
        {
            courseNum[counter]="";
            courseName[counter]="";
            credits[counter]=-1;
            completion[counter]="";
            grade[counter]=-1;
            preReq[counter]="";

        }
    }

    /**
     * setClassInfo function
     * This function set the students course information passed from the main, when
     * the function finishes the count will increase allowing for the next part of the array to be filled
     * when it is call from the main again.
     * @param courseNum sets the course number
     * @param courseName sets the course name
     * @param credits sets the course credits
     * @param completion sets the completion statues for the course
     * @param grade sets the grade for the course
     * @param preReq sets the pre-requisite for the course
     */
    public void setClassInfo(String courseNum, String courseName, int credits, String completion, int grade, String preReq)
    {
        this.courseNum[count]=courseNum;
        this.courseName[count]=courseName;
        this.credits[count]=credits;
        this.completion[count]=completion;
        this.grade[count]=grade;
        this.preReq[count]=preReq;
        count++;
    }

    /**
     * getFirstName function
     * returns the first name of student
     * @return returns firstname variable
     *
     */

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public String getTitle()
    {
        return userTitle;
    }

    public String getFirstName()
    {
        return firstName;
    }

    /**
     * getLastName function
     * returns the last name of student
     * @return returns lastName variable
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * getaNumber function
     * returns the Anumber of student
     * @return returns aNumber variable
     */
    public String getaNumber()
    {
        return aNumber;
    }

    /**
     * getMajor function
     * returns the major of student
     * @return returns major variable
     */
    public String getMajor()
    {
        return major;
    }

    /**
     * getMinor function
     * returns the minor of student
     * @return returns minor variable
     */
    public String getMinor()
    {
        return minor;

    }

    /**
     * getCourseNum function
     * returns the courseNum array for courses
     * @return returns courseNum variable
     */
    public String[] getCourseNum()
    {
        return courseNum;
    }

    /**
     * getCourseName function
     * returns the courseName array for courses
     * @return returns courseName variable
     */
    public String[] getCourseName()
    {
        return courseName;
    }

    /**
     * getCredits function
     * returns the credits array for courses
     * @return returns credits variable
     */
    public int[] getCredits()
    {
        return credits;
    }

    /**
     * getCompletion variable
     * returns the completion array for courses
     * @return returns completion variable
     */
    public String[] getCompletion()
    {
        return completion;
    }

    /**
     * getGrade function
     * returns grade array for courses
     * @return returns grade variable
     */
    public int[] getGrade()
    {
        return grade;
    }

    /**
     * getPreReq function
     * returns preReq array for courses
     * @return returns preReq variable
     */
    public String[] getPreReq()
    {
        return preReq;
    }

    /**
     * getCompletedCredits function
     * function checks the completed courses and adds all the credits up
     * @param totalCredits sum of all credits for completed courses
     * @return returns totalCredits variable
     */
    public double getCompletedCredits()
    {
        int totalCredits=0;
        for(int counter=0; counter<count; counter++)
        {
            if(completion[counter]=="Complete")
                totalCredits+=credits[counter];
        }
        return totalCredits;
    }

    /**
     * getCompletedClasses function
     * finds courses that are completed and returns them
     * @param completed array that holds the course names of completed courses
     * @param numCompleted holds number of completed courses
     * @param x counter used for traversing completed array
     * @param objectList
     * @param i
     * @param searchString
     * @return  returns completed variable
     */

    public String[] getCompletedClasses()
    {
        String[] completed;
        int numCompleted=0;
        int x=0;

        for(int counter=0;counter<count;counter++)
        {
            if(completion[counter].equals("Complete"))
                numCompleted++;
        }
        completed=new String[numCompleted];

        for(int counter=0;counter<count;counter++)
        {

            if (completion[counter].equals("Complete"))
            {
                completed[x]=courseName[counter];
                x++;
            }
        }
        return completed;
    }
    public String[] getInCompletedClasses()
    {
        String[] Incomplete;
        int numInCompleted=0;
        int x=0;
        for(int counter=0;counter<count;counter++)
        {
            if(completion[counter].equals("Incomplete"))
                numInCompleted++;
        }
        Incomplete=new String[numInCompleted+1];

        for(int counter=0;counter<count;counter++)
        {

            if (completion[counter].equals("Incomplete"))
            {
                Incomplete[x]=courseName[counter];
                x++;
            }
        }
        return Incomplete;
    }

    public int getCompletedClassesNum()
    {
        int numCompleted=0;

        for(int counter=0;counter<count;counter++)
        {
            if(completion[counter].equals("Complete"))
                numCompleted++;
        }
        return numCompleted;
    }
    public int getInCompletedClassesNum()
    {
        int numInCompleted=0;

        for(int counter=0;counter<count;counter++)
        {
            if(completion[counter].equals("Incomplete"))
                numInCompleted++;
        }
        return numInCompleted;
    }

    public void makeCourseComplete(String grade2, String CmpltCrsName)
    {
        for(int i=0;i<21;i++)
        {
            if(courseName[i].equals(CmpltCrsName))
            {
                completion[i]="Complete";
                grade[i]=Integer.parseInt(grade2);
            }

        }
    }


}
