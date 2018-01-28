package idv.jasonwangdev.dp.repository.database.example.database.sqlite.user;

import android.database.Cursor;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import idv.jasonwangdev.dp.repository.database.example.User;
import idv.jasonwangdev.dp.repository.database.example.database.sqlite.SqliteObjectMapper;

/**
 * Created by jason on 2018/1/25.
 */

public class CursorToUserMapper implements SqliteObjectMapper<Cursor, User> {

    @Override
    public User map(Cursor cursor) {
        User user = new User();
        user.setId(cursor.getInt(cursor.getColumnIndex("Id")));
        user.setName(cursor.getString(cursor.getColumnIndex("Name")));
        user.setAddress(cursor.getString(cursor.getColumnIndex("Address")));
        try {
            user.setCreateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(cursor.getString(cursor.getColumnIndex("Create_Date"))));
        }
        catch (ParseException e) { }
        return user;
    }

}
