package com.sys.model;

import com.sys.model.Depositoplazofijo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-12T16:46:34")
@StaticMetamodel(Transacciondpf.class)
public class Transacciondpf_ { 

    public static volatile SingularAttribute<Transacciondpf, Date> fecha;
    public static volatile SingularAttribute<Transacciondpf, Integer> idTransacciondpf;
    public static volatile SingularAttribute<Transacciondpf, String> tipoTrandpf;
    public static volatile SingularAttribute<Transacciondpf, Depositoplazofijo> idDeposito;

}