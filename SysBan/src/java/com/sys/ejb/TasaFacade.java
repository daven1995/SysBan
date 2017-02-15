/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sys.ejb;

import com.sys.model.Tasa;
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
public class TasaFacade extends AbstractFacade<Tasa> implements TasaFacadeLocal {

    @PersistenceContext(unitName = "SysBan3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TasaFacade() {
        super(Tasa.class);
    }
    
    @Override
    public Tasa buscarInteres(int plazo, float monto) throws Exception{
        Tasa tasa = null;
        String consulta;
        try {
            consulta = "FROM Tasa t WHERE t.tiempo= ?1 AND t.montoMinimo<?2 AND t.montoMaximo>?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, plazo);
            query.setParameter(2, monto);

            List<Tasa> lista = query.getResultList();
            if (!lista.isEmpty()) {
                tasa = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }       
        return tasa;
    }
    
}
