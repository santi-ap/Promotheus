/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsod.promotheus.controladores;

import com.bsod.promotheus.usuario.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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

   
    private Usuario Logear(String correoInput, String passInput){
        
        return new Usuario();
    }
    
}
