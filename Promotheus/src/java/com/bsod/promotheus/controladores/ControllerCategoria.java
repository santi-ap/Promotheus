/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsod.promotheus.controladores;

import com.bsod.promotheus.servicios.ServicioCategoria;

/**
 *
 * @author Asus
 */
public class ControllerCategoria {
    private ServicioCategoria servicioCategoria;

    public ControllerCategoria ()
    {}
    
    /**
     * @return the servicioCategoria
     */
    public ServicioCategoria getServicioCategoria() {
        return servicioCategoria;
    }

    /**
     * @param servicioCategoria the servicioCategoria to set
     */
    public void setServicioCategoria(ServicioCategoria servicioCategoria) {
        this.servicioCategoria = servicioCategoria;
    }
    
    
}
