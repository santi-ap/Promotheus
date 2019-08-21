package com.bsod.promotheus.servicios;

import com.bsod.promotheus.usuario.Promo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Wendell Monge
 */
@ManagedBean(name = "DataGridView")
@SessionScoped
public class DataGridView implements Serializable {
    
    private ArrayList<Promo> promos;
    
    private ServicioPromo service = new ServicioPromo();

    public DataGridView() {
    }

    @PostConstruct
    public void init() {
        promos = service.selectAllPromos();
    }

    public List<Promo> getPromos() {
        //this.init();
        return promos;
    }

    public void setService(ServicioPromo service) {
        this.service = service;
    }
}
