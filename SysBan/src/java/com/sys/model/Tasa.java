/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sys.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DANIEL
 */
@Entity
@Table(name = "tasa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tasa.findAll", query = "SELECT t FROM Tasa t")
    , @NamedQuery(name = "Tasa.findByIdTasa", query = "SELECT t FROM Tasa t WHERE t.idTasa = :idTasa")
    , @NamedQuery(name = "Tasa.findByMontoMinimo", query = "SELECT t FROM Tasa t WHERE t.montoMinimo = :montoMinimo")
    , @NamedQuery(name = "Tasa.findByMontoMaximo", query = "SELECT t FROM Tasa t WHERE t.montoMaximo = :montoMaximo")
    , @NamedQuery(name = "Tasa.findByTiempo", query = "SELECT t FROM Tasa t WHERE t.tiempo = :tiempo")
    , @NamedQuery(name = "Tasa.findByInteres", query = "SELECT t FROM Tasa t WHERE t.interes = :interes")})
public class Tasa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tasa")
    private Integer idTasa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montoMinimo")
    private float montoMinimo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montoMaximo")
    private float montoMaximo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiempo")
    private int tiempo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "interes")
    private float interes;

    public Tasa() {
    }

    public Tasa(Integer idTasa) {
        this.idTasa = idTasa;
    }

    public Tasa(Integer idTasa, float montoMinimo, float montoMaximo, int tiempo, float interes) {
        this.idTasa = idTasa;
        this.montoMinimo = montoMinimo;
        this.montoMaximo = montoMaximo;
        this.tiempo = tiempo;
        this.interes = interes;
    }

    public Integer getIdTasa() {
        return idTasa;
    }

    public void setIdTasa(Integer idTasa) {
        this.idTasa = idTasa;
    }

    public float getMontoMinimo() {
        return montoMinimo;
    }

    public void setMontoMinimo(float montoMinimo) {
        this.montoMinimo = montoMinimo;
    }

    public float getMontoMaximo() {
        return montoMaximo;
    }

    public void setMontoMaximo(float montoMaximo) {
        this.montoMaximo = montoMaximo;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTasa != null ? idTasa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tasa)) {
            return false;
        }
        Tasa other = (Tasa) object;
        if ((this.idTasa == null && other.idTasa != null) || (this.idTasa != null && !this.idTasa.equals(other.idTasa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sys.model.Tasa[ idTasa=" + idTasa + " ]";
    }
    
}
