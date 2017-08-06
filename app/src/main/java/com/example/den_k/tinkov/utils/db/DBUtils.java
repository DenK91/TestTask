package com.example.den_k.tinkov.utils.db;


import com.example.den_k.tinkov.model.data.Post;
import com.example.den_k.tinkov.model.data.PostTitle;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class DBUtils {

    private static final String ALL_NEWS_ID = "com.example.den_k.tinkov.utils.db.all_new_id";

    private DBUtils() {}

    public static void saveAllNews(final List<PostTitle> titles) {
        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(final Realm realm) {
                SerializedInstanceModel news = SerializedInstanceModel.packList(ALL_NEWS_ID, (ArrayList) titles);
                if (news != null) {
                    realm.copyToRealmOrUpdate(news);
                }
            }
        });
    }

    public static List<PostTitle> getAllNews() {
        RealmResults<SerializedInstanceModel> results = Realm.getDefaultInstance()
                .where(SerializedInstanceModel.class)
                .equalTo("id", ALL_NEWS_ID).findAll();
        if (!results.isEmpty()) {
            return results.get(0).unpackList();
        } else {
            return null;
        }
    }

    public static void savePost(final Post aPost) {
        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(final Realm realm) {
                SerializedInstanceModel<Post> postModel = SerializedInstanceModel.packSerializable(aPost.getTitle().getId(), aPost);
                if (postModel != null) {
                    realm.copyToRealmOrUpdate(postModel);
                }
            }
        });
    }

    public static Post getPost(String aId) {
        RealmResults<SerializedInstanceModel> results = Realm.getDefaultInstance()
                .where(SerializedInstanceModel.class)
                .equalTo("id", aId).findAll();
        if (!results.isEmpty()) {
            return (Post)results.get(0).unpackSerializable();
        } else {
            return null;
        }
    }

}
