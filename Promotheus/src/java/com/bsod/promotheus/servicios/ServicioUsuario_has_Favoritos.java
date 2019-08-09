/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsod.promotheus.servicios;

import com.bsod.promotheus.usuario.Promo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author DacordMachine
 */
@ManagedBean (name="ServicioUsuario_has_Favoritos")
@ViewScoped
@SessionScoped
public class ServicioUsuario_has_Favoritos extends Servicio implements InterfaceDAO {

    @Override
    public Object select(Object queBuscamos, Object queColumna, Object queValor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Para Tommasso
    @Override
    public void insert(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Object queColumnaActualizamos, Object queInsertamos, Object queColuma, Object queValor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object queColumna, Object queValor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Object> selectAll(Object queColumna, Object queValor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //En progreso
    public ArrayList<Promo> selectPromosFavoritas(String correo) {

        ArrayList<Promo> promosFavoritas = new ArrayList();

        this.conectar();

        try {

            PreparedStatement ps = conn.prepareStatement("select idPromo, tituloPromo, descripcionPromo, linkPromo, fechaPublicacion, fechaInicio, fechaFin, correoUsuario "
                    + "from Promo p, usuario_has_Favoritos up , usuario u "
                    + "where u.correoUsuario = '" + correo + "' and up.usuario_correoUsuario = u.correoUsuario and up.promo_idPromo = p.idPromo");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                //public Promo(String linkPromo, String tituloPromo, String descripcionPromo, java.util.Date fechaInicio, java.util.Date fechaFin, java.util.Date fechaPublicacion, String correoUsuario)
                promosFavoritas.add(new Promo(rs.getString(4), rs.getString(2), rs.getString(3), rs.getDate(6), rs.getDate(7), rs.getDate(5), rs.getString(8)));

            }

        } catch (SQLException e) {

            e.getErrorCode();

        }
        return promosFavoritas;
    }

}
