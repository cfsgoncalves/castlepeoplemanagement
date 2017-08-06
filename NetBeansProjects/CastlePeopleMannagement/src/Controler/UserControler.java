/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.User;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author filipe
 */
public class UserControler {
    private JPanel userUI;
    private List<User> listOfUsers;
    
    public UserControler(User user, JPanel userUI){
        this.listOfUsers = new ArrayList<User>();
        this.userUI = userUI;
    }

    public List<User> getUserList(){
        return this.listOfUsers;
    }
    
    public void setUserList(List<User> userList){
        this.listOfUsers = userList;
    }

    public JPanel getUserUI() {
        return userUI;
    }

    public void setUserUI(JPanel userUI) {
        this.userUI = userUI;
    }
    
}
