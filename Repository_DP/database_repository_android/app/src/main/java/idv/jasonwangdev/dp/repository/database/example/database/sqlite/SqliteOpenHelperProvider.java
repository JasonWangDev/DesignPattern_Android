package idv.jasonwangdev.dp.repository.database.example.database.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jason on 2018/1/28.
 */

public class SqliteOpenHelperProvider {

    public static SQLiteOpenHelper getDefault(Context context) {
        return new DefaultSqliteOpenHelper(context);
    }

}
