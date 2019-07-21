/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsod.promotheus.servicios;

import com.bsod.promotheus.usuario.Promo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Asus
 */

public class ServicioCategoria extends Servicio implements InterfaceDAO {
    

    @Override
    public Object select(Object queBuscamos, Object queColumna, Object queValor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
    /**
     * Metodo para conseguir la lista de categorias de la base de datos
     * @return lista de strings que contiene las categorias 
     */
    public ArrayList<String> selectNombreCategoria(){// GETS LIST OF CATEGORYS FROM THE DATA BASE
        
        ArrayList<String> listaCategoria= new ArrayList<>();
        ResultSet rs = null;
        Statement stmt=null;
        try{
            //STEP 3: Execute a querey
            super.conectar();
            System.out.println("Creando statement...");
            stmt=conn.createStatement();
            String sql;
            sql="SELECT nombreCategoria FROM Categoria;";
            rs=stmt.executeQuery(sql);
            //STEP 3.1: Extract data from result set
            while (rs.next()){
                //Retrieve by column name
                String nombreCategoria = rs.getString("nombreCategoria");
                System.out.println(nombreCategoria);
                //Display values
             //   System.out.println("ID: "+id+", Nombre: " +nombre);
                listaCategoria.add(nombreCategoria);
                
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
        return listaCategoria;
    }
    
}
