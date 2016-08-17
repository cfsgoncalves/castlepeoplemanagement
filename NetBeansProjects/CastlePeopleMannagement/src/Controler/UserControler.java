/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.User;
import Viewer.UserUI;

/**
 *
 * @author filipe
 */
public class UserControler {
    private User user;
    private UserUI userUI;
    
    public UserControler(User user, UserUI userUI){
        this.user = user;
        this.userUI = userUI;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserUI getUserUI() {
        return userUI;
    }

    public void setUserUI(UserUI userUI) {
        this.userUI = userUI;
    }    
}
