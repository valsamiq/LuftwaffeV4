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
import java.util.List;
import obj.Kontrol;
import obj.Mision;
import obj.Nave;
import obj.Personal;
import obj.Tripulacion;

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
    public void insertMision(Mision m) throws SQLException {
        this.conectar();
        String query = "INSERT INTO Luftwaffe_Inventorien_Kontrol.Mision (nombre,clasificacion,tipo,zona,idNave) VALUES (?,?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(query);

        ps.setString(1, m.getNombre());
        ps.setInt(2, m.getClasificacion());
        ps.setString(3, m.getTipo());
        ps.setString(4, m.getZona());
        ps.setInt(5, m.getIdNave().getId());

        ps.executeUpdate();
        ps.close();
        this.desconectar();
    }
    public void insertTripulacion(Tripulacion t) throws SQLException {
        this.conectar();
        String query = "INSERT INTO Luftwaffe_Inventorien_Kontrol.Tripulacion (idPersonal,idMision) VALUES (?,?)";
        PreparedStatement ps = conexion.prepareStatement(query);
        
        //ps.setInt(1, t.getId());
        ps.setInt(1, t.getIdPersonal().getId());
        ps.setInt(2, t.getIdMision().getId());
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
    //Delete things
    //--------------------------------------------------------------------------
    public void deletePersonal(Personal p)throws SQLException{
        this.conectar();
        String query = "DELETE FROM Luftwaffe_Inventorien_Kontrol.Personal WHERE id='" + p.getId() + "'";
        Statement st = conexion.createStatement();
        st.executeUpdate(query);
        st.close();
        this.desconectar();
    }
    public void deleteTripulacion(Tripulacion t)throws SQLException{
        this.conectar();
        String query = "DELETE FROM Luftwaffe_Inventorien_Kontrol.Tripulacion WHERE id='" + t.getId() + "'";
        Statement st = conexion.createStatement();
        st.executeUpdate(query);
        st.close();
        this.desconectar();
    }
    public void deleteMision(Mision t)throws SQLException{
        this.conectar();
        String query = "DELETE FROM Luftwaffe_Inventorien_Kontrol.Mision WHERE id='" + t.getId() + "'";
        Statement st = conexion.createStatement();
        st.executeUpdate(query);
        st.close();
        this.desconectar();
    }
    public void deleteNave(Nave t)throws SQLException{
        this.conectar();
        String query = "DELETE FROM Luftwaffe_Inventorien_Kontrol.Nave WHERE id='" + t.getId() + "'";
        Statement st = conexion.createStatement();
        st.executeUpdate(query);
        st.close();
        this.desconectar();
    }
    //Gets
    //--------------------------------------------------------------------------
    public int getRand(){
        int tmp = (int) (Math.random()*10)+1;
        return tmp;
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
            p.setId(rs.getInt("id"));
            p.setNombre(rs.getString("nombre"));
            p.setApellido(rs.getString("apellido"));
            p.setRank(rs.getString("rank"));
            p.setEspecialidad(rs.getString("especialidad"));
        }
        rs.close();
        st.close();
        this.desconectar();
        return p;
    }
    public Mision getMisionById(int i) throws SQLException{
        this.conectar();
        Mision tmp = new Mision();
        String query = "Select * FROM Luftwaffe_Inventorien_Kontrol.Mision WHERE id='"+i+"'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        if(rs.next()){
            tmp.setId(rs.getInt("id"));
            tmp.setIdNave(getNaveFromId(rs.getInt("idNave")));
        }
        rs.close();
        this.desconectar();
        return tmp;
    }
    public Tripulacion getTripulacionById(int i) throws SQLException{
        this.conectar();
        Tripulacion tmp = new Tripulacion();
        String query = "Select * FROM Luftwaffe_Inventorien_Kontrol.Tripulacion WHERE id='"+i+"'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        if(rs.next()){
            tmp.setId(rs.getInt("id"));
        }
        rs.close();
        this.desconectar();
        return tmp;
    }
    public Personal getPersonalFromId(int i) throws SQLException{
        this.conectar();
        Personal personalReturnee = new Personal();
        String query = "Select * FROM Luftwaffe_Inventorien_Kontrol.Personal WHERE id='"+i+"'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        if(rs.next()){
            personalReturnee.setId(rs.getInt("id"));
        }
        rs.close();
        this.desconectar();

        return personalReturnee;
    }
    public Nave getNaveFromId(int i) throws SQLException{
        this.conectar();
        Nave naveReturnee = new Nave();
        String query = "Select * FROM Luftwaffe_Inventorien_Kontrol.nave WHERE id='"+i+"'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        if(rs.next()){
            naveReturnee.setId(rs.getInt("id"));
            naveReturnee.setFabricante(rs.getString("fabricante"));
            naveReturnee.setModelo(rs.getString("modelo"));
            naveReturnee.setTipo(rs.getString("tipo"));
        }
        rs.close();
        this.desconectar();

        return naveReturnee;
    }
    public List<Nave> getAllaNaves() throws SQLException{
        this.conectar();
        String query = "Select * FROM Luftwaffe_Inventorien_Kontrol.nave";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        List<Nave> allNaves = new ArrayList<Nave>();
        while(rs.next()){
            Nave n = new Nave();
            n.setId(rs.getInt("id"));
            n.setFabricante(rs.getString("fabricante"));
            n.setModelo(rs.getString("modelo"));
            n.setTipo(rs.getString("tipo"));
            allNaves.add(n);
        }
        rs.close();
        this.desconectar();
        return allNaves;
    }
    public List<Mision> getAllMision() throws SQLException{
        this.conectar();
        String query = "Select * FROM Luftwaffe_Inventorien_Kontrol.Mision";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        List<Mision> tmp = new ArrayList<Mision>();
        while(rs.next()){
            Mision m = new Mision();
            m.setId(rs.getInt("id"));
            m.setNombre(rs.getString("nombre"));
            m.setZona(rs.getString("zona"));
            m.setTipo(rs.getString("tipo"));
            tmp.add(m);
        }
        this.desconectar();
        return tmp;
    }
    public List<Tripulacion> getAllTrip() throws SQLException{
        this.conectar();
        String query = "Select * FROM Luftwaffe_Inventorien_Kontrol.Tripulacion";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        List<Tripulacion> allTrip = new ArrayList<Tripulacion>();
        while(rs.next()){
            Tripulacion n = new Tripulacion();
            n.setId(rs.getInt("id"));
            n.setIdPersonal(getPersonalFromId(rs.getInt("idPersonal")));
            n.setIdMision(getMisionById(rs.getInt("idMision")));
            
            allTrip.add(n);
        }
        rs.close();
        this.desconectar();
        return allTrip;
    }
    public Mision getMisionByName(String name) throws SQLException{
            this.conectar();
        String query = "SELECT * FROM Luftwaffe_Inventorien_Kontrol.Mision WHERE nombre='" + name + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        Mision k = new Mision();
        if(rs.next()){
            k.setId(rs.getInt("id"));
            k.setNombre(rs.getString("nombre"));
            k.setZona(rs.getString("zona"));
        }
        rs.close();
        st.close();
        this.desconectar();
        return k;
    }
    public Kontrol getKontrolByUsername(String name) throws SQLException{
            this.conectar();
        String query = "SELECT * FROM Luftwaffe_Inventorien_Kontrol.kontrol WHERE username='" + name + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        Kontrol k = new Kontrol();
        if(rs.next()){
            k.setUsername(rs.getString("username"));
            k.setPassword(rs.getString("password"));
            k.setRank(rs.getString("rank"));
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
    public List<Personal> getAllPersonal() throws SQLException{
        this.conectar();
        Statement st = conexion.createStatement();
        ArrayList<Personal> TodoPersonal = new ArrayList<>();
        String select = "SELECT * FROM Luftwaffe_Inventorien_Kontrol.Personal";
        ResultSet rs = st.executeQuery(select);
        while(rs.next()){
            Personal p = new Personal();
            p.setId(rs.getInt("id"));
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