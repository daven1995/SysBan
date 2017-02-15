
package com.sys.controller;

import com.sys.ejb.DepositoplazofijoFacadeLocal;
import com.sys.model.Depositoplazofijo;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;


@Named(value = "verDeposBean")
@RequestScoped
public class VerDeposBean {

    @EJB
    private DepositoplazofijoFacadeLocal depositoplazofijoFacade;

    
    public VerDeposBean() {
    }
    
    public List<Depositoplazofijo> getDepositoplazofijos(){
        return depositoplazofijoFacade.findAll();
     }
    
    public String verEstado(String estado){
        String est;
        if(estado.equals("I")){
            est="INACTIVO";
        }else{
            est="ACTIVO";
        }
        return est;
    }
    
    public void verImagen(byte[] imagen){
        try{
        HttpServletResponse reponse= (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
        reponse.getOutputStream().write(imagen);
        reponse.getOutputStream().close();
        FacesContext.getCurrentInstance().responseComplete();
        
        }catch(Exception e){
        
        }
    }

    public void activarEstado(Integer id){
        Depositoplazofijo depos;
        depos = depositoplazofijoFacade.find(id);
        depos.setEstado("A");
        depositoplazofijoFacade.edit(depos); 
        EmailUtils email=new EmailUtils();
        email.enviarMensaje();
    }
    
    public void inactivarEstado(Integer id){
        Depositoplazofijo depos;
        depos = depositoplazofijoFacade.find(id);
        depos.setEstado("I");
        depositoplazofijoFacade.edit(depos);       
    }
}
