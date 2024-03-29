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
 * @author DacordMachine
 */
public class ServicioUsuario extends Servicio implements InterfaceDAO{
    
    /**
     * SELECT queBuscamos FROM usuario WHERE queColumna = queValor;
     * @param queBuscamos 
     * @param queColumna
     * @param queValor
     * @return lo que estamos buscando como String
     */
    @Override//select, toma como parametros lo que estamos buscando, la columna donde especificamos el valor de condicion y que valor debe tener la columna 
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
        return returnSelect;
    }
    
    /**
     * INSERT INTO usuario (nombreUsuario, correoUsuario, passUsuario) values (((Usuario)objeto).getNombreUsuario(),((Usuario)objeto).getCorreoUsuario(),((Usuario)objeto).getPassUsuario()));
     * @param objeto 
     */
    @Override
    public void insert(Object objeto) {
        try{
            //STEP 3: Execute a querey
            super.conectar();
            
            System.out.println("Insertando valores...");
            String sql;
            sql="INSERT INTO usuario (nombreUsuario, correoUsuario, passUsuario) values (?,?,?);";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, ((Usuario)objeto).getNombreUsuario() );
            preparedStatement.setString(2, ((Usuario)objeto).getCorreoUsuario());
            preparedStatement.setString(3, ((Usuario)objeto).getPassUsuario());
            preparedStatement.executeUpdate(); 
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                super.desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    /**
     * UPDATE usuario SET queColumnaActualizamos = queInsertamos.toString() WHERE queColuma = queValor.toString();
     * @param queColumnaActualizamos
     * @param queInsertamos
     * @param queColuma
     * @param queValor 
     */
    @Override
    public void update(Object queColumnaActualizamos, Object queInsertamos, Object queColuma, Object queValor) {
        try{
            super.conectar();
            System.out.println("Actualizando valores...");
            String sql = "UPDATE usuario SET "+queColumnaActualizamos+" = ? WHERE "+queColuma+" = ?;";
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString(1, queInsertamos.toString());
            preparedStmt.setString(2, queValor.toString());
            preparedStmt.executeUpdate(); 
           
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                super.desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    /**
     * DELETE FROM usuario WHERE queColumna = queValor.toString();
     * @param queColumna
     * @param queValor 
     */
    @Override
    public void delete(Object queColumna, Object queValor) {
        try{
            super.conectar();
            System.out.println("Borrando valores...");
            String sql = "DELETE FROM usuario WHERE "+queColumna+" = ?;";
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString(1, queValor.toString());
            preparedStmt.execute(); 
           
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                super.desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }
    
    /**
     * SELECT * FROM usuario WHERE queColumna = queValor.toString();
     * @param queColumna
     * @param queValor
     * @return 
     */
    @Override
    public ArrayList<Object> selectAll(Object queColumna, Object queValor) {
        ArrayList<Object> listaDatosUsuario= new ArrayList<>();
        ResultSet rs = null;
        Statement stmt=null;
        try{
            //STEP 3: Execute a query
            super.conectar();
            System.out.println("Creando statement...");
            stmt=conn.createStatement();
            String sql;
            
            //hacemos el select con lo que buscamos, de cual columna y cual valor de la columna
            sql="SELECT * FROM usuario WHERE "+queColumna+" = ?;";
            
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, queValor.toString());
            rs=preparedStatement.executeQuery(); 
            
            //STEP 3.1: Extract data from result set
            if(rs.next()){
                //Retrieve by column name
                listaDatosUsuario.add(rs.getString("correoUsuario"));
                listaDatosUsuario.add(rs.getString("nombreUsuario"));
                listaDatosUsuario.add(rs.getString("passUsuario"));
            }else{//si no encuentra a un usuario con los parametros especificados, va a retornar un un String avisando que no se encontro el usuario
                listaDatosUsuario.add("noUserFound");
            return listaDatosUsuario;
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
        return listaDatosUsuario;
    }
}
