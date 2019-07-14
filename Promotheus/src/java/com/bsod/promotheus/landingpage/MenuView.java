/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsod.promotheus.landingpage;

import com.bsod.promotheus.controladores.LoginController;
import com.bsod.promotheus.controladores.RegisterController;
import com.bsod.promotheus.servicios.ServicioUsuario;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author santialfonso
 */
@ManagedBean(name = "menuView")
public class MenuView {

    private String nombreUsuarioIngresado ;
    LoginController lc = new LoginController();
    RegisterController rc = new RegisterController();
    ServicioUsuario su = new ServicioUsuario();
    

    public String getNombreUsuarioIngresado() {
        return nombreUsuarioIngresado;
    }

    public void setNombreUsuarioIngresado(String nombreUsuarioIngresado) {
        this.nombreUsuarioIngresado = nombreUsuarioIngresado;
    }
    
     public String retornaNombrePorCorreo() {
         String nombrePorCorreoTemp="";
        if(!lc.getCorreoInput().equals("")){
            System.out.println("Correo login: "+lc.getCorreoInput());
            nombrePorCorreoTemp=su.select("nombreUsuario", "correoUsuario", lc.getCorreoInput()).toString();
            lc.setCorreoInput("");
        }else if(!rc.getCorreoInput().equals("")){
            System.out.println("Correo register: "+rc.getCorreoInput());
            nombrePorCorreoTemp=su.select("nombreUsuario", "correoUsuario", lc.getCorreoInput()).toString();
            rc.setCorreoInput("");
        }
        return nombrePorCorreoTemp;
    }
    
    
    
}
