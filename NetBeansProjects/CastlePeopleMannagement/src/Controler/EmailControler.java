/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Email;
import javax.swing.JPanel;

/**
 *
 * @author filipe
 */
public class EmailControler {
    private Email email;
    private JPanel jpanel;
    
    public EmailControler(Email email, JPanel jpanel){
        this.email = email;
        this.jpanel = jpanel;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public JPanel getJpanel() {
        return jpanel;
    }

    public void setJpanel(JPanel jpanel) {
        this.jpanel = jpanel;
    }
    
}
