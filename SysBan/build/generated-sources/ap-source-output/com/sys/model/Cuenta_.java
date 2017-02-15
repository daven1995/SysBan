package com.sys.model;

import com.sys.model.Transaccioncuenta;
import com.sys.model.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-12T16:46:34")
@StaticMetamodel(Cuenta.class)
public class Cuenta_ { 

    public static volatile SingularAttribute<Cuenta, Integer> numero;
    public static volatile SingularAttribute<Cuenta, Usuario> idUsuario;
    public static volatile SingularAttribute<Cuenta, Float> saldo;
    public static volatile SingularAttribute<Cuenta, Integer> idCuenta;
    public static volatile ListAttribute<Cuenta, Transaccioncuenta> transaccioncuentaList;

}