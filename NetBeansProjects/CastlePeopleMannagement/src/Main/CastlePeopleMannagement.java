/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controler.LoginControler;
import Controler.UserControler;
import Model.EncryptPassword;
import Model.User;
import Viewer.LoginUI;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author filipe
 */
public class CastlePeopleMannagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            
            User admin = new User("admin",EncryptPassword.cryptWithMD5("admin"));
            UserControler userControler = new UserControler();
            userControler.addUser(admin);
            LoginControler login = new LoginControler(userControler,new LoginUI(userControler));
            login.getLoginUI().setVisible(true);
        }catch (Exception ex) {
            System.out.println("Error initializing the system");
        }
    }
}
