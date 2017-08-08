/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Viewer.LoginUI;

/**
 *
 * @author filipe
 */
public class LoginControler {
    private LoginUI loginUI;
    private UserControler userControler;
    
    public LoginControler(UserControler userControler,LoginUI login){
        this.loginUI =login;
        this.loginUI.setUserControler(userControler);
        this.userControler = userControler;
    }
    
    /*
     * Permite validar o utilizador
     */
    
    public LoginUI getLoginUI() {
        return loginUI;
    }

    public void setLoginUI(LoginUI loginUI) {
        this.loginUI = loginUI;
    }
    
}
