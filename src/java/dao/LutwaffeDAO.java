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
import java.util.ArrayList;
import obj.Kontrol;
import obj.Nave;
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
    public void insertKontrol(Kontrol k) throws SQLException {
        this.conectar();
        String query = "INSERT INTO Luftwaffe_Inventorien_Kontrol.kontrol (username,password,rank) VALUES (?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setString(1, k.getUsername());
        ps.setString(2, k.getPassword());
        ps.setString(3, k.getRank());

        ps.executeUpdate();
        ps.close();
        this.desconectar();
    }
    
    public void insertNave(Nave n) throws SQLException {
        this.conectar();
        String query = "INSERT INTO Luftwaffe_Inventorien_Kontrol.nave (fabricante,modelo,tipo) VALUES (?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(query);

        ps.setString(1, n.getFabricante());
        ps.setString(2, n.getModelo());
        ps.setString(3, n.getTipo());

        ps.executeUpdate();
        ps.close();
        this.desconectar();
    }

    //Check If Exists
    //--------------------------------------------------------------------------
    public boolean existeKontrol(Kontrol k) throws SQLException {
        this.conectar();
        String query = "SELECT * FROM Luftwaffe_Inventorien_Kontrol.Personal WHERE nombre='" + k.getUsername()+ "'";
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
    
    public boolean existeNave(Nave n) throws SQLException {
        this.conectar();
        String query = "SELECT * FROM Luftwaffe_Inventorien_Kontrol.nave WHERE modelo='" + n.getModelo()+ "'";
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
    //Pers By Name (Login)
    //--------------------------------------------------------------------------
    public Personal getPersonalByName(String name) throws SQLException{
            this.conectar();
        String query = "SELECT * FROM Luftwaffe_Inventorien_Kontrol.Personal WHERE nombre='" + name + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        Personal p = new Personal();
        if(rs.next()){
            p.getNombre();
            p.getApellido();
            p.getRank();
            p.getEspecialidad();
        }
        rs.close();
        st.close();
        this.desconectar();
        return p;
    }
    public Kontrol getKontrolByUsername(String name) throws SQLException{
            this.conectar();
        String query = "SELECT * FROM Luftwaffe_Inventorien_Kontrol.kontrol WHERE username='" + name + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        Kontrol k = new Kontrol();
        if(rs.next()){
            k.getUsername();
            k.getPassword();
            k.getRank();
        }
        rs.close();
        st.close();
        this.desconectar();
        return k;
    }
    public boolean validaKontrol(String username, String password) throws SQLException {
        this.conectar();
        String query = "SELECT * FROM Luftwaffe_Inventorien_Kontrol.kontrol WHERE username=? AND password = ?";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        boolean is = false;
        if (rs.next()) {
            is = true;
        }
        rs.close();
        ps.close();
        this.desconectar();
        return is;
    }
    public ArrayList<Personal> getAllPersonal() throws SQLException{
        Statement st = conexion.createStatement();
        ArrayList<Personal> TodoPersonal = new ArrayList<>();
        String select = "SELECT * FROM Luftwaffe_Inventorien_Kontrol.Personal";
        ResultSet rs = st.executeQuery(select);
        
        while(rs.next()){
            Personal p = new Personal();
            p.setNombre(rs.getString("nombre"));
            p.setApellido(rs.getString("apellido"));
            p.setEspecialidad(rs.getString("especialidad"));
            p.setRank(rs.getString("rank"));
            
            TodoPersonal.add(p);
        }
        st.close();
        return TodoPersonal;
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