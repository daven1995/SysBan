
package com.sys.ejb;

import com.sys.model.Depositoplazofijo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class DepositoplazofijoFacade extends AbstractFacade<Depositoplazofijo> implements DepositoplazofijoFacadeLocal {

    @PersistenceContext(unitName = "SysBanPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepositoplazofijoFacade() {
        super(Depositoplazofijo.class);
    }
    
}
