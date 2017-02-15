/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sys.ejb;

import com.sys.model.Usuario;
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
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "SysBan3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    @Override
    public Usuario iniciarSesion(Usuario us) throws Exception{
        Usuario usuario = null;
        String consulta;
        try {
            consulta = "FROM Usuario u WHERE u.tipo= ?1 and u.cedula = ?2 and u.password = ?3";
            Query query = em.createQuery(consulta);
            query.setParameter(1, us.getTipo());
            query.setParameter(2, us.getCedula());
            query.setParameter(3, us.getPassword());

            List<Usuario> lista = query.getResultList();
            if (!lista.isEmpty()) {
                usuario = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }       
        return usuario;
    }
    
}
