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
    
    public RegisterController(){}

    

    public String registrar() {// metodo revisa si ya existe el correo y agregar datos a BD
        ServicioUsuario su = new ServicioUsuario();
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        if (super.existeCorreo(this.getCorreoInput())){// si existe el correo retorna mensaje
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El correo ya se ha usado", "Utilizar otro correo"));
            System.out.println("Ya exsite");
        }else{// se crea un usario y se agrega a la BD. Despues lleva al usuario al landing opage
            Usuario u = new Usuario();
            u.setNombreUsuario(this.getNombreInput());
            u.setCorreoUsuario(this.getCorreoInput());
            u.setPassUsuario(this.getPassInput());
            su.insert(u);
            System.out.println("Usuario insertado a BD");
            return this.redirectLandingPage();
        }

     return null;   
    }
    
    public String redirectLandingPage(){
        return "registeredLandingPage.xhtml?faces-redirect=true";
    }
    
    public String cancelarRegistro(){
        return "index.xhtml?faces-redirect=true";
    }
    

}
