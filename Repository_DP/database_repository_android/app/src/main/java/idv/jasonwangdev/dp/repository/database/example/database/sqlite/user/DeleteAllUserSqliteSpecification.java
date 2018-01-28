package idv.jasonwangdev.dp.repository.database.example.database.sqlite.user;

import idv.jasonwangdev.dp.repository.database.example.database.sqlite.SqliteSpecification;

/**
 * Created by jason on 2018/1/25.
 */

public class DeleteAllUserSqliteSpecification implements SqliteSpecification {

    @Override
    public String toSqlQuery() {
        return "DELETE FROM User";
    }

}
