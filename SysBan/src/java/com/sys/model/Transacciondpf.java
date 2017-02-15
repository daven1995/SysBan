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
@Table(name = "transacciondpf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transacciondpf.findAll", query = "SELECT t FROM Transacciondpf t")
    , @NamedQuery(name = "Transacciondpf.findByIdTransacciondpf", query = "SELECT t FROM Transacciondpf t WHERE t.idTransacciondpf = :idTransacciondpf")
    , @NamedQuery(name = "Transacciondpf.findByFecha", query = "SELECT t FROM Transacciondpf t WHERE t.fecha = :fecha")
    , @NamedQuery(name = "Transacciondpf.findByTipoTrandpf", query = "SELECT t FROM Transacciondpf t WHERE t.tipoTrandpf = :tipoTrandpf")})
public class Transacciondpf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_transacciondpf")
    private Integer idTransacciondpf;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 2)
    @Column(name = "tipoTrandpf")
    private String tipoTrandpf;
    @JoinColumn(name = "id_deposito", referencedColumnName = "id_deposito")
    @ManyToOne(optional = false)
    private Depositoplazofijo idDeposito;

    public Transacciondpf() {
    }

    public Transacciondpf(Integer idTransacciondpf) {
        this.idTransacciondpf = idTransacciondpf;
    }

    public Integer getIdTransacciondpf() {
        return idTransacciondpf;
    }

    public void setIdTransacciondpf(Integer idTransacciondpf) {
        this.idTransacciondpf = idTransacciondpf;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoTrandpf() {
        return tipoTrandpf;
    }

    public void setTipoTrandpf(String tipoTrandpf) {
        this.tipoTrandpf = tipoTrandpf;
    }

    public Depositoplazofijo getIdDeposito() {
        return idDeposito;
    }

    public void setIdDeposito(Depositoplazofijo idDeposito) {
        this.idDeposito = idDeposito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransacciondpf != null ? idTransacciondpf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transacciondpf)) {
            return false;
        }
        Transacciondpf other = (Transacciondpf) object;
        if ((this.idTransacciondpf == null && other.idTransacciondpf != null) || (this.idTransacciondpf != null && !this.idTransacciondpf.equals(other.idTransacciondpf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sys.model.Transacciondpf[ idTransacciondpf=" + idTransacciondpf + " ]";
    }
    
}
