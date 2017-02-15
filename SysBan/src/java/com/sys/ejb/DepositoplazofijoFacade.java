/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sys.ejb;

import com.sys.model.Depositoplazofijo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author DANIEL
 */
@Stateless
public class DepositoplazofijoFacade extends AbstractFacade<Depositoplazofijo> implements DepositoplazofijoFacadeLocal {

    @PersistenceContext(unitName = "SysBan3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepositoplazofijoFacade() {
        super(Depositoplazofijo.class);
    }
    
    @Override
    public List<Depositoplazofijo> buscarImagen() throws Exception{
        //Depositoplazofijo depos = null;
        String consulta;
        List<Depositoplazofijo> lista;
        
        try {
            consulta = "FROM depositoplazofijo d WHERE d.estado= ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, "I");
            
            lista = query.getResultList();
            /*if (!lista.isEmpty()) {
                depos = lista.get(0);
            }*/
        } catch (Exception e) {
            throw e;
        }       
        return lista;
    }
    
}
