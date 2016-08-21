/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.User;
import javax.swing.JPanel;

/**
 *
 * @author filipe
 */
public class UserControler {
    private User user;
    private JPanel userUI;
    
    public UserControler(User user, JPanel userUI){
        this.user = user;
        this.userUI = userUI;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public JPanel getUserUI() {
        return userUI;
    }

    public void setUserUI(JPanel userUI) {
        this.userUI = userUI;
    }
    
}
