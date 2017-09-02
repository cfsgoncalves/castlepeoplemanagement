/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Customer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author filipe
 */
public class CustomerControler implements Serializable{
    private static final long serialVersionUID = 1L;
    private JPanel customerUI;
    private List<Customer> customerList; 

    public CustomerControler(JPanel customerUI) {
        this.customerList = new ArrayList<Customer>();
        this.customerUI = customerUI;
    }
    
    public void addCustomer(Customer customer){
        this.customerList.add(customer);
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
    
    public JPanel getCustomerUI() {
        return customerUI;
    }

    public void setCustomerUI(JPanel customerUI) {
        this.customerUI = customerUI;
    }
    
    
    
}
