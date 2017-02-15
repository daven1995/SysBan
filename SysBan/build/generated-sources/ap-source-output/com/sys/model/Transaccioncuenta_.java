package com.sys.model;

import com.sys.model.Cuenta;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-12T16:46:34")
@StaticMetamodel(Transaccioncuenta.class)
public class Transaccioncuenta_ { 

    public static volatile SingularAttribute<Transaccioncuenta, Date> fecha;
    public static volatile SingularAttribute<Transaccioncuenta, String> tipoTranCuenta;
    public static volatile SingularAttribute<Transaccioncuenta, Float> saldoAnterior;
    public static volatile SingularAttribute<Transaccioncuenta, Integer> valor;
    public static volatile SingularAttribute<Transaccioncuenta, Integer> idtransaccionCuenta;
    public static volatile SingularAttribute<Transaccioncuenta, Float> saldoActual;
    public static volatile SingularAttribute<Transaccioncuenta, Cuenta> idCuenta;

}