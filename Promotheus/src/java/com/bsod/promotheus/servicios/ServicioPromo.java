/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsod.promotheus.servicios;

import com.bsod.promotheus.usuario.Promo;
import static com.sun.mail.imap.protocol.INTERNALDATE.format;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Asus
 */

@ManagedBean (name = "ServicioPromo")
@ViewScoped
@SessionScoped
public class ServicioPromo extends Servicio implements InterfaceDAO {

    @Override
    public Object select(Object queBuscamos, Object queColumna, Object queValor) {
        String returnSelect = "";
        ResultSet rs = null;
        Statement stmt = null;
        try {
            //STEP 3: Execute a query
            super.conectar();
            System.out.println("Creando statement...");
            stmt = conn.createStatement();
            String sql;

            //hacemos el select con lo que buscamos, de cual columna y cual valor de la columna
            sql = "SELECT " + queBuscamos + " FROM promo WHERE " + queColumna + " = ?;";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, queValor.toString());
            rs = preparedStatement.executeQuery();

            //STEP 3.1: Extract data from result set
            if (rs.next()) {
                //Retrieve by column name
                returnSelect = rs.getString(queBuscamos.toString());
            } else {//si no encuentra a un usuario con los parametros especificados, va a retornar un un String avisando que no se encontro el usuario
                return "noPromoFound";
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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

    @Override
    public void insert(Object objeto) {
        try {
            //STEP 3: Execute a query
            super.conectar();

            System.out.println("Insertando valores...");
            String sql;
            sql = "INSERT INTO Promo (tituloPromo, descripcionPromo, linkPromo, fechaPublicacion, fechaInicio, fechaFin, Usuario_CorreoUsuario, Categoria_nombreCategoriaPromo) values (?,?,?,?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, ((Promo) objeto).getTituloPromo());
            preparedStatement.setString(2, ((Promo) objeto).getDescripcionPromo());
            preparedStatement.setString(3, ((Promo) objeto).getLinkPromo());
            //passing current date            
            preparedStatement.setDate(4, ((Promo) objeto).getFechaPublicacionSQL());

            //passing fechaInicio
            preparedStatement.setDate(5, ((Promo) objeto).getFechaInicioSQL());
            //passing fechaFin
            preparedStatement.setDate(6, ((Promo) objeto).getFechaFinSQL());
            preparedStatement.setString(7, ((Promo) objeto).getCorreoUsuario());
            preparedStatement.setString(8, ((Promo) objeto).getCategoria());
            System.out.println(((Promo) objeto).getCategoria());
            System.out.println("test");
            //EXECUTE!
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
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
        try {
            super.conectar();
            System.out.println("Actualizando valores...");
            String sql = "UPDATE promo SET " + queColumnaActualizamos + " = ? WHERE " + queColuma + " = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString(1, queInsertamos.toString());
            preparedStmt.setString(2, queValor.toString());
            preparedStmt.executeUpdate();

        } catch (Exception e) {
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
    public void delete(Object queColumna, Object queValor) {
        try {
            super.conectar();
            System.out.println("Borrando valores...");
            String sql = "DELETE FROM usuario WHERE " + queColumna + " = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString(1, queValor.toString());
            preparedStmt.execute();

        } catch (Exception e) {
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
    public ArrayList<Object> selectAll(Object queColumna, Object queValor) {
       ArrayList<Object> listaPromo= new ArrayList<>();
        ResultSet rs = null;
        Statement stmt=null;
        try{
            //STEP 3: Execute a query
            super.conectar();
            System.out.println("Creando statement...");
            stmt=conn.createStatement();
            String sql;
            
            //hacemos el select con lo que buscamos, de cual columna y cual valor de la columna
            sql="SELECT * FROM Promo WHERE "+queColumna+" = ?;";
            
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, queValor.toString());
            rs=preparedStatement.executeQuery(); 
            
            //STEP 3.1: Extract data from result set
            if(rs.next()){
                //Retrieve by column name
                listaPromo.add(rs.getString("tituloPromo"));
                listaPromo.add(rs.getString("descripcionPromo"));
                listaPromo.add(rs.getString("linkPromo"));
                listaPromo.add(rs.getDate("fechaPublicacion"));
                listaPromo.add(rs.getDate("fechaInicio"));
                listaPromo.add(rs.getDate("fechaFin"));
                listaPromo.add(rs.getString("Usuario_correoUsuario"));
            }else{//si no encuentra a un usuario con los parametros especificados, va a retornar un un String avisando que no se encontro el usuario
                listaPromo.add("noUserFound");
            return listaPromo;
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
        return listaPromo;
    }
    public ArrayList<Promo> selectAllPromos() {
       ArrayList<Promo> listaPromo= new ArrayList<>();
        ResultSet rs = null;
        Statement stmt=null;
        try{
            //STEP 3: Execute a query
            super.conectar();
            System.out.println("Creando statement...");
            stmt=conn.createStatement();
            String sql;
            
            //hacemos el select con lo que buscamos, de cual columna y cual valor de la columna
            sql="SELECT * FROM Promo";
            
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            rs=preparedStatement.executeQuery(); 
            
            while(rs.next()){
                //Retrieve by column name
                Promo promo = new Promo();
                promo.setId(rs.getInt("idPromo"));
                promo.setTituloPromo(rs.getString("tituloPromo"));
                promo.setDescripcionPromo(rs.getString("descripcionPromo"));
                promo.setLinkPromo(rs.getString("linkPromo"));
                promo.setFechaPublicacion(rs.getDate("fechaPublicacion"));
                promo.setFechaInicio(rs.getDate("fechaInicio"));
                promo.setFechaFin(rs.getDate("fechaFin"));
                promo.setCorreoUsuario(rs.getString("Usuario_correoUsuario"));
                System.out.println("Imprimir nombre promo");
                System.out.println("NOMBRE PROMO: "+promo.getTituloPromo());
                listaPromo.add(promo);
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
        return listaPromo;
    }
}
