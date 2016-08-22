/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Customer;
import javax.swing.JPanel;

/**
 *
 * @author filipe
 */
public class CustomerControler {
    private Customer customer;
    private JPanel customerUI;

    public CustomerControler(Customer customer, JPanel customerUI) {
        this.customer = customer;
        this.customerUI = customerUI;
    }
    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public JPanel getCustomerUI() {
        return customerUI;
    }

    public void setCustomerUI(JPanel customerUI) {
        this.customerUI = customerUI;
    }
    
    
    
}
