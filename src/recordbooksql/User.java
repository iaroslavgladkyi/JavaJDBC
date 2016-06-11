/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recordbooksql;

/**
 *
 * @author gaffs
 */
public class User {

    private String allName;
    private String telephoneNumber;
    private String email;
    private String skypeName;

    public User(String allName, String telephoneNumber, String email, String skypeName) {
        this.allName = allName;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.skypeName = skypeName;
    }
    
    public User(){
        
    }

    public String getAllName() {
        return allName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getSkypeName() {
        return skypeName;
    }

    public void setAllName(String allName) {
        this.allName = allName;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSkypeName(String skypeName) {
        this.skypeName = skypeName;
    }

}
