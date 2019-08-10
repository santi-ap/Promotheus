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
@ManagedBean(name="controllerUsuario")
@SessionScoped
public class ControllerUsuario {
    
    private String correoInput;
    private String nombreInput;
    private String passInput;
    private String passDosInput;
    private String nombreUsuarioCorreo;
    ServicioUsuario su = new ServicioUsuario();

    

    public ControllerUsuario(){}
    
    public ControllerUsuario(String correoInput, String passInput) {
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
    
    public ServicioUsuario getSu() {
        return su;
    }

    public String getNombreUsuarioCorreo() {
        return nombreUsuarioCorreo;
    }

    public void setNombreUsuarioCorreo(String nombreUsuarioCorreo) {
        this.nombreUsuarioCorreo = nombreUsuarioCorreo;
    }

    public void setSu(ServicioUsuario su) {
        this.su = su;
    }
    
    
    public boolean existeCorreo(String correoInput) {// al presionar boton acceptar  se busca si el correo ya existe en al base de datos
        String correoBD = su.select("correoUsuario", "correoUsuario", correoInput).toString();

        if (correoInput.equals(correoBD)) {
            return true;
        } else {
            return false;
        }

    }
    
    public boolean verificarPass(String passInput, String passDosInput){
        return (passInput.equals(passDosInput));
    }
    
    // ----------------------------- LOGICA DE LOGEO ---------------------------------------
    public String Logear(){
        
        FacesContext context = FacesContext.getCurrentInstance();
        //Verifica que los espacios no estén vacíos
        if (this.getCorreoInput().equals("") || this.getPassInput().equals("")){
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Favor llenar todos los campos"));    
        } else {
            //Verifica que el correo esté registrado
            if(!this.existeCorreo(this.getCorreoInput())){
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Este correo todavía no está registrado"));
            } else {
                  //Verifica que la contraseña sea la misma 
                  String s  = this.getSu().select("passUsuario", "passUsuario", this.getPassInput()).toString();
                  System.out.print(s);
                  if(!this.verificarPass(s, this.getPassInput())){
                      context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "La contraseña es incorrecta"));
                  } else {
                  this.nombreUsuarioCorreo = this.retornaNombrePorCorreo();
                  return "registeredLandingPage.xhtml?faces-redirect=true";
                  }
            }
        }
    
       return null;
        
    }
    
    public String botonRegistro(){// metodo para llevar a pagina de registro
        return "registerForm.xhtml?faces-redirect=true";
    }
    
      //Metodo para retornar el nombre del usuario basado en el correo
     public String retornaNombrePorCorreo(){
        return (su.select("nombreUsuario", "correoUsuario", this.getCorreoInput()).toString()); 
    }
     
     
 // ----------------------------- TERMINA LOGICA DE LOGEO ---------------------------------------
     
     
     // ----------------------------- LOGICA DE REGISTRO ---------------------------------------
     
     
     public String registrar() {
        FacesContext context = FacesContext.getCurrentInstance();//se instancia un nuevo mensaje para el web app

        //este primer IF es para asegurarse de que todos los campos estan llenos
        if ((this.getCorreoInput().equals("")) || (this.getNombreInput().equals("")) || (this.getPassDosInput().equals("")) || (this.getPassInput().equals(""))) {
            //si no estan llenos, muestra un mensaje que dice que no se llenaron todos los campos
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Favor llenar todos los campos"));
        } else {
            //si todos los campos estan llenos, hace un IF para revisar que las contrasennas sean igual
            if (!this.verificarPass(this.getPassInput(), this.getPassDosInput())) {
                //si no son iguales, muestra un mensaje que indica que las contrasennas son diferentes
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Las contrasennas no son iguales", "Asegurese de que ambas contrasennas sean iguales"));
            } else {
                //si las contrasennas son iguales, entonces verifica si el correo ya existe en la base de datos 
                if (this.existeCorreo(this.getCorreoInput())) {
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

    public String cancelarRegistro() {
        return "index.xhtml?faces-redirect=true";
    }
    // ----------------------------- TERMINA LOGICA DE REGISTRO ---------------------------------------
    public String redirectToLogin()
    {
        FacesContext context = FacesContext.getCurrentInstance();//se instancia un nuevo mensaje para el web app
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "LOGIN REQUERIDO", "Un usuario registrado es necesario para agregar una promocion nueva.\n Redireccionando..."));
        return "index.xhtml?faces-redirect=true";
    }
}
