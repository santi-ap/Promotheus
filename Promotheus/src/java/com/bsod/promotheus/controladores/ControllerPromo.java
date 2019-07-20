/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsod.promotheus.controladores;

import com.bsod.promotheus.servicios.ServicioCategoria;
import com.bsod.promotheus.usuario.Promo;

/**
 *
 * @author Asus
 */
public class ControllerPromo {
    private ServicioCategoria servicioCategoria;
    private Promo nuevaPromo;

    public ControllerPromo () 
    {
        this.servicioCategoria = new ServicioCategoria ();
        this.nuevaPromo = new Promo ();
    }
    /**
     * @return the sc
     */
    public ServicioCategoria getServicioCategoria() {
        return servicioCategoria;
    }

    /**
     * @param sc the sc to set
     */
    public void setServicioCategoria(ServicioCategoria servicioCategoria) {
        this.servicioCategoria = servicioCategoria;
    }

    /**
     * @return the nuevaPromo
     */
    public Promo getNuevaPromo() {
        return nuevaPromo;
    }

    /**
     * @param nuevaPromo the nuevaPromo to set
     */
    public void setNuevaPromo(Promo nuevaPromo) {
        this.nuevaPromo = nuevaPromo;
    }
    
    public void guardarPromo (Promo nuevoPromo)
    {
        
    }
    
    public void mostrarPromo ()
    {
        
    }
    
   
}
