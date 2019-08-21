package com.bsod.promotheus.servicios;

import com.bsod.promotheus.controladores.ControllerPromo;
import com.bsod.promotheus.usuario.Promo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Wendell Monge
 */
@ManagedBean(name = "DataGridViewSearch")
@SessionScoped
public class DataGridViewSearch implements Serializable {

    private ArrayList<Promo> promos;

    private ServicioPromo service = new ServicioPromo();
    
    @ManagedProperty("#{controllerPromo}")
    private ControllerPromo controller = new ControllerPromo();

    public DataGridViewSearch() {
    }

    @PostConstruct
    public void init() {
        promos = service.selectBusqueda(this.getController().getBusqueda());
    }

    public List<Promo> getPromos() {
        this.init();
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

    public ControllerPromo getController() {
        return controller;
    }

    public void setController(ControllerPromo controller) {
        this.controller = controller;
    }
}