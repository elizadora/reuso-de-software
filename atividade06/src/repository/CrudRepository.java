package repository;

import java.util.List;

// representacao de um repositorio generico que possui metodos de CRUD
public interface CrudRepository<T> {
    void save(T entity);
    void delete(T entity);
    void update(T entity);
    T findById(int id);
    List<T> findAll();

}
