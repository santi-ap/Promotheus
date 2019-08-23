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
import javax.faces.bean.SessionScoped;

/**
 *
 * @author DacordMachine
 */
@SessionScoped
public class ServicioUsuario_has_Favoritos extends Servicio implements InterfaceDAO {

    @Override
    public Object select(Object queBuscamos, Object queColumna, Object queValor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    /**
     * 
     * @param objeto a string composed by a,b where a is the correo of the usuario and b is the promo id
     */
    @Override
    public void insert(Object objeto) {
        try {
            //vamos a tomar lo que hay que insertar como un String donde los IDs se separan por comas. Por ejemplo "12,5"
/*quitenifty*/String[] temp = ((String)objeto).split(","); //aqui se separan los dos IDs por la coma en un array y queda ["12","5"]
            String correoUsuario = temp[0];//aqui se agarra el primer ID
            int idPromo = Integer.parseInt(temp[1]);//aqui se agarra el segundo ID
            //STEP 3: Execute a querey
            super.conectar();

            String sql;
            sql = "INSERT INTO usuario_has_Favoritos values (?,?);";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, correoUsuario);
            preparedStatement.setInt(2, idPromo);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                super.desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
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
                Promo promoNueva = new Promo(rs.getString(4), rs.getString(2), rs.getString(3), rs.getDate(6), rs.getDate(7), rs.getDate(5), rs.getString(8));
                promoNueva.setId(rs.getInt(1));
                promosFavoritas.add(promoNueva);

            }

        } catch (SQLException e) {

            e.getErrorCode();

        }
        return promosFavoritas;
    }
    
    public void deletePromoFavorita(int promoId, String correoUsuario){
        
        this.conectar();
        
        try {
            
            PreparedStatement stmt = conn.prepareStatement("delete" +
            " from usuario_has_Favoritos" +
            " where promo_idPromo = "+promoId+" and usuario_correoUsuario = '"+correoUsuario+"';");
            
            stmt.execute();
            
        } catch(SQLException e){
            
            e.getErrorCode();
            
        }
        
    }

}
