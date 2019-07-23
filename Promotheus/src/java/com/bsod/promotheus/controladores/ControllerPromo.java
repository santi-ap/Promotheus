/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsod.promotheus.controladores;

import com.bsod.promotheus.servicios.ServicioPromo;
import com.bsod.promotheus.usuario.Promo;
import static com.sun.javafx.logging.PulseLogger.addMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Asus
 */
@ManagedBean(name="controllerPromo")
@SessionScoped
public class ControllerPromo {
    private ServicioPromo servicioPromo = new ServicioPromo();
    private Promo nuevaPromo = new Promo();
    
    

    public ControllerPromo () 
    {
        this.servicioPromo = new ServicioPromo ();
        this.nuevaPromo = new Promo ();
    }
    /**
     * @return the servicioPromo
     */
    public ServicioPromo getServicioPromo() {
        return servicioPromo;
    }

    /**
     * @param servicioPromo the sc to set
     */
    public void setServicioPromo(ServicioPromo servicioPromo) {
        this.servicioPromo = servicioPromo;
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
    
    public String guardarPromo (String correoUsuario)
    {
        System.out.println("b1");
        System.out.println(correoUsuario);
        this.getNuevaPromo().setCorreoUsuario(correoUsuario);
        System.out.println( this.getNuevaPromo().getCorreoUsuario());
        
        this.getServicioPromo().insert(this.getNuevaPromo());
        System.out.println(this.nuevaPromo.getFechaPublicacionSQL());
        
        System.out.println(this.nuevaPromo.getFechaInicioSQL());
        System.out.println(this.nuevaPromo.getFechaFinSQL());
////        addMessage("Insertando promo...");
////        System.out.println("b1");
        return "registeredLandingPage.xhtml?faces-redirect=true";
    }
    
    public void mostrarPromo ()
    {
        
    }
    
   
}
