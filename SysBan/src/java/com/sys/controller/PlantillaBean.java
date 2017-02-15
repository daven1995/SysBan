/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sys.controller;

import com.sys.model.Usuario;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author DANIEL
 */
@Named(value = "plantillaBean")
@ViewScoped
public class PlantillaBean implements Serializable{

    
    public PlantillaBean() {
    }
    
    public void verificarSesion() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("usuario");

            if (us == null) {
                context.getExternalContext().redirect("./../permisos.xhtml");
            }
        } catch (Exception e) {
            //log para guardar algun registro de un error
        }
    }
    
}
