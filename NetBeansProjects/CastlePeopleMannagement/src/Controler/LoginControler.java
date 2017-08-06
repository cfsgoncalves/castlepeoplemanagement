/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.User;
import Viewer.LoginUI;
import java.sql.SQLException;

/**
 *
 * @author filipe
 */
public class LoginControler {
    private LoginUI loginUI;
    private UserControler userControler;
    
    public LoginControler(UserControler userControler,LoginUI login){
        this.loginUI =login;
        this.userControler = userControler;
    }
    
    /*
     * Permite validar o utilizador
     */
    public boolean validarUtilizador(String user, char[] password) throws Exception{
        String pass = "";
        for(char letra : password){
            pass = pass + letra;
        }
        for(int i=0;i<userControler.getUserList().size();i++){
            if(userControler.getUserList().get(i).getUserName().equals(user) && 
                    userControler.getUserList().get(i).getPassword().equals(pass)){
                return true;
            }
        }
        throw new Exception("Wrong login/User not found!");
    }
    
    public LoginUI getLoginUI() {
        return loginUI;
    }

    public void setLoginUI(LoginUI loginUI) {
        this.loginUI = loginUI;
    }
    
}
