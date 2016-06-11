/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recordbooksql;

//import com.mysql.jdbc.Connection;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

//import com.mysql.jdbc.Driver;
/**
 *
 * @author gaffs
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/recordBooks?useSSL=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static final String SELECT = "SELECT * FROM recordBooks.users";

    // private String allName;
    //private String telephoneNumber;
    //private String email;
    // private String skypeName;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, IOException {

        //AddUser addUser = new AddUser();
        //.addUsers();
        //System.out.println(addUser);
        Class.forName(com.mysql.jdbc.Driver.class.getName());

        //String url = "jdbc:mysql://localhost:3306/";
        //String hostname = "127.0.0.1";
        //int hostport = 3306;
        //String database = "recordBooks";
        //String username = "user1";
        //String password = "user12345";
        //String connectionString = String.format("jdbc:mysql://%s:%d/%s?useSSL=true", hostname, hostport, database);
        System.out.println("Please, choose your action:");
        System.out.println("  input 'show' - add new user;");
        System.out.println("  input 'add' - change the current user's info by id;");
        System.out.println("  input 'update' - show user's info;");
        // System.out.println("  write 'search' - search user by id");
        System.out.println("  input 'delete' - delete user by id");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String action = reader.readLine();

        switch (action) {
            case "show":
                try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

                    Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery(SELECT);

                    System.out.println("-------------------------------------------------------------------");
                    System.out.printf("%-3s%-15s%-20s%-20s%-15s%n", "ID", "Name",
                            "Telephone number", "Email", "Skype");
                    System.out.println("-------------------------------------------------------------------");
                    while (rs.next()) {
                        System.out.printf("%-3s%-15s%-20s%-20s%-15s%n", rs.getString("id"),
                                rs.getString("allName"), rs.getString("telephoneNumber"), rs.getString("email"),
                                rs.getString("skypeName"));

                    }
                    System.out.println("-------------------------------------------------------------------");

                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case "add":
                try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

                    Statement statement = connection.createStatement();
                    String allName, telephoneNumber, email, skypeName;
                    System.out.println("Please, input the full name of user");
                    allName = reader.readLine();
                    System.out.println("Please, input the telephone number of user");
                    telephoneNumber = reader.readLine();
                    System.out.println("Please, input the email of user");
                    email = reader.readLine();
                    System.out.println("Please, input the Skype name's of user");
                    skypeName = reader.readLine();
                    statement.execute("INSERT INTO recordBooks.users (allName, telephoneNumber, email, skypeName) "
                            + "VALUES ('" + allName + "', '" + telephoneNumber + "', '" + email + "', '" + skypeName + "')");
                    //statement.executeBatch();
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case "update":
                try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

                    Statement statement = connection.createStatement();

                    System.out.println("Please, input the user's ID in order to update");
                    String idUpdateString = reader.readLine();
                    int idUpdateInt = Integer.parseInt(idUpdateString);
                    System.out.println(idUpdateInt);
                    //System.out.println("");
                    //reader.readLine();
                    String allName, telephoneNumber, email, skypeName;
                    System.out.println("Please, input the new user's information");
                    System.out.println("Please, input the full name of user");
                    //reader.readLine();
                    allName = reader.readLine();
                    System.out.println("Please, input the telephone number of user");
                    telephoneNumber = reader.readLine();
                    System.out.println("Please, input the email of user");
                    email = reader.readLine();
                    System.out.println("Please, input the Skype name's of user");
                    skypeName = reader.readLine();
                    statement.executeUpdate("UPDATE recordBooks.users SET allName = '"
                            + allName + "', telephoneNumber = '" + telephoneNumber + "', email = '"
                            + email + "', skypeName = '" + skypeName + "' WHERE id = " + idUpdateInt + "; ");

                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case "delete":
                try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

                    Statement statement = connection.createStatement();
                    System.out.println("Please, input the user's ID in order to delete");
                    String idDeleteString = reader.readLine();
                    int idDeleteInt = Integer.parseInt(idDeleteString);
                    statement.executeUpdate("DELETE FROM recordBooks.users WHERE id = " + idDeleteInt + ";");

                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

        }

    }

}
