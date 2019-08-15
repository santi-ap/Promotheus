/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.bsod.promotheus.controladores.ControllerCategoria;
import com.bsod.promotheus.servicios.ServicioCategoria;
import com.bsod.promotheus.controladores.ControllerCategoria;
import com.bsod.promotheus.controladores.ControllerPromo;
import com.bsod.promotheus.servicios.DataGridViewUserPromo;
import com.bsod.promotheus.servicios.ServicioPromo;
import java.util.ArrayList;

/**
 *
 * @author coded
 */
public class TesterDavid {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServicioCategoria sc = new ServicioCategoria();
        ControllerCategoria cc = new ControllerCategoria();
        ServicioPromo serP = new ServicioPromo();
        ControllerPromo cp = new ControllerPromo();
        DataGridViewUserPromo dg = new DataGridViewUserPromo();
        ServicioPromo service = new ServicioPromo();

//        cp.setServicioPromo(serP);
//        cc.setServicioCategoria(sc);
//
//        ArrayList<String> cat = new ArrayList<>();
//        cat = cc.getServicioCategoria().selectNombreCategoria();
//        System.out.println(cat);
//        System.out.println("\n");
//        System.out.println(sc.select("nombreCategoria", "nombreCategoria", " Electronicos"));
       // System.out.println(service.selectAll("Usuario_correoUsuario", "davidtest@test"));

//        dg.init();
//        dg.setUserPromo();
//        System.out.println(dg.getUserPromo());

        System.out.println(service.selectAllTypePromo("Usuario_correoUsuario", "davidtest@test"));
    }

}
