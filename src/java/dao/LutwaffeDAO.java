/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dawm
 */
public class LutwaffeDAO {
    private Connection conexion;
    
    public void conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/Luftwaffe_Inventorien_Kontrol";
        String user = "root";
        String pass = "";
        conexion = DriverManager.getConnection(url, user, pass);
    }
    
    public void desconectar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }
    
}
