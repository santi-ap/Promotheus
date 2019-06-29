/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsod.promotheus.controladores;

import com.bsod.promotheus.servicios.ServicioUsuario;

/**
 *
 * @author DacordMachine
 */
public abstract class Controller {
    
    private String correoInput;
    private String passInput;
    private ServicioUsuario su = new ServicioUsuario();

    public ServicioUsuario getSu() {
        return su;
    }

    public void setSu(ServicioUsuario su) {
        this.su = su;
    }

    public Controller(){}
    
    public Controller(String correoInput, String passInput) {
        this.correoInput = correoInput;
        this.passInput = passInput;
    }

    public String getCorreoInput() {
        return correoInput;
    }

    public void setCorreoInput(String correoInput) {
        this.correoInput = correoInput;
    }

    public String getPassInput() {
        return passInput;
    }

    public void setPassInput(String passInput) {
        this.passInput = passInput;
    }
    
    
    
    public boolean existeCorreo(String correoInput) {// al presionar boton acceptar  se busca si el correo ya existe en al base de datos

        ServicioUsuario su = new ServicioUsuario();
        String correoBD = su.select("correoUsuario", "correoUsuario", correoInput).toString();

        if (correoInput.equals(correoBD)) {
            return true;
        } else {
            return false;
        }

    }
    
    private boolean verificarPass(String passInput, String passDosInput){
        
        return (passInput.equals(passDosInput));
        
    }
    
}
