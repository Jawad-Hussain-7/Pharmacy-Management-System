/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagementsystem;

/**
 *
 * @author Jawad Hussain
 */
public class UserValidationException extends Exception{
    
    public UserValidationException()
    {
        
    }
    
    public UserValidationException(String message)
    {
        super(message);
    }
}
