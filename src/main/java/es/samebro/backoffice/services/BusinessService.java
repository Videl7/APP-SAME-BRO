package es.samebro.backoffice.services;

import es.samebro.backoffice.entities.Business;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@SuppressWarnings("unchecked")
public class BusinessService {

  @PersistenceContext
  private EntityManager entityManager;

  public ArrayList<Business> getAll() throws Exception {
    return (ArrayList<Business>) this.entityManager.createNativeQuery("select * from business", Business.class)
        .getResultList();
  }

  public Business getOne(String uuid) throws Exception {
    return (Business) this.entityManager
        .createNativeQuery("select * from business where business_uuid = :uuid", Business.class)
        .setParameter("uuid", uuid).getSingleResult();
  }

  @Transactional
  public Business save(Business item) throws Exception {
    return this.entityManager.merge(item);
  }

  @Transactional
  public void delete(Business item) throws Exception {
    this.entityManager.remove(item);
  }
}
