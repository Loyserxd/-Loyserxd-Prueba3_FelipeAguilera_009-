/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import BD.Conexion;
import java.util.Date;
import modelo.Sala;
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
public class Registro_Sala {
    
    public boolean agregar(Sala sala) {

        Date date;
        try {

            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            date = sala.getFecha();

            String query = "INSERT INTO sala(asiento,fecha,disponibilidad)VALUES(?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, sala.getAsiento());
            stmt.setDate(2, new java.sql.Date(date.getTime()));
            stmt.setBoolean(3, sala.isDisponibilidad());

            stmt.executeUpdate();
            stmt.close();
            cnx.close();

            return true;

        } catch (SQLException e) {
            System.out.println("Error en SQL al agregar Sala - Clase Registro_Sala" + e.getMessage());
            return false;
        }
    }

    public boolean actualizar(Sala sala) {

        Date date;
        try {

            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            date = sala.getFecha();

            String query = "UPDATE sala set asiento = ?,fecha =?,disponibilidad=? WHERE idsala =?";
            PreparedStatement stmt = cnx.prepareStatement(query);
     
            stmt.setInt(1, sala.getAsiento());
            stmt.setDate(2, new java.sql.Date(date.getTime()));
            stmt.setBoolean(3, sala.isDisponibilidad());
            stmt.setInt(4, sala.getIdsala());
            stmt.executeUpdate();
            stmt.close();
            cnx.close();

            return true;

        } catch (SQLException e) {
            System.out.println("Error en SQL al actualizar sala - Clase Registro_sala" + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int idSala) {

        try {

            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "DELETE FROM sala WHERE  idsala=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, idSala);

            stmt.executeUpdate();
            stmt.close();
            cnx.close();

            return true;

        } catch (SQLException e) {
            System.out.println("Error en SQL al eliminar sala - Clase Registro_sala" + e.getMessage());
            return false;
        }
    }

    public Sala buscarPorId(int idSala) {

        Sala sala = new Sala();

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "SELECT idsala,fecha,disponible FROM sala WHERE idsala = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, idSala);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                sala.setIdsala(rs.getInt("idsala"));
                sala.setFecha(rs.getDate("fecha"));
                sala.setDisponibilidad(rs.getBoolean("disponible"));

            }

            rs.close();
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error SQL al listar sala por ID " + e.getMessage());

        }
        return sala;

    }

    public List<Sala> buscarTodos() {

        List<Sala> lista_sala = new ArrayList<>();

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "SELECT idsala,asiento,fecha,disponibilidad FROM sala order by asiento";
            PreparedStatement stmt = cnx.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Sala sala = new Sala();
                sala.setIdsala(rs.getInt("idsala"));
                sala.setAsiento(rs.getInt("asiento"));
                sala.setFecha(rs.getDate("fecha"));
                sala.setDisponibilidad(rs.getBoolean("disponible"));

                lista_sala.add(sala);
            }

            rs.close();
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error SQL al listar sala por ID " + e.getMessage());

        }
        return lista_sala;

    }
    
}
