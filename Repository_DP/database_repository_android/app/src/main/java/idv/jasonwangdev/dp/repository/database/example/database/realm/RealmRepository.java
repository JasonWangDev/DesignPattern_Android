package idv.jasonwangdev.dp.repository.database.example.database.realm;

import java.util.Collections;
import java.util.List;

import idv.jasonwangdev.dp.repository.database.example.database.DatabaseRepository;
import idv.jasonwangdev.dp.repository.database.example.database.DatabaseSpecification;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by jason on 2018/1/25.
 */

public class RealmRepository<T extends RealmObject> implements DatabaseRepository<T> {

    private RealmConfiguration realmConfiguration;


    public RealmRepository(RealmConfiguration realmConfiguration) {
        this.realmConfiguration = realmConfiguration;
    }


    @Override
    public void create(T object) {
        create(Collections.singletonList(object));
    }

    @Override
    public void create(List<T> objects) {
        Realm realm = Realm.getInstance(realmConfiguration);
        realm.beginTransaction();
        realm.copyToRealm(objects);
        realm.commitTransaction();
        realm.close();
    }


    @Override
    public List<T> read(DatabaseSpecification specification) {
        Realm realm = Realm.getInstance(realmConfiguration);
        RealmSpecification realmSpecification = (RealmSpecification) specification;
        RealmResults results = realmSpecification.toRealmResult(realm);
        List<T> objects = realm.copyFromRealm(results);
        realm.close();
        return objects;
    }


    @Override
    public void update(T object) {
        update(Collections.singletonList(object));
    }

    @Override
    public void update(List<T> objects) {
        Realm realm = Realm.getInstance(realmConfiguration);
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(objects);
        realm.commitTransaction();
        realm.close();
    }


    @Override
    public void delete(DatabaseSpecification specification) {
        Realm realm = Realm.getInstance(realmConfiguration);
        realm.beginTransaction();
        RealmSpecification realmSpecification = (RealmSpecification) specification;
        realmSpecification.toRealmResult(realm);
        realm.commitTransaction();
        realm.close();
    }

}
