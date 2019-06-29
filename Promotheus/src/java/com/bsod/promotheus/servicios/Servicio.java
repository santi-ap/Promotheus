/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsod.promotheus.servicios;

import java.sql.Connection;

/**
 *
 * @author DacordMachine
 */
public abstract class Servicio {
    
    private String DBC_DRIVE = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://ulatina3.ceuol7o4t0su.us-east-2.rds.amazonaws.com:3306/AWS Test 1";
    private String USER = "promouser";
    private String PASS = "123456";
    private Connection conn = null;
    
    private void conectar(){
        
    }
    
    private void desconectar(){
        
    }
    
}
