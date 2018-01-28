package idv.jasonwangdev.dp.repository.database.example.database.sqlite;

/**
 * Created by jason on 2018/1/25.
 */

public interface SqliteObjectMapper<From, To> {

    To map(From from);

}
