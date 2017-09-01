/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.User;
import Viewer.LoginUI;
import Viewer.MainMenuUI;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author filipe
 */
public class UserControler {
    private List<User> listOfUsers;
    
    public UserControler(){
        this.listOfUsers = new ArrayList<User>();
    }
    
    public void addUser(User e){
        this.listOfUsers.add(e);
    }

    public List<User> getUserList(){
        return this.listOfUsers;
    }
    
    public void setUserList(List<User> userList){
        this.listOfUsers = userList;
    }
    
    public void validarUtilizador(String user, char[] password,LoginUI loginUI) throws Exception{
        String pass = "";
        boolean found = false;
        for(char letra : password){
            pass = pass + letra;
        }
        for(int i=0;i<getUserList().size();i++){
            if(getUserList().get(i).getUserName().equals(user) && 
                    getUserList().get(i).getPassword().equals(pass)){
               loginUI.setVisible(false);
               User userP = new User(user,"");
               new MainMenuUI(userP).setVisible(true);
               found = true;
            }
        }
        if(!found){
            throw new Exception("Wrong login/User not found!");
        }
    }
}
