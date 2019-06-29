/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsod.promotheus.controladores;
import com.bsod.promotheus.servicios.ServicioUsuario;
import com.bsod.promotheus.usuario.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import static org.primefaces.component.focus.Focus.PropertyKeys.context;

/**
 *
 * @author DacordMachine
 */
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
    
    public RegisterController(){}

    

    

    public Usuario registrar() {
        ServicioUsuario su = new ServicioUsuario();
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        if (super.existeCorreo(this.getCorreoInput())){
          //  context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El correo ya se ha usado", "Utilizar otro correo"));
            System.out.println("Ya exsite");
        }else{
            Usuario u = new Usuario();
            u.setNombreUsuario(this.getNombreInput());
            u.setCorreoUsuario(this.getCorreoInput());
            u.setPassUsuario(this.getPassInput());
            su.insert(u);
            System.out.println("Usuario insertado a BD");
        }

        return new Usuario();
    }

}
