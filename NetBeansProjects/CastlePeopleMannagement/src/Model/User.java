/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author filipe
 */
public class User {
    private ConecaoDB conecao;

    public User() throws ClassNotFoundException, SQLException{
        this.conecao = new ConecaoDB("jdbc:mysql://localhost:3306/CPM", "21101995");
    }

    public void adicionaUtilizador(String username,String password) throws SQLException{
        this.conecao.insertQuery("Insert into users values(null,'" + username + "','" + password + "'");
    }
    
    public void removeUtilizador(String username) throws SQLException{
        this.conecao.insertQuery("DELETE FROM users where username='" + username + "'");
    }
    
    public HashMap listUsers() throws SQLException{
        HashMap userList = new HashMap();
        ResultSet resultado = this.conecao.searchInfo("Select * from users order by id_utilizador");
        while(resultado.next()){
            int id = resultado.getInt("id_utilizador");
            String username = resultado.getString("username");
            userList.put(id, username);
        }
        return userList;
    }
    
    public boolean modifyPassword(String newPassword,String newPassword2,String oldPassword,int id) throws Exception{
        boolean result = false;
        if(!newPassword.equals(newPassword2)){
            throw new Exception("Error: Diferent Passwords");
        }else{
            this.conecao.insertQuery("UPDATE users SET password='" + newPassword + "'");
            result = true;
        }
        return result;
    }
    
    public ConecaoDB getConecao() {
        return conecao;
    }

    public void setConecao(ConecaoDB conecao) {
        this.conecao = conecao;
    }
}
