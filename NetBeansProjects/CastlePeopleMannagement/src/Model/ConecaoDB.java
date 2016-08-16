/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.*;

/**
 *
 * @author filipe
 */


public class ConecaoDB {
   private Connection connection;
   
    /**
     * Conecta á base de dados
     * @param url Url da Base de Dados
     * @param pass Passe da Base de Dados
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public ConecaoDB(String url, String pass) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url,"root", pass);
        System.out.println("Conected with sucess!");
    }

    /**
     * Do data abstraction
     * @return Return an object of the Connection class
     */
    public Connection getConecction(){
        return connection;
    }
    
    /**
     * Use to acess the database. Used when data is returned
     * @param query
     * @throws SQLException 
     */
    public void insertQuery(String query) throws SQLException{
       Statement connect = connection.createStatement();
       connect.executeUpdate(query);
       System.out.println("Sucess!");
    }

    /**
     * Use to acess the database. Used when doesn't return data
     * @param query
     * @return Return an object that the class name is ResultSet
     * @throws SQLException 
     */
    public ResultSet searchInfo(String query) throws SQLException{
       Statement call = connection.createStatement();
       ResultSet data = call.executeQuery(query);
       return data;
    }

    public void closeConnection() throws SQLException{
        connection.close();
    }
    
}