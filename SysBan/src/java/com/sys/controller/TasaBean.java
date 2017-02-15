/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sys.controller;

import com.sys.ejb.TasaFacadeLocal;
import com.sys.model.Tasa;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "tasaBean")
@RequestScoped
public class TasaBean implements Serializable{

    @EJB
    private TasaFacadeLocal tasaFacade;

    private int id_tasa;
    private int montoMaximo;
    private int montoMinimo;
    private int tiempo;
    private float interes;
    
    public TasaBean() {
    }
     
    public List<Tasa> getTasas(){
        return tasaFacade.findAll();
     }
    
    
     
    public String crear(){
         Tasa t= new Tasa();
         t.setMontoMinimo(montoMinimo);
         t.setMontoMaximo(montoMaximo);
         t.setTiempo(tiempo);
         t.setInteres(interes);
         tasaFacade.create(t);
         
         return "tasa";
     }

    public int getId_tasa() {
        return id_tasa;
    }

    public void setId_tasa(int id_tasa) {
        this.id_tasa = id_tasa;
    }

    public int getMontoMaximo() {
        return montoMaximo;
    }

    public void setMontoMaximo(int montoMaximo) {
        this.montoMaximo = montoMaximo;
    }

    public int getMontoMinimo() {
        return montoMinimo;
    }

    public void setMontoMinimo(int montoMinimo) {
        this.montoMinimo = montoMinimo;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public float getInteres() {
        return interes;
    }

    public void setInteres(float interes) {
        this.interes = interes;
    }
     
     
}
