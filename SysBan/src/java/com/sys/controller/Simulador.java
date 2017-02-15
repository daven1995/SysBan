
package com.sys.controller;

import com.sys.ejb.TasaFacadeLocal;
import com.sys.model.Tasa;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "simulador")
@RequestScoped
public class Simulador implements Serializable{
    
    @EJB
    private TasaFacadeLocal tasaFacade;
    
    private float monto;
    private int plazo;
    private double montoTotal;
    private String tipoDeposito;

    public Simulador() {
    }
    
    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getTipoDeposito() {
        return tipoDeposito;
    }

    public void setTipoDeposito(String tipoDeposito) {
        this.tipoDeposito = tipoDeposito;
    }
    
    
    public float buscarInt(){
        Tasa tas;
        float interes=0;
        try{
            tas = tasaFacade.buscarInteres(plazo, monto);
            interes=tas.getInteres();
        } catch (Exception e) {
        }
        return interes;
    }
    
    public void calculoPlazoFijo(){
        Tasa tas;
        
        try{
            tas = tasaFacade.buscarInteres(plazo, monto);
            double n=(plazo*30);
            montoTotal=redondearDecimales(monto*(1+((tas.getInteres()/36000)*n)),2);
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
       } 
    }
    
    public static double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
        return resultado;
    }
}
    
    

