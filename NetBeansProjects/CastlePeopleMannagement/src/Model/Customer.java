/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author filipe
 */
public class Customer {
    private ConecaoDB conecao;
    private int age;
    private String gender;
    
    public Customer() throws ClassNotFoundException, SQLException{
        this.conecao = new ConecaoDB("jdbc:mysql://localhost:3306/CPM", "21101995");
    }
    
    public Customer(int age, String gender){
        this.age = age;
        this.gender = gender;
    }
    
    public void addCustomer(String gender, String age) throws SQLException{
        this.conecao.insertQuery("INSERT INTO customers VALUES(null,'" + gender + "','" + age+"'");
    }
    
    public void removeCustomer(int id) throws SQLException{
        this.conecao.insertQuery("DELETE FROM customers WHERE id_costumer='" + id +"'");
    }
    
    public ArrayList<Customer> listCustomers() throws SQLException {
        ArrayList<Customer> customerList = new ArrayList();
        ResultSet result = this.conecao.searchInfo("SELECT * FROM customers");
        while(result.next()){
           int age = result.getInt("age");
           String gender = result.getString("gender");
           customerList.add(new Customer(age,gender));
        }
        return customerList;
    }
    
}
