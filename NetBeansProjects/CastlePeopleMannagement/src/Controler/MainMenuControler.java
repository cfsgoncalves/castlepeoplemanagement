/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.User;
import Viewer.MainMenuUI;

/**
 *
 * @author filipe
 */
public class MainMenuControler {
    private User user;
    private MainMenuUI main;
    
    public MainMenuControler(MainMenuUI main,User user){
        this.user = user;
        this.main = main;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MainMenuUI getMain() {
        return main;
    }

    public void setMain(MainMenuUI main) {
        this.main = main;
    }
    
}
