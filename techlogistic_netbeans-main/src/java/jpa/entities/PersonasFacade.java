/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author techlogistic2
 */
@Stateless
public class PersonasFacade extends AbstractFacade<Personas> {

    @PersistenceContext(unitName = "techlogistic2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonasFacade() {
        super(Personas.class);
    }
    
    public Personas acceder(Personas pe)
    {
        Personas persona = null;
        String consulta="";
        try
        {
            consulta="SELECT p FROM Personas p WHERE p.correo = ?1 and p.password = ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, pe.getCorreo());
            query.setParameter(2, pe.getPassword());
            List<Personas> lista = query.getResultList();
            if(!lista.isEmpty())
            {
                persona=lista.get(0);
            }
        }
        catch (Exception ex)
        {
            throw ex;
        }
        return persona;
    }
    
    
}
