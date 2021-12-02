/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Felipe Aguilera Ubilla 009V
 */
public class Pelicula {
    
    private int idpelicula;
    private String titulo;
    private Date estreno;
    private Date fecha;
    private boolean disponible;

    public Pelicula() {
    }

    public Pelicula(int idpelicula, String titulo, Date estreno, Date fecha, boolean disponible) {
        this.idpelicula = idpelicula;
        this.titulo = titulo;
        this.estreno = estreno;
        this.fecha = fecha;
        this.disponible = disponible;
    }

    public int getIdpelicula() {
        return idpelicula;
    }

    public void setIdpelicula(int idpelicula) {
        this.idpelicula = idpelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getEstreno() {
        return estreno;
    }

    public void setEstreno(Date estreno) {
        this.estreno = estreno;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "idpelicula=" + idpelicula + ", titulo=" + titulo + ", estreno=" + estreno + ", fecha=" + fecha + ", disponible=" + disponible + '}';
    }
    
    
}
