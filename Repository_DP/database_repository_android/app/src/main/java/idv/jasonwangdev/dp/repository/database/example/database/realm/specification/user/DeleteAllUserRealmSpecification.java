package idv.jasonwangdev.dp.repository.database.example.database.realm.specification.user;

import idv.jasonwangdev.dp.repository.database.example.User;
import idv.jasonwangdev.dp.repository.database.example.database.realm.RealmSpecification;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by jason on 2018/1/25.
 */

public class DeleteAllUserRealmSpecification implements RealmSpecification {

    @Override
    public RealmResults toRealmResult(Realm realm) {
        realm.delete(User.class);
        return null;
    }

}
