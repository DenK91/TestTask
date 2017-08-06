package com.example.den_k.tinkov;

import android.support.multidex.MultiDexApplication;

import com.example.den_k.tinkov.di.AppComponent;
import com.example.den_k.tinkov.di.DaggerAppComponent;
import com.example.den_k.tinkov.utils.db.RealmMigration;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class App extends MultiDexApplication {

    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        Realm.setDefaultConfiguration(new RealmConfiguration.Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(RealmMigration.LAST_VERSION)
                .migration(new RealmMigration())
                .build());
        component = DaggerAppComponent.create();
    }

    public static AppComponent getComponent() {
        return component;
    }

}
