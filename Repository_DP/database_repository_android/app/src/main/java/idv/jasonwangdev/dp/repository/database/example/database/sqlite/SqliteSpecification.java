package idv.jasonwangdev.dp.repository.database.example.database.sqlite;

import idv.jasonwangdev.dp.repository.database.example.database.DatabaseSpecification;

/**
 * Created by jason on 2018/1/25.
 */

public interface SqliteSpecification extends DatabaseSpecification {

    String toSqlQuery();

}
