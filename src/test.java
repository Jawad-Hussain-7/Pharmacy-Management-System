
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jawad Hussain
 */
public class test {
    
    public static void main(String [] args) {
    Validation v=new Validation();
    DatabaseManager dbm=new DatabaseManager();
    ArrayList <User> asd=dbm.getAllUsers();
        for(User u : asd)
        {
            System.out.println(u.toString());
        }
    }
}
