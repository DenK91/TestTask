package com.example.den_k.tinkov.utils.db;

import io.realm.DynamicRealm;


public class RealmMigration implements io.realm.RealmMigration {

    public static final int LAST_VERSION = 1;

    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {

        if (oldVersion == 0) {
            //TODO: реализовать при смене структуры

            //TODO: инкрементить версию, при изменении БД
            //oldVersion++;
        }
    }
}
