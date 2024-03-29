/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsod.promotheus.servicios;

import java.util.ArrayList;

/**
 *
 * @author santialfonso
 */
public interface InterfaceDAO {
    /**
     * SELECT queBuscamos FROM Usuario WHERE queColumna = queValor;
     * el metodo select toma los siguientes parametros para especificar que va a seleccionar
     * @param queBuscamos
     * @param queColumna
     * @param queValor
     * @return 
     */
    public Object select(Object queBuscamos, Object queColumna, Object queValor);
    
    /**
     * Toma un objeto tipo usuario para tener todos los datos completos para hacer el insert
     * @param usuario 
     */
    public void insert(Object objeto);//Se toma una un usario como parametro
    
    /**
     * UPDATE Usuario SET queColumnaActualizamos = queInsertamos WHERE queColuma = queValor
     * @param queColumnaActualizamos
     * @param queInsertamos
     * @param queColuma
     * @param queValor 
     */
    public void update(Object queColumnaActualizamos, Object queInsertamos, Object queColuma, Object queValor);
    
    /**
     * DELETE FROM Usuario WHERE queColumna = queValor
     * @param queColumna
     * @param queValor 
     */
    public void delete(Object queColumna, Object queValor);
    
    /**
     * SELECT * FROM Usuario WHERE queColumna = queValor;
     * @param queColumna
     * @param queValor
     * @return 
     */
    public ArrayList<Object> selectAll(Object queColumna, Object queValor);
}
