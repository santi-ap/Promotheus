/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsod.promotheus.controladores;
import com.bsod.promotheus.usuario.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author DacordMachine
 */
@ManagedBean(name="RegisterController")
@SessionScoped
public class RegisterController extends Controller {
    
    private String nombreInput;
    private String passDosInput;

    public String getNombreInput() {
        return nombreInput;
    }

    public void setNombreInput(String nombreInput) {
        this.nombreInput = nombreInput;
    }

    public String getPassDosInput() {
        return passDosInput;
    }

    public void setPassDosInput(String passDosInput) {
        this.passDosInput = passDosInput;
    }

    public RegisterController(String correoInput, String passInput) {
        super(correoInput, passInput);
    }

    public RegisterController() {
    }

    

    public Usuario registrar() {

        return new Usuario();
    }

}
