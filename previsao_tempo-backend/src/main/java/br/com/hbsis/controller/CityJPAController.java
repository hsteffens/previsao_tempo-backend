package br.com.hbsis.controller;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.hbsis.persistencia.City;

/**
 * Controller responável pelas persistencias em uma cidade.
 * 
 * @author Hélinton P. Steffens
 *
 */
public class CityJPAController implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManagerFactory emf = null;
	
    public CityJPAController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public boolean create(City city){
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(city);
            em.getTransaction().commit();
            
            return true;
        } catch (Exception ex) {
                throw new RuntimeException("Task " + city.getName() + " already exists.", ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public List<City> findCity() {
    	EntityManager em = getEntityManager();
    	try {
    		Query query = em.createNamedQuery("City.findAll");
    		return query.getResultList();
    	}catch(NoResultException e){
    		return null;
    	} finally {
    		em.close();
    	}
    }
    
    public boolean remove(Long id){
    	EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            
            City city = em.getReference(City.class, id);
            
            em.remove(city);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
               throw new RuntimeException("The task with id " + id + " no longer exists.");
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
