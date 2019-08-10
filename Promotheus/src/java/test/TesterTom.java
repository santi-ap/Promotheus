/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.bsod.promotheus.controladores.ControllerPromo;
import com.bsod.promotheus.servicios.ServicioPromo;
import com.bsod.promotheus.servicios.ServicioUsuario_has_Favoritos;
import com.bsod.promotheus.usuario.Promo;
import java.util.Date;

/**
 *
 * @author Asus
 */
public class TesterTom {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        ServicioUsuario_has_Favoritos sohp = new ServicioUsuario_has_Favoritos();
        
        sohp.insert("tommasoribaudo1@gmail.com,34");
//        ServicioPromo sp = new ServicioPromo ();
//        ControllerPromo cp = new ControllerPromo();
//        cp.setServicioPromo(sp);
//        Date fi;
//        fi = new Date (System.currentTimeMillis());
//        Date ff = new Date (System.currentTimeMillis());
//        Date f = new Date(System.currentTimeMillis());
//        Promo p = new Promo ( "linkPromo","tituloPromo", "descripcionPromo",  fi, ff, f, "1@1");
//        cp.setNuevaPromo(p);
//        System.out.println(cp.getNuevaPromo().getFechaInicioSQL());
//        System.out.println(cp.getNuevaPromo().getFechaPublicacionSQL());
//        System.out.println(cp.getNuevaPromo().getFechaFinSQL());
//        cp.guardarPromo("1@1");
//        sp.insert(p);
    }
    
}
