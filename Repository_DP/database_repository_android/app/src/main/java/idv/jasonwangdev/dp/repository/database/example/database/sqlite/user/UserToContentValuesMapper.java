package idv.jasonwangdev.dp.repository.database.example.database.sqlite.user;

import android.content.ContentValues;

import java.text.SimpleDateFormat;

import idv.jasonwangdev.dp.repository.database.example.User;
import idv.jasonwangdev.dp.repository.database.example.database.sqlite.SqliteObjectMapper;

/**
 * Created by jason on 2018/1/25.
 */

public class UserToContentValuesMapper implements SqliteObjectMapper<User, ContentValues> {

    @Override
    public ContentValues map(User user) {
        ContentValues cv = new ContentValues();
        cv.put("Id", user.getId());
        cv.put("Name", user.getName());
        cv.put("Address", user.getAddress());
        cv.put("Create_Date", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(user.getCreateDate()));
        return cv;
    }

}
