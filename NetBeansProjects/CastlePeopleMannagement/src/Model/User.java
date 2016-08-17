/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.SQLException;

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
    
    public ConecaoDB getConecao() {
        return conecao;
    }

    public void setConecao(ConecaoDB conecao) {
        this.conecao = conecao;
    }
    
}
