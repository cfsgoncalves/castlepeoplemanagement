/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.User;
import Viewer.LoginUI;
import Viewer.MainMenuUI;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author filipe
 */
public class UserControler implements Serializable{
    private static final long serialVersionUID = 1L;
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
               break;
            }
        }
        if(user.equals("admin") && pass.equals("admin") && listOfUsers.size() > 1){
            //After first user insertion
            listOfUsers.remove(new User("admin","admin"));
        }else if(user.equals("admin") && pass.equals("admin") && listOfUsers.size() < 1) {
            //Lock down situation
            listOfUsers.add(new User("admin","admin"));
            new MainMenuUI(new User("admin","")).setVisible(true);
            found = true;
        }
        if(!found){
            throw new Exception("Wrong login/User not found!");
        }
    }
}
