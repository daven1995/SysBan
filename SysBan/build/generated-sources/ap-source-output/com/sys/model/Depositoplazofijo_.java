package com.sys.model;

import com.sys.model.Transacciondpf;
import com.sys.model.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-13T15:34:02")
@StaticMetamodel(Depositoplazofijo.class)
public class Depositoplazofijo_ { 

    public static volatile SingularAttribute<Depositoplazofijo, Date> fecha;
    public static volatile SingularAttribute<Depositoplazofijo, String> estado;
    public static volatile SingularAttribute<Depositoplazofijo, Integer> tiempo;
    public static volatile SingularAttribute<Depositoplazofijo, Usuario> idUsuario;
    public static volatile SingularAttribute<Depositoplazofijo, byte[]> imagen;
    public static volatile SingularAttribute<Depositoplazofijo, Float> deposito;
    public static volatile ListAttribute<Depositoplazofijo, Transacciondpf> transacciondpfList;
    public static volatile SingularAttribute<Depositoplazofijo, Integer> idDeposito;
    public static volatile SingularAttribute<Depositoplazofijo, Float> tasaInteres;
    public static volatile SingularAttribute<Depositoplazofijo, Float> valorFinal;

}