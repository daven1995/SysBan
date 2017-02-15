/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sys.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DANIEL
 */
@Entity
@Table(name = "transaccioncuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaccioncuenta.findAll", query = "SELECT t FROM Transaccioncuenta t")
    , @NamedQuery(name = "Transaccioncuenta.findByIdtransaccionCuenta", query = "SELECT t FROM Transaccioncuenta t WHERE t.idtransaccionCuenta = :idtransaccionCuenta")
    , @NamedQuery(name = "Transaccioncuenta.findByValor", query = "SELECT t FROM Transaccioncuenta t WHERE t.valor = :valor")
    , @NamedQuery(name = "Transaccioncuenta.findBySaldoAnterior", query = "SELECT t FROM Transaccioncuenta t WHERE t.saldoAnterior = :saldoAnterior")
    , @NamedQuery(name = "Transaccioncuenta.findBySaldoActual", query = "SELECT t FROM Transaccioncuenta t WHERE t.saldoActual = :saldoActual")
    , @NamedQuery(name = "Transaccioncuenta.findByFecha", query = "SELECT t FROM Transaccioncuenta t WHERE t.fecha = :fecha")
    , @NamedQuery(name = "Transaccioncuenta.findByTipoTranCuenta", query = "SELECT t FROM Transaccioncuenta t WHERE t.tipoTranCuenta = :tipoTranCuenta")})
public class Transaccioncuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_transaccionCuenta")
    private Integer idtransaccionCuenta;
    @Column(name = "valor")
    private Integer valor;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saldoAnterior")
    private Float saldoAnterior;
    @Column(name = "saldoActual")
    private Float saldoActual;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 2)
    @Column(name = "tipoTranCuenta")
    private String tipoTranCuenta;
    @JoinColumn(name = "id_cuenta", referencedColumnName = "id_cuenta")
    @ManyToOne(optional = false)
    private Cuenta idCuenta;

    public Transaccioncuenta() {
    }

    public Transaccioncuenta(Integer idtransaccionCuenta) {
        this.idtransaccionCuenta = idtransaccionCuenta;
    }

    public Integer getIdtransaccionCuenta() {
        return idtransaccionCuenta;
    }

    public void setIdtransaccionCuenta(Integer idtransaccionCuenta) {
        this.idtransaccionCuenta = idtransaccionCuenta;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Float getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(Float saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public Float getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(Float saldoActual) {
        this.saldoActual = saldoActual;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoTranCuenta() {
        return tipoTranCuenta;
    }

    public void setTipoTranCuenta(String tipoTranCuenta) {
        this.tipoTranCuenta = tipoTranCuenta;
    }

    public Cuenta getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Cuenta idCuenta) {
        this.idCuenta = idCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtransaccionCuenta != null ? idtransaccionCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaccioncuenta)) {
            return false;
        }
        Transaccioncuenta other = (Transaccioncuenta) object;
        if ((this.idtransaccionCuenta == null && other.idtransaccionCuenta != null) || (this.idtransaccionCuenta != null && !this.idtransaccionCuenta.equals(other.idtransaccionCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sys.model.Transaccioncuenta[ idtransaccionCuenta=" + idtransaccionCuenta + " ]";
    }
    
}
