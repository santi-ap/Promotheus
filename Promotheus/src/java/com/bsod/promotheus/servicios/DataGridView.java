package com.bsod.promotheus.servicios;

import com.bsod.promotheus.controladores.ControllerUsuario;
import com.bsod.promotheus.usuario.Promo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Wendell Monge
 */
@ManagedBean(name = "DataGridView")
@SessionScoped
public class DataGridView implements Serializable {

    private ArrayList<Promo> promos;

    private Promo selectedPromo;

    //@ManagedProperty("#{ServicioPromo}")
    private ServicioPromo service = new ServicioPromo();
    private ControllerUsuario cu = new ControllerUsuario();

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

    public Promo getSelectedPromo() {
        return selectedPromo;
    }

    public void setSelectedPromo(Promo selectedPromo) {
        this.selectedPromo = selectedPromo;
    }

//    public void setListUserPromos() {
//        this.promosByUser = service.selectAll("Usuario_correoUsuario",cu.retornaNombrePorCorreo());
//    }
// 
//    public List<Promo> getPromosByUser() {
//        this.setListUserPromos();
//        return this.promosByUser;// do FOR and case form abject top Promo
//    }
}
