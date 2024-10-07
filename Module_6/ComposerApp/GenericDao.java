package Module_6.ComposerApp;

import java.util.List;

public interface GenericDao<E, K> {
    List<E> findAll();
    E findBy(K key);
    void insert(E entity);
}
