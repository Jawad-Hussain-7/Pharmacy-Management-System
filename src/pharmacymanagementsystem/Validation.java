/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagementsystem;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jawad Hussain
 */
public class Validation {
    
    public boolean validateNewUser(String username, String password, String type)
    {
        try
        {
            Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
            Matcher matcher = pattern.matcher(username);
            if(username.length()<3)
            {
                throw new UserValidationException("Username must contain 3 characters");
            }
            if(!matcher.matches())
            {
                throw new UserValidationException("Username cannot contain special characters");
            }
            if(password.length()<3)
            {
                throw new UserValidationException("Password must contain 3 characters");
            }
            if(containsUser(new User(username, password, type)))
            {
                throw new UserValidationException("This username already exists");
            }
            DatabaseManager dbm=new DatabaseManager();
            dbm.insertUser(new User(username, password, type));
            return true;
        }
        catch(UserValidationException u)
        {
            System.out.println(u.getMessage());
        }
        return false;
    }
    
    public boolean validateNewMedicine(String name, int price, String company, int quantity, String type, String description)
    {
        try
        {
            Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
            Matcher matcher = pattern.matcher(name);
            if(!matcher.matches())
            {
                throw new UserValidationException("Medicine name cannot contain special characters");
            }
            matcher=pattern.matcher(company);
            if(!matcher.matches())
            {
                throw new UserValidationException("Company name cannot contain special characters");
            }
            DatabaseManager dbm=new DatabaseManager();
            dbm.insertMedicine(new Medicine(name, price, company, quantity, type, description));
            return true;
        }
        catch(UserValidationException u)
        {
            System.out.println(u.getMessage());
        }
        return false;
    }
    
    public boolean validateUser(String username, String password)
    {
        try
        {
            if(containsUser(new User(username, password)))
            {
                return true;
            }
            else
            {
                throw new UserValidationException("The username you have entered does not exist");
            }
        }
        catch(UserValidationException u)
        {
            System.out.println(u.getMessage());
        }
        return false;
    }
    public boolean containsUser(User user)
    {
        DatabaseManager dbm=new DatabaseManager();
        ArrayList <User> users=dbm.getAllUsers();
        for(User u : users)
        {
            if(u.getName().equals(user.getName()))
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean containsMedicine(Medicine medicine)
    {
        DatabaseManager dbm=new DatabaseManager();
        ArrayList <Medicine> medicines=dbm.getAllMedicines();
        for(Medicine m : medicines)
        {
            if(m.getName().equals(medicine.getName()))
            {
                return true;
            }
        }
        return false;
    }
}
