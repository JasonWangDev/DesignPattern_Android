package idv.jasonwangdev.dp.repository.database.example.database.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jason on 2018/1/25.
 */

public class DefaultSqliteOpenHelper extends SQLiteOpenHelper {

    public DefaultSqliteOpenHelper(Context context) {
        super(context, "Default", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " +
                   "User " +
                   "( " +
                   "Id INTEGER, " +
                   "Name VARCHAR, " +
                   "Address VARCHAR, " +
                   "Create_Date DATETIME " +
                   ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

}
