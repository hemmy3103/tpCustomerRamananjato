/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.ramananjato.tp1.ejb;

import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import mg.itu.ramananjato.tp1.entities.Discount;


/**
 *
 * @author h.ramananjato
 */
@Stateless
public class DiscountManager {
    
    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    public List<Discount> getAllDiscounts() {
        Query query = em.createNamedQuery("Discount.findAll");
        return query.getResultList();
    }

    public Discount update(Discount discount) {
        return em.merge(discount);
    }
    
    public void persist(Discount discount) {
        em.persist(discount);
    }
    
    public Discount findById(String code) {
        return em.find(Discount.class, code);
    }

}
