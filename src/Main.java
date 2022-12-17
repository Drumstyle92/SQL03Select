import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Drumstyle92
 * Class that contains the entire code
 */
public class Main {
    /**
     *
     * @param args main parameter
     * Main method that contains a connection creation with a database,
     * creation of a query, printing of names and surnames of the database table.
     */
    public static void main(String[] args) {

        Connection conn = null;
        try{
            // create a connection to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb",
                                                         "root","Confusione1992");
            // Creation of the query
            Statement query = conn.createStatement();
            ResultSet studentsNameAndSurname = query.executeQuery("SELECT first_name, last_name " +
                    "FROM students;");
            // List of surnames
            List<String> listLastname = new ArrayList<>();
            // Name result
            while(studentsNameAndSurname.next()){
                System.out.println("Name: " + studentsNameAndSurname.getString("first_name"));
                listLastname.add(studentsNameAndSurname.getString("last_name"));
            }

            System.out.println("------------------------------------------------------------");
            System.out.println("Student surnames: " + listLastname);

        }catch (SQLException e){
            System.out.println(e.getMessage());

        }finally{

            try{

            if(conn != null) {
                conn.close();
            }
            
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }

    }
}
