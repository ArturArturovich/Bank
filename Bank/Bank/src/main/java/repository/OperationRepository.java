package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import java.util.List;

public interface OperationRepository <T> {
    public void save(T object);
    public void update(T object);
    public void delete(T object);
    public T findByPk(Object id);
    public List<T> findAll();
    public EntityManager getEntityManager();

}
