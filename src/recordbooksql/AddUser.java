/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recordbooksql;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import recordbooksql.User;

/**
 *
 * @author gaffs
 */
public class AddUser {

    private User user;

    public User getUser() {
        return user;
    }
    
    public void setUser(User user){
        this.user = user;
    }

    public void addUsers() {
        try { 
                // Connection connection = DriverManager.getConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            //Statement statement = connection.createStatement();
            System.out.println("Please, enter the full name of user");
            user.setAllName(reader.readLine());

            System.out.println("Please, enter the telephone number of user");
            user.setTelephoneNumber(reader.readLine());

            System.out.println("Please, enter the email of user");
            user.setEmail(reader.readLine());

            System.out.println("Please, enter the Skype name's of user");
            user.setSkypeName(reader.readLine());
        } catch (IOException ex) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }
    }
}


