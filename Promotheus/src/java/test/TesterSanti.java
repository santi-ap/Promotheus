/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.bsod.promotheus.servicios.ServicioUsuario;
import com.bsod.promotheus.usuario.Usuario;

/**
 *
 * @author santialfonso
 */
public class TesterSanti {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServicioUsuario su = new ServicioUsuario();
//        System.out.println(su.selectAll("nombreUsuario", "user1"));
        Usuario u = new Usuario("user8","8@8","pass8");
        su.insert(u);
//        su.update("nombreUsuario", "Santi", "correoUsuario", "2@2");
//        System.out.println(su.select("nombreUsuario", "correoUsuario", "2@2"));
        //su.delete("correoUsuario", "2@2");
    }
    
}
