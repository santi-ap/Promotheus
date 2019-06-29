/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsod.promotheus.controladores;

/**
 *
 * @author DacordMachine
 */
public abstract class Controller {
    
    private String correoInput;
    private String passInput;

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
    
    
    
    private boolean existeCorreo(String correoInput){
        
        
        return true;
    }
    
    private boolean verificarPass(String passInput, String passDosInput){
        
        return true;
        
    }
    
}
