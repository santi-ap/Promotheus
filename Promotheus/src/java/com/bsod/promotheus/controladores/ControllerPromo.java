/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsod.promotheus.controladores;

import com.bsod.promotheus.servicios.Servicio;
import com.bsod.promotheus.servicios.ServicioPromo;
import com.bsod.promotheus.servicios.ServicioUsuario_has_Favoritos;
import com.bsod.promotheus.usuario.Promo;
import javax.faces.application.FacesMessage;
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
    private String categoria;
    private String myFav;
    private String eleccion;

    
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public String getEleccion() {
        return eleccion;
    }

    public void setEleccion(String eleccion) {
        this.eleccion = eleccion;
    }
    
    public void guardarPromo (String correoUsuario)
    {
        
        this.getNuevaPromo().setCategoria(categoria);
        this.getNuevaPromo().setCorreoUsuario(correoUsuario);      
        this.getServicioPromo().insert(this.getNuevaPromo());
        this.setNuevaPromo(new Promo());
        this.redirect("registeredLandingPage");
        //return "registeredLandingPage.xhtml?faces-redirect=true";
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
    


    /**
     * @return the myFav
     */
    public String getMyFav() {
        return myFav;
    }

    /**
     * @param myFav the myFav to set
     */
    public void setMyFav(String myFav) {
        this.myFav = myFav;
    }
    
    public void composeMyFav(int idPromo, String correoUsuario)
    {
        this.myFav = correoUsuario + "," + Integer.toString(idPromo);
        Servicio sendToFav = new ServicioUsuario_has_Favoritos();
        ((ServicioUsuario_has_Favoritos)sendToFav).insert(this.myFav);
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Success",  "Promo Insertada en la lista de favoritos." ) );
    }
}
