package com.bsod.promotheus.servicios;

import com.bsod.promotheus.controladores.ControllerUsuario;
import com.bsod.promotheus.usuario.Promo;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Wendell Monge
 */
@SessionScoped
public class DataGridViewUserPromo implements Serializable {

private ArrayList<Promo> promos;

private Promo selectedPromo;

    private ServicioPromo service = new ServicioPromo();
    
    @ManagedProperty("#{controllerUsuario}")
    private ControllerUsuario controller = new ControllerUsuario();
    
    @PostConstruct
    public void init() {
        promos = service.selectAllTypePromo("Usuario_correoUsuario", this.controller.getCorreoInput());
    }

    public ArrayList<Promo> getPromos() {
        return promos;
    }

    public void setPromos(ArrayList<Promo> promos) {
        this.promos = promos;
    }

    public ServicioPromo getService() {
        return service;
    }

    public void setService(ServicioPromo service) {
        this.service = service;
    }

    public ControllerUsuario getController() {
        return controller;
    }

    public void setController(ControllerUsuario controller) {
        this.controller = controller;
    }

    public Promo getSelectedPromo() {
        return selectedPromo;
    }

    public void setSelectedPromo(Promo selectedPromo) {
        this.selectedPromo = selectedPromo;
    }
}
