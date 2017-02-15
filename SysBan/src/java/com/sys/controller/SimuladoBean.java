package com.sys.controller;

import com.sys.ejb.CuentaFacadeLocal;
import com.sys.ejb.DepositoplazofijoFacadeLocal;
import com.sys.ejb.TasaFacadeLocal;
import com.sys.model.Cuenta;
import com.sys.model.Depositoplazofijo;
import com.sys.model.Tasa;
import com.sys.model.Usuario;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.model.UploadedFile;


@Named(value = "simuladoBean")
@ViewScoped
public class SimuladoBean implements Serializable {

    @EJB
    private CuentaFacadeLocal cuentaFacade;

    @EJB
    private DepositoplazofijoFacadeLocal depositoplazofijoFacade;

    @EJB
    private TasaFacadeLocal tasaFacade;
    
    Depositoplazofijo dep;
    Usuario us;
    Cuenta cuenta;

    public Depositoplazofijo getDep() {
        return dep;
    }

    public void setDep(Depositoplazofijo dep) {
        this.dep = dep;
    }

    public Usuario getUs() {
        return us;
    }

    public void setUs(Usuario us) {
        this.us = us;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
    
    @PostConstruct
    public void init() {
        dep = new Depositoplazofijo();
        us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        cuenta=cuentaFacade.find(us.getIdUsuario());
        numeroCuenta=cuenta.getNumero();
        saldoActual=cuenta.getSaldo();
    }
    
    //DATOS DEPOSITO
    private float monto;
    private int plazo;
    private double montoTotal;
    private String tipoDeposito;
    private UploadedFile file;
    
    //DATOS CUENTA
    private int numeroCuenta;
    private float saldoActual;
    private float saldoDes;
   
    
    public SimuladoBean() {
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

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public float getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(float saldoActual) {
        this.saldoActual = saldoActual;
    }

    public float getSaldoDes() {
        return saldoDes;
    }

    public void setSaldoDes(float saldoDes) {
        this.saldoDes = saldoDes;
    }

    
    public float buscarInt() {
        Tasa tas;
        float interes = 0;
        try {
            tas = tasaFacade.buscarInteres(plazo, monto);
            interes = tas.getInteres();
        } catch (Exception e) {
        }
        return interes;
    }

    public void calculoPlazoFijo() {
        Tasa tas;

        try {
            tas = tasaFacade.buscarInteres(plazo, monto);
            double n = (plazo * 30);
            montoTotal = redondearDecimales(monto * (1 + ((tas.getInteres() / 36000) * n)), 2);
            saldoDes=saldoActual-monto;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        }
    }

    public static double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado = (resultado - parteEntera) * Math.pow(10, numeroDecimales);
        resultado = Math.round(resultado);
        resultado = (resultado / Math.pow(10, numeroDecimales)) + parteEntera;
        return resultado;
    }

    public static byte[] convertirTobyteArray(InputStream is) throws IOException {

        byte[] bytes = null;
        if (is != null) {
            bytes = new byte[is.available()];
            is.read(bytes);
        }
        return bytes;
    }

    public void crearDepositoInactivo() {
        tipoDeposito="I";
        try{
        //if(file.getInputstream()!= null) {
            
            //Depositoplazofijo dep = new Depositoplazofijo();
            //Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");

            dep.setIdUsuario(us);
            dep.setTasaInteres(buscarInt());
            dep.setTiempo(plazo);
            dep.setEstado(tipoDeposito);
            Float mt = new Float(montoTotal);
            dep.setValorFinal(mt);
            dep.setDeposito(monto);
            dep.setImagen(convertirTobyteArray(file.getInputstream()));

            depositoplazofijoFacade.create(dep);
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " fue subido.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Deposito Creado"));
        //}
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        }
    }
    
    
    public void crearDepositoAc(){
        tipoDeposito="A";
        try{
        //Cuenta cuenta;
        //Depositoplazofijo dep = new Depositoplazofijo();
        //Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        
        //CUENTA
        //cuenta=cuentaFacade.find(us.getIdUsuario());
        saldoDes=saldoActual-monto;
        cuenta.setSaldo(saldoDes);
        cuentaFacade.edit(cuenta);
        
        //DEPOSITO
        dep.setIdUsuario(us);
        dep.setTasaInteres(buscarInt());
        dep.setTiempo(plazo);
        dep.setEstado(tipoDeposito);
        Float mt = new Float(montoTotal);
        dep.setValorFinal(mt);
        dep.setDeposito(monto);
        dep.setImagen(convertirTobyteArray(file.getInputstream()));
        depositoplazofijoFacade.create(dep);
        
        //System.out.println(""+cuenta.getNumero());
        //numeroCuenta=cuenta.getNumero();
        //saldoActual=cuenta.getSaldo();
        
        
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Depsito Creado"));

       } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
       }
        
    }

}
