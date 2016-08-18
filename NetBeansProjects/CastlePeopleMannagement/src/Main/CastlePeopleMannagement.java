/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Viewer.LoginUI;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

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
            LoginUI loginUI = new LoginUI();
            loginUI.setResizable(false);
            loginUI.setVisible(true);
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro: base de dados");
        } catch (SQLException ex) {
            System.out.println("Erro: query");
        } catch (InstantiationException ex) {
            System.out.println("Erro: Nimbus not found");
        } catch (IllegalAccessException ex) {
            System.out.println("Erro: Nimbus not found");
        } catch (UnsupportedLookAndFeelException ex) {
            System.out.println("Erro: Nimbus not found");
        }
    }
    
}
