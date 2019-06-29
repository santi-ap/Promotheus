/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsod.promotheus.controladores;

import com.bsod.promotheus.usuario.Usuario;

/**
 *
 * @author DacordMachine
 */
public class RegisterController extends Controller {

    public RegisterController(String correoInput, String passInput) {
        super(correoInput, passInput);
    }
    
    private Usuario registrar(){
        
        return new Usuario();
    }
    
}
