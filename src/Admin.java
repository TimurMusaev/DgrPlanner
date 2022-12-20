
/**
 * Admin class
 * class for user classified as admin who have control over students information
 * creates last name plus Anumber variable and has search function to find student based
 * on Anumber
 */
public class Admin extends Student
{
    /**
     * constructor function
     * allocates admins information
     * @param firstName sets admins first name
     * @param lastName sets admins last name
     * @param aNumber sets admins Anumber
     * @param major sets admins major
     * @param minor sets admins minor
     */
    public Admin( String userName, String password, String firstName, String lastName, String aNumber,String major, String minor,String title)
    {
        super( userName, password, firstName, lastName, aNumber, major, minor, title);
    }

    /**
     * getLastNameANumber function
     * creates new array id by combining the students last name and their Anumber
     * @param user variable to access each users information from student class
     * @param numUsers variable to set boundary in for loop
     * @param lastNameANumber array that holds last name and Anumber
     * @return returns lastNameANumber variable
     */

    public Student search(Student[] user, int numUsers, String aNum)
    {
        for(int counter=0;counter<numUsers; counter++) {

            if (user[counter].getaNumber().equals(aNum))
                return user[counter];
        }
        return null;
    }
    public int searchNum(Student[] user, int numUsers, String aNum)
    {
        for(int counter=0;counter<numUsers; counter++) {

            if (user[counter].getaNumber().equals(aNum))
                return counter;
        }
        return -1;
    }
}