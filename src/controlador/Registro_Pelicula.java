/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import BD.Conexion;
import java.util.Date;
import modelo.Pelicula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felipe Aguilera Ubilla
 */
public class Registro_Pelicula {
    
    public boolean agregar(Pelicula pelicula) {

        Date date;
        try {

            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            date = pelicula.getEstreno();
            date = pelicula.getFecha();

            String query = "INSERT INTO pelicula(titulo,estreno,fecha,disponible)VALUES(?,?,?,?)";//La consulta sql siempre es en String
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, pelicula.getTitulo());
            stmt.setDate(2, new java.sql.Date(date.getTime()));//Recordar esto.
            stmt.setDate(3, new java.sql.Date(date.getTime()));
            stmt.setBoolean(4, pelicula.isDisponible());

            stmt.executeUpdate();
            stmt.close();
            cnx.close();

            return true;

        } catch (SQLException e) {
            System.out.println("Error en SQL al agregar pelicula - Clase Registro_Pelicula" + e.getMessage());
            return false;
        }
    }

    public boolean actualizar(Pelicula pelicula) {

        Date date;
        try {

            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            date = pelicula.getEstreno();
            date = pelicula.getFecha();

            String query = "UPDATE pelicula set titulo = ?,estreno=?,fecha =?,disponible=? WHERE idlibro =?";
            PreparedStatement stmt = cnx.prepareStatement(query);
     
            stmt.setString(1, pelicula.getTitulo());
            stmt.setDate(2, new java.sql.Date(date.getTime()));
            stmt.setDate(3, new java.sql.Date(date.getTime()));
            stmt.setBoolean(4, pelicula.isDisponible());
            stmt.setInt(5, pelicula.getIdpelicula());
            stmt.executeUpdate();
            stmt.close();
            cnx.close();

            return true;

        } catch (SQLException e) {
            System.out.println("Error en SQL al actualizar pelicula - Clase Registro_pelicula" + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int idPelicula) {

        try {

            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "DELETE FROM pelicula WHERE  idpelicula=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, idPelicula);

            stmt.executeUpdate();
            stmt.close();
            cnx.close();

            return true;

        } catch (SQLException e) {
            System.out.println("Error en SQL al eliminar pelicula - Clase Registro_Pelicula" + e.getMessage());
            return false;
        }
    }

    public Pelicula buscarPorId(int idPelicula) {

        Pelicula pelicula = new Pelicula();

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "SELECT idpelicula,titulo,estreno,fecha,disponible FROM pelicula WHERE idpelicula = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, idPelicula);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                pelicula.setIdpelicula(rs.getInt("idpelicula"));
                pelicula.setTitulo(rs.getString("titulo"));
                pelicula.setEstreno(rs.getDate("estreno"));
                pelicula.setFecha(rs.getDate("fecha"));
                pelicula.setDisponible(rs.getBoolean("disponible"));

            }

            rs.close();
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error SQL al listar pelicula por ID " + e.getMessage());

        }
        return pelicula;

    }

    public List<Pelicula> buscarTodos() {

        List<Pelicula> lista = new ArrayList<>();

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "SELECT idpelicula,titulo,estreno,fecha,disponible FROM pelicula order by titulo";
            PreparedStatement stmt = cnx.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Pelicula pelicula = new Pelicula();
                pelicula.setIdpelicula(rs.getInt("idpelicula"));
                pelicula.setTitulo(rs.getString("titulo"));
                pelicula.setEstreno(rs.getDate("Estreno"));
                pelicula.setFecha(rs.getDate("fecha"));
                pelicula.setDisponible(rs.getBoolean("disponible"));

                lista.add(pelicula);
            }

            rs.close();
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error SQL al listar pelicula por ID " + e.getMessage());

        }
        return lista;

    }
    
}
