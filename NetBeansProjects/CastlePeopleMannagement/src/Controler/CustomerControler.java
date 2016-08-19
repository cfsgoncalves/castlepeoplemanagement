/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Customer;
import Viewer.CustomerUI;

/**
 *
 * @author filipe
 */
public class CustomerControler {
    private Customer customer;
    private CustomerUI customerUI;

    public CustomerControler(Customer customer, CustomerUI customerUI) {
        this.customer = customer;
        this.customerUI = customerUI;
    }
    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CustomerUI getCustomerUI() {
        return customerUI;
    }

    public void setCustomerUI(CustomerUI customerUI) {
        this.customerUI = customerUI;
    }
    
    
    
}
