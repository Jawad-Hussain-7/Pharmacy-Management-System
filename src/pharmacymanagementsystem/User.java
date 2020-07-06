/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagementsystem;

import java.util.ArrayList;


public class User {
    private String name;
    private String password;
    private String type;
    
    public User()
    {
        name=" ";
        password=" ";
        type=" ";
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    
    public User(String name, String password, String type) {
        this.name = name;
        this.password = password;
        this.type=type;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", password=" + password + ", type=" + type + '}';
    }
    
    public void displayAllUsers(ArrayList <User> users)
    {
        for(User u : users)
        {
            System.out.println(u.toString());
        }
    }
}
