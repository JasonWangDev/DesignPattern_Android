package idv.jasonwangdev.dp.repository.database.example.database;

import java.util.List;

/**
 * Created by jason on 2018/1/25.
 */

public interface DatabaseRepository<T> {

    void create(T object);
    void create(List<T> objects);

    List<T> read(DatabaseSpecification specification);

    void update(T object);
    void update(List<T> objects);

    void delete(DatabaseSpecification specification);

}
