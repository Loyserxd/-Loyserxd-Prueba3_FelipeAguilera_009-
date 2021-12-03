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
public class Sala {
    
    private int idsala;
    private int asientos;
    private Date fecha;
    private boolean disponibilidad;

    public Sala() {
    }

    public Sala(int idsala, int asientos, Date fecha, boolean disponibilidad) {
        this.idsala = idsala;
        this.asientos = asientos;
        this.fecha = fecha;
        this.disponibilidad = disponibilidad;
    }

    public int getIdsala() {
        return idsala;
    }

    public void setIdsala(int idsala) {
        this.idsala = idsala;
    }

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String toString() {
        return "Sala{" + "idsala=" + idsala + ", asientos=" + asientos + ", fecha=" + fecha + ", disponibilidad=" + disponibilidad + '}';
    }
    
    
    
    
}
