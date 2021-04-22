package phonedirectory.repository;

import org.springframework.stereotype.Repository;
import phonedirectory.model.Contact;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public class ContactRepository {

    @PersistenceUnit(unitName = "directory")
    private EntityManagerFactory emf;

    public List<Contact> getUserContacts(Integer userId) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Contact> query = em.createQuery("SELECT c from Contact c JOIN FETCH c.user cuser WHERE cuser.id = :userId", Contact.class);
        query.setParameter("userId", userId);
        List<Contact> resultList = query.getResultList();

        return resultList;
    }



    public Contact createContact(Contact newContact) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(newContact);
            transaction.commit();
        }catch(Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

        return newContact;
    }

    public void deleteContact(Integer contactId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Contact contact = em.find(Contact.class, contactId);
            em.remove(contact);
            transaction.commit();
        }catch(Exception e) {
            transaction.rollback();
        }
    }

}