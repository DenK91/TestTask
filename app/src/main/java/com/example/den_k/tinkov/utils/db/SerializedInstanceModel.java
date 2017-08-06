package com.example.den_k.tinkov.utils.db;

import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;
import lombok.Getter;
import lombok.Setter;

/**
 * TODO: миграция БД.
 * Объект бд, при изменении полей необходимо
 * добавить следующие изменения в класс для миграции.
 * {@link RealmMigration}.
 */
public class SerializedInstanceModel<I extends Serializable> extends RealmObject {

    public SerializedInstanceModel() {}

    @PrimaryKey
    private String id;

    @Required
    @Getter
    @Setter
    private String data;

    private SerializedInstanceModel(final String data) {
        this.data = data;
    }

    public static SerializedInstanceModel packSerializable(final String key, final Serializable object) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            //TODO: OOM encode big string.
            SerializedInstanceModel model = new SerializedInstanceModel(Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT));
            model.id = key;
            return model;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public I unpackSerializable() {
        byte[] data = Base64.decode(this.data, Base64.DEFAULT);
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new ByteArrayInputStream(data));
            return (I) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static SerializedInstanceModel packList(final String key, final ArrayList list) {
        return packSerializable(key, list);
    }

    public List<I> unpackList() {
        return (List<I>) unpackSerializable();
    }
}
