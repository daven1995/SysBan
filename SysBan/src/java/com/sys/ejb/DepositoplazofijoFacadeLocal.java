/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sys.ejb;

import com.sys.model.Depositoplazofijo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DANIEL
 */
@Local
public interface DepositoplazofijoFacadeLocal {

    void create(Depositoplazofijo depositoplazofijo);

    void edit(Depositoplazofijo depositoplazofijo);

    void remove(Depositoplazofijo depositoplazofijo);

    Depositoplazofijo find(Object id);

    List<Depositoplazofijo> findAll();

    List<Depositoplazofijo> findRange(int[] range);

    int count();
    
    List<Depositoplazofijo> buscarImagen() throws Exception;
    
}
