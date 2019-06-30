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

/**
 *
 * @author DacordMachine
 */
@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController extends Controller {

    public LoginController(String correoInput, String passInput) {
        super(correoInput, passInput);
    }

    public LoginController() {
    }

   
    public String Logear(){
        
        FacesContext context = FacesContext.getCurrentInstance();
        //Verifica que los espacios no estén vacíos
        if (this.getCorreoInput().equals("") || this.getPassInput().equals("")){
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Favor llenar todos los campos"));    
        } else {
            //Verifica que el correo esté registrado
            if(!super.existeCorreo(this.getCorreoInput())){
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Este correo todavía no está registrado"));
            } else {
                  //Verifica que la contraseña sea la misma 
                  String s  = this.getSu().select("passUsuario", "passUsuario", this.getPassInput()).toString();
                  System.out.print(s);
                  if(!this.verificarPass(s, this.getPassInput())){
                      context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "La contraseña es incorrecta"));
                  } else {
                  
                  return "registeredLandingPage.xhtml?faces-redirect=true";
                  }
            }
        }
    
       return null;
        
    }
    
    public String botonRegistro(){// metodo para llevar a pagina de registro
        return "registerForm.xhtml?faces-redirect=true";
    }
    
}
