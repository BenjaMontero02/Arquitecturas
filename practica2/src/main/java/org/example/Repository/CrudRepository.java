package org.example.Repository;

public interface CrudRepository {
    boolean create(Object obj);

    void delete(Object obj);

    Object get(Long id);

    void update(Object obj);
}
