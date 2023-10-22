package com.example.firestoretutorial;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class DataBaseTest {

//    @Autowired
//    public DataBase db;

    @Autowired
    public DataBase dataBase;

    @Test
    public void test() throws ExecutionException, InterruptedException {
        Iterable<CollectionReference> documentReferences = dataBase.firestore.collection("carrot-walk").document("905").listCollections();
        documentReferences.forEach(
                data -> {
                    Iterator<DocumentReference> iterator = data.listDocuments().iterator();
                    iterator.forEachRemaining(documentReference -> {
                        try {
                            System.out.println(documentReference.get().get());
                        } catch (InterruptedException | ExecutionException e) {
                            throw new RuntimeException(e);
                        }
                    });
                }
        );
    }


}