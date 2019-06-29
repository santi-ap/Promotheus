/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsod.promotheus.controladores;
import javax.faces.context.FacesContext;
import com.bsod.promotheus.usuario.Usuario;
import javax.faces.application.FacesMessage;


/**
 *
 * @author DacordMachine
 */
public class RegisterController extends Controller {

    String corIn = "o";// replace o with user input
    String corBD = "i";//replace i with db query
    FacesContext context = FacesContext.getCurrentInstance();

    public RegisterController(String correoInput, String passInput) {
        super(correoInput, passInput);
    }

    public void RevisarCorreo() {
        if(corIn.equals(corBD)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El correo ya se ha utilizado","Insertar otro correo"));
        }else{
            
        }
    }
    
    public Usuario registrar(){
        
        return new Usuario();
    }

}
