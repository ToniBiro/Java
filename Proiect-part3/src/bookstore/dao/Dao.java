package bookstore.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    List<T> getAll();

    Optional<T> getById(String username);

    boolean create(T t);

    void update(T t);

    boolean delete(T t);
}