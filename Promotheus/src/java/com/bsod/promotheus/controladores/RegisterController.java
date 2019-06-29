/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsod.promotheus.controladores;

import com.bsod.promotheus.servicios.ServicioUsuario;
import com.bsod.promotheus.usuario.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import static org.primefaces.component.focus.Focus.PropertyKeys.context;

/**
 *
 * @author DacordMachine
 */
@ManagedBean(name = "RegisterController")
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

    public String registrar() {
        ServicioUsuario su = new ServicioUsuario();//se insancia un nuevo usuario
        FacesContext context = FacesContext.getCurrentInstance();//se instancia un nuevo mensaje para el web app

        //este primer IF es para asegurarse de que todos los campos estan llenos
        if ((this.getCorreoInput().equals("")) || (this.getNombreInput().equals("")) || (this.getPassDosInput().equals("")) || (this.getPassInput().equals(""))) {
            //si no estan llenos, muestra un mensaje que dice que no se llenaron todos los campos
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Favor llenar todos los campos"));
        } else {
            //si todos los campos estan llenos, hace un IF para revisar que las contrasennas sean igual
            if (!super.verificarPass(this.getPassInput(), this.getPassDosInput())) {
                //si no son iguales, muestra un mensaje que indica que las contrasennas son diferentes
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Las contrasennas no son iguales", "Asegurese de que ambas contrasennas sean iguales"));
            } else {
                //si las contrasennas son iguales, entonces verifica si el correo ya existe en la base de datos 
                if (super.existeCorreo(this.getCorreoInput())) {
                    //si ya existe, muestra un mensaje que idica que ya existe el correo
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El correo ya se ha usado", "Utilizar otro correo"));
                    System.out.println("Ya exsite");
                } else {
                    //si no esta en uso el correo, entonces se crea un usuario nuevo y lo ingresa a la base de datos
                    Usuario u = new Usuario();
                    u.setNombreUsuario(this.getNombreInput());
                    u.setCorreoUsuario(this.getCorreoInput());
                    u.setPassUsuario(this.getPassInput());
                    su.insert(u);
                    System.out.println("Usuario insertado a BD");
                    return this.redirectLandingPage();//despues de registrar, redirecciona al landing page
                }
            }
        }

        return null;
    }

    public String redirectLandingPage() {
        return "registeredLandingPage.xhtml?faces-redirect=true";
    }
    
    public String cancelarRegistro(){
        return "index.xhtml?faces-redirect=true";
    }
    

}
