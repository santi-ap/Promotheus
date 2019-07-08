package com.bsod.promotheus.controladores;

import com.bsod.promotheus.servicios.ServicioUsuario;
import com.bsod.promotheus.usuario.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
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
    
    public String olvideMiContrasena() throws Exception {
    ServicioUsuario su = new ServicioUsuario();//se insancia un nuevo usuario
    FacesContext context = FacesContext.getCurrentInstance();//se instancia un nuevo mensaje 

    //este IF es para asegurarse de que todos los campos esten llenos
        if (super.getCorreoInput().equals("")) {
            //si no lo estan, muestra un mensaje de error
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Favor llenar todos los campos"));
        } else {
            if (!super.existeCorreo(this.getCorreoInput())) {
                    //si no existe, muestra un mensaje que indique que no hay existe el correo
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "USUARIO NO ENCONTRADO", "Requiere registrarse para poder continuar"));
                    System.out.println("NO existe");
                } 
            else {
                    //si ya existe, muestra un mensaje que indique que ya existe el correo y le envie la nueva contraseña
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario detectado", "Enviando nueva contraseña a su correo..."));
                    System.out.println("SI existe");
                    this.enviarEmail(super.getCorreoInput());
            }
        
   }
        return null;
  }
   
    private static void setEmailInfo(Email email, String subject, String body) throws Exception {
		email.setFrom("diariofacil5@gmail.com", subject);
		email.setSubject(subject);
		email.setMsg(body);
	}
    
    public void enviarEmail(String correo) throws EmailException{
        Email email = new SimpleEmail();
        email.setSmtpPort(587);
	email.setCharset("UTF-8");
	email.setDebug(false);
	email.setHostName("smtp.gmail.com");
	email.getMailSession().getProperties().put("mail.smtps.auth", "true");
	email.getMailSession().getProperties().put("mail.debug", "true");
	email.getMailSession().getProperties().put("mail.smtps.port", "587");
	email.getMailSession().getProperties().put("mail.smtps.socketFactory.port", "587");
	email.getMailSession().getProperties().put("mail.smtps.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        email.getMailSession().getProperties().put("mail.smtps.socketFactory.fallback", "false");
	email.getMailSession().getProperties().put("mail.smtp.starttls.enable", "true");
        String authuser = "diariofacil5@gmail.com";
	String authpwd = "d1s2t3w4";
	email.setAuthenticator(new DefaultAuthenticator(authuser, authpwd));
        String subject = "Cambio de Contraseña PROMOTHEUS";
        try {
            setEmailInfo(email, subject, "Notificaci�n autom�tica - NO responder este correo.\n\n Estimado(a), \n\nEste correo dice que c  mamo: \n");
        } catch (Exception ex) {
            Logger.getLogger(ForgotPasswordController.class.getName()).log(Level.SEVERE, null, ex);
        }
        email.addTo(correo);
        email.send();
    }
	
}
