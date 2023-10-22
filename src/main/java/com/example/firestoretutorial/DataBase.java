package com.example.firestoretutorial;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class DataBase {

    public Firestore firestore;

    public DataBase(Firestore firestore) {
        this.firestore = firestore;
    }

    public ApiFuture<QuerySnapshot> DataBaseWithCollectionName(String collectionName) {
        return firestore.collection(collectionName).get();
    }
}
