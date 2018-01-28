package idv.jasonwangdev.dp.repository.database.example.database.realm;

import idv.jasonwangdev.dp.repository.database.example.database.DatabaseSpecification;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by jason on 2018/1/25.
 */

public interface RealmSpecification extends DatabaseSpecification {

    RealmResults toRealmResult(Realm realm);

}
