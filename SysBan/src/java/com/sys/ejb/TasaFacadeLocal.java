/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sys.ejb;

import com.sys.model.Tasa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DANIEL
 */
@Local
public interface TasaFacadeLocal {

    void create(Tasa tasa);

    void edit(Tasa tasa);

    void remove(Tasa tasa);

    Tasa find(Object id);

    List<Tasa> findAll();

    List<Tasa> findRange(int[] range);

    int count();
    
    Tasa buscarInteres(int plazo, float monto) throws Exception;
}
