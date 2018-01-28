package idv.jasonwangdev.dp.repository.database.example.database.realm;

import io.realm.RealmConfiguration;

/**
 * Created by Jason on 2018/1/28.
 */

public class RealmConfigurationProvider {

    public static RealmConfiguration getDefault() {
        RealmConfiguration.Builder builder = new RealmConfiguration.Builder();
        builder.deleteRealmIfMigrationNeeded(); // 資料表結構有異動時將清除資料庫所有資料
        return builder.build();
    }

}
