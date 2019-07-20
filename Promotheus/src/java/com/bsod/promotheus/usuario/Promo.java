/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsod.promotheus.usuario;

import java.sql.Date;

/**
 *
 * @author Asus
 */
public class Promo {
    private String linkPromo;
    private String tituloPromo;
    private String descripcionPromo;
    private Date fechaInicio;
    private Date fechaFin;
    private Date fechaPublicacion;
    private int id;
    
    public Promo ()
    {
        
    }

    /**
     * @return the linkPromo
     */
    public String getLinkPromo() {
        return linkPromo;
    }

    /**
     * @param linkPromo the linkPromo to set
     */
    public void setLinkPromo(String linkPromo) {
        this.linkPromo = linkPromo;
    }

    /**
     * @return the tituloPromo
     */
    public String getTituloPromo() {
        return tituloPromo;
    }

    /**
     * @param tituloPromo the tituloPromo to set
     */
    public void setTituloPromo(String tituloPromo) {
        this.tituloPromo = tituloPromo;
    }

    /**
     * @return the descripcionPromo
     */
    public String getDescripcionPromo() {
        return descripcionPromo;
    }

    /**
     * @param descripcionPromo the descripcionPromo to set
     */
    public void setDescripcionPromo(String descripcionPromo) {
        this.descripcionPromo = descripcionPromo;
    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the fechaPublicacion
     */
    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    /**
     * @param fechaPublicacion the fechaPublicacion to set
     */
    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
