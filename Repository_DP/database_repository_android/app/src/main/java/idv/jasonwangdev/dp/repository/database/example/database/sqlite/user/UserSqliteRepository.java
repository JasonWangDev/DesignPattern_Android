package idv.jasonwangdev.dp.repository.database.example.database.sqlite.user;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import idv.jasonwangdev.dp.repository.database.example.User;
import idv.jasonwangdev.dp.repository.database.example.database.DatabaseRepository;
import idv.jasonwangdev.dp.repository.database.example.database.DatabaseSpecification;
import idv.jasonwangdev.dp.repository.database.example.database.sqlite.SqliteObjectMapper;
import idv.jasonwangdev.dp.repository.database.example.database.sqlite.SqliteSpecification;

/**
 * Created by jason on 2018/1/25.
 */

public class UserSqliteRepository implements DatabaseRepository<User> {

    private SQLiteOpenHelper helper;

    private SqliteObjectMapper<User, ContentValues> toContentValuesMapper;
    private SqliteObjectMapper<Cursor, User> toObjectMapper;


    public UserSqliteRepository(SQLiteOpenHelper helper) {
        this.helper = helper;

        toContentValuesMapper = new UserToContentValuesMapper();
        toObjectMapper = new CursorToUserMapper();
    }


    @Override
    public void create(User object) {
        create(Collections.singletonList(object));
    }

    @Override
    public void create(List<User> objects) {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.beginTransaction();
        for(User object : objects) {
            ContentValues cv = toContentValuesMapper.map(object);
            db.insert("User", null, cv);
        }
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
        helper.close();
    }


    @Override
    public List<User> read(DatabaseSpecification specification) {
        SQLiteDatabase db = helper.getReadableDatabase();
        SqliteSpecification sqliteSpecification = (SqliteSpecification) specification;
        List<User> objects = new ArrayList<>();
        Cursor cursor = db.rawQuery(sqliteSpecification.toSqlQuery(), new String[]{});
        while (cursor.moveToNext())
            objects.add(toObjectMapper.map(cursor));
        cursor.close();
        db.close();
        helper.close();
        return objects;
    }


    @Override
    public void update(User object) {
        update(Collections.singletonList(object));
    }

    @Override
    public void update(List<User> objects) {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.beginTransaction();
        for(User object : objects)
            db.update("User", toContentValuesMapper.map(object), "Id = " + object.getId(), new String[]{});
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
        helper.close();
    }


    @Override
    public void delete(DatabaseSpecification specification) {
        SQLiteDatabase db = helper.getReadableDatabase();
        SqliteSpecification sqliteSpecification = (SqliteSpecification) specification;
        db.execSQL(sqliteSpecification.toSqlQuery());
        helper.close();
    }

}
