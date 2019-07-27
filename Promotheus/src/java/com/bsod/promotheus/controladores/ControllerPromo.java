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
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

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
    
    public void guardarPromo (String correoUsuario)
    {
        System.out.println(correoUsuario);
        this.getNuevaPromo().setCorreoUsuario(correoUsuario);
        System.out.println( this.getNuevaPromo().getCorreoUsuario());      
        this.getServicioPromo().insert(this.getNuevaPromo());
        this.setNuevaPromo(new Promo());
        this.redirect("registeredLandingPage");
        //return "registeredLandingPage.xhtml?faces-redirect=true";
    }
    
    public void mostrarPromo ()
    {
        
    }
    
    public void redirect(String page)
    {
          try {
            HttpServletRequest request = (HttpServletRequest) FacesContext
                    .getCurrentInstance().getExternalContext().getRequest();
            FacesContext
                    .getCurrentInstance()
                    .getExternalContext()
                    .redirect(
                            request.getContextPath()
                            + "/faces/" + page + ".xhtml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
   
}
