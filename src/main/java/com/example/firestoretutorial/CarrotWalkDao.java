package com.example.firestoretutorial;

import com.google.cloud.firestore.QuerySnapshot;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class CarrotWalkDao {

    public DataBase dataBase;

    public CarrotWalkDao(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public QuerySnapshot GetAllData() throws ExecutionException, InterruptedException {
        return dataBase.DataBaseWithCollectionName("carrot-walk").get();
    }
}
