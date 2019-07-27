/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsod.promotheus.usuario;


/**
 *
 * @author Asus
 */
public class Promo {
    private String linkPromo;
    private String tituloPromo;
    private String descripcionPromo;
    private java.util.Date fechaInicio;
    private java.util.Date fechaFin;
    private java.util.Date fechaPublicacion;
    private int id;
    private String correoUsuario;
    
    public Promo ()
    {
        
    }

    public Promo(String linkPromo, String tituloPromo, String descripcionPromo, java.util.Date fechaInicio, java.util.Date fechaFin, java.util.Date fechaPublicacion, String correoUsuario) {
        this.linkPromo = linkPromo;
        this.tituloPromo = tituloPromo;
        this.descripcionPromo = descripcionPromo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaPublicacion = fechaPublicacion;
        this.correoUsuario = correoUsuario;
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
    public java.util.Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(java.util.Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public java.util.Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(java.util.Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the fechaPublicacion
     */
    public java.util.Date getFechaPublicacion() {
        if (this.fechaPublicacion == null)
            this.setFechaPublicacion(new java.util.Date());
        
        return fechaPublicacion;
    }

    /**
     * @param fechaPublicacion the fechaPublicacion to set
     */
    public void setFechaPublicacion(java.util.Date fechaPublicacion) {
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

    /**
     * @return the correoUsuario
     */
    public String getCorreoUsuario() {
        return correoUsuario;
    }

    /**
     * @param correoUsuario the correoUsuario to set
     */
    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }
    
    /**
     * 
     * @param calendarDate the util.Date to convert
     * @return the same date as a sql.Date class
     */
    public java.sql.Date sqlDate(java.util.Date calendarDate) 
    {
        return new java.sql.Date(calendarDate.getTime());
    }
    
    /**
     * 
     * @return the fechaPublicacion as sql.Date
     */
    public java.sql.Date getFechaPublicacionSQL ()
    {
        return this.sqlDate(this.getFechaPublicacion());
    }   
    /**
     * 
     * @return the fechaInicio as sql.Date
     */
    public java.sql.Date getFechaInicioSQL ()
    {
        return this.sqlDate(this.getFechaInicio());
    }   
    /**
     * 
     * @return the fechaFin as sql.Date
     */
    public java.sql.Date getFechaFinSQL ()
    {
        return this.sqlDate(this.getFechaFin());
    }
    
    
    
}
