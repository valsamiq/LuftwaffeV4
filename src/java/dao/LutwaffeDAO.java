/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import obj.Personal;

/**
 *
 * @author dawm
 */
public class LutwaffeDAO {

    //Inserts
    //--------------------------------------------------------------------------
    public void insertPersonal(Personal p) throws SQLException {
        this.conectar();
        String query = "INSERT INTO Luftwaffe_Inventorien_Kontrol.Personal (nombre,apellido,rank,especialidad) VALUES (?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(query);

        ps.setString(1, p.getNombre());
        ps.setString(2, p.getApellido());
        ps.setString(3, p.getRank());
        ps.setString(4, p.getEspecialidad());

        ps.executeUpdate();
        ps.close();
        this.desconectar();
    }

    //Check If Exists
    //--------------------------------------------------------------------------
    public boolean existePersonal(Personal p) throws SQLException {
        this.conectar();
        String query = "SELECT * FROM Luftwaffe_Inventorien_Kontrol.Personal WHERE nombre='" + p.getNombre() + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        if (rs.next()){
            return true;
        }
        rs.close();
        st.close();
        this.desconectar();
        return false;
    }
    //Connection
    //--------------------------------------------------------------------------
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