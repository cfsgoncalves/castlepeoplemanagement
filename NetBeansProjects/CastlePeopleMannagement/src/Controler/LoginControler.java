/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.User;
import Viewer.LoginUI;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author filipe
 */
public class LoginControler {
    private User user;
    private LoginUI loginUI;
    
    public LoginControler(User user,LoginUI login){
        this.loginUI =login;
        this.user = user;
    }
    
    /*
     * Permite validar o utilizador
     */
    public void validarUtilizador(String user, char[] password) throws SQLException, Exception{
        String pass = "";
        for(char letra : password){
            pass = pass + letra;
        }
        ResultSet result = this.user.getConecao().searchInfo("Select id_utilizador from users "
                + "where username='" + user + "' and password='" + pass + "'");
        if(!result.next()){
            throw new Exception("Password e/ou username errados");
        } 
    }
    

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LoginUI getLoginUI() {
        return loginUI;
    }

    public void setLoginUI(LoginUI loginUI) {
        this.loginUI = loginUI;
    }
    
}
