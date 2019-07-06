package com.bsod.promotheus.controladores;

import com.bsod.promotheus.servicios.ServicioUsuario;
import com.bsod.promotheus.usuario.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
/**
 *
 * @author Wendell Monge
 */
@ManagedBean(name = "ForgotPasswordController")
@SessionScoped
public class ForgotPasswordController extends Controller{

    public ForgotPasswordController() {
    }

    public ForgotPasswordController(String correoInput, String passInput) {
        super(correoInput, passInput);
    }
    
    
}
