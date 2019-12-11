package repository;

import model.Account;
import model.Transaction;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public abstract class OperationRepo<T> implements OperationRepository<T> {


    @PersistenceContext
    public EntityManager em;

    Class<T> maClass;

    public OperationRepo(Class<T> pClass){
        this.maClass=pClass;
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public void save(T object) {
        em.persist(object);
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public void update(T object) {
        em.merge(object);
    }

    public void delete(T object) {
        em.remove(object);
    }

    public T findByPk(Object id) {
        return em.find(maClass, id);
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        Query query=em.createNamedQuery(maClass.getSimpleName()+ ".findAll");
        return query.getResultList();
    }

    public EntityManager getEntityManager(){
        return em;
    }

    @Transactional
    public abstract void saveAccountAndTransaction(Account account, Transaction transaction);

    @Transactional
    public abstract List<Transaction> getTransactionsHistory(Account account);
}
