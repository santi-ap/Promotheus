/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsod.promotheus.servicios;

import com.bsod.promotheus.controladores.ControllerUsuario;
import com.bsod.promotheus.usuario.Promo;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author DacordMachine
 */
@ManagedBean (name="DataGridViewPromosFavoritas")
public class DataGridViewPromosFavoritas implements Serializable{
    
    private ArrayList<Promo> promoFavoritas;
     
    private ServicioUsuario_has_Favoritos service = new ServicioUsuario_has_Favoritos();
    
    @ManagedProperty("#{controllerUsuario}")
    private ControllerUsuario controller = new ControllerUsuario();
    
    @PostConstruct
    public void init() {
        promoFavoritas = service.selectPromosFavoritas(this.getController().getCorreoInput());
    }

    public ArrayList<Promo> getPromoFavoritas() {
        return promoFavoritas;
    }
    
    public void eliminarPromo(int id, String correo){
        
       this.getService().deletePromoFavorita(id, correo);
        
    }
   
    public void setPromoFavoritas(ArrayList<Promo> promoFavoritas) {
        this.promoFavoritas = promoFavoritas;
    }

    public ServicioUsuario_has_Favoritos getService() {
        return service;
    }

    public void setService(ServicioUsuario_has_Favoritos service) {
        this.service = service;
    }

    public ControllerUsuario getController() {
        return controller;
    }

    public void setController(ControllerUsuario controller) {
        this.controller = controller;
    }

   
    
    
    
    
    
    
    
    
}
