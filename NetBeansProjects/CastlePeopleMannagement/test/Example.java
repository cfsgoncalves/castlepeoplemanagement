
import Model.ConecaoDB;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author filipe
 */
import java.sql.ResultSet;
import java.sql.SQLException;

 
public class Example {

    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        try {
            //colocar aqui o nome que esta em services
            ConecaoDB a = new ConecaoDB("jdbc:mysql://localhost:3306/CPM", "21101995");
            ResultSet result = a.searchInfo("SELECT * FROM users");
            while(result.next()){
                int print = result.getInt("id_utilizador");
                String print2 = result.getString("username");
                System.out.println(print);
                System.out.println(print2);
            }
            a.closeConnection();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
          }

    }
}