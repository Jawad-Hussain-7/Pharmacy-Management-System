/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author umer
 */
public class Login {
    
  private String UserName;
    private String PassWord;

    public Login() {
        UserName = "oop";
        PassWord = "oop";
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setPassWord(String PassWord) {
        this.PassWord = PassWord;
    }

    public boolean checkLogin(String User, String Pass) {
        if (User.equals(UserName)) {
            if (Pass.equals(PassWord)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}