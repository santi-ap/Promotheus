/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsod.promotheus.controladores;

import com.bsod.promotheus.servicios.ServicioCategoria;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author coded
 */
@FacesConverter(value = "categoriaConverter")
public class CategoriaConverter implements Converter {

    private static final long serialVersionUID = 1L;

    private ServicioCategoria servicioCategoria = new ServicioCategoria();

    public CategoriaConverter() {
        servicioCategoria = new ServicioCategoria();
    }

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component,
            String submittedValue) {
        if (submittedValue != null && submittedValue.trim().length() > 0) {
            try {
                return servicioCategoria.select("nombreCategoria", "nombreCategoria", submittedValue);
            } catch (Exception exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "No existe la categoria"));
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component,
            Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(servicioCategoria.selectNombreCategoria());
        }
    }
}
