/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsod.promotheus.servicios;

import com.bsod.promotheus.usuario.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class ServicioPromo extends Servicio implements InterfaceDAO {

    @Override
    public Object select(Object queBuscamos, Object queColumna, Object queValor) {
        String returnSelect="";
        ResultSet rs = null;
        Statement stmt=null;
        try{
            //STEP 3: Execute a query
            super.conectar();
            System.out.println("Creando statement...");
            stmt=conn.createStatement();
            String sql;
            
            //hacemos el select con lo que buscamos, de cual columna y cual valor de la columna
            sql="SELECT "+queBuscamos+" FROM usuario WHERE "+queColumna+" = ?;";
            
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, queValor.toString());
            rs=preparedStatement.executeQuery(); 
            
            //STEP 3.1: Extract data from result set
            if(rs.next()){
                //Retrieve by column name
                returnSelect = rs.getString(queBuscamos.toString());
            }else{//si no encuentra a un usuario con los parametros especificados, va a retornar un un String avisando que no se encontro el usuario
            return "noUserFound";
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                rs.close();
                stmt.close();
                super.desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        //retorna lo que se selecciono
        return returnSelect;    }

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
    
}
