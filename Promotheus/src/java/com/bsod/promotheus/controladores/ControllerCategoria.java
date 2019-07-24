/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsod.promotheus.controladores;

import com.bsod.promotheus.servicios.ServicioCategoria;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author Asus
 */
@ManagedBean(name = "controllerCategoria")
public class ControllerCategoria {
    private ServicioCategoria servicioCategoria = new ServicioCategoria();
    FacesContext context = FacesContext.getCurrentInstance();

    private String categoria;  
    private List<String> categorias = new ArrayList<>();
    
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
    
   public String getCategoria() {
        return categoria;
    }
 
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
 
    public List<String> getCategorias() {
        this.setCategorias();
        return categorias;
    }
 
    public void setCategorias() {
        this.categorias = servicioCategoria.selectNombreCategoria();
        
    }
    
    public void printCat(){  // METHOD TO TEST WHAT THE SELECTED CATEGORY IS
        System.out.println("testing");
        System.out.println(this.categoria);
        
    }
}
