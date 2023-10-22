package com.example.firestoretutorial;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

import static com.google.firebase.cloud.FirestoreClient.getFirestore;

@Configuration
public class FirebaseConfig {
    private final static String FIREBASE_CONFIG_PATH = "push-test-ron.json";

    public FirebaseApp fireBaseAppFactory() throws IOException {

        InputStream credential = new ClassPathResource(FIREBASE_CONFIG_PATH).getInputStream();

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(credential))
                .build();

        return FirebaseApp.initializeApp(options);

    }

    @Bean
    public Firestore firestore() throws IOException {
        return getFirestore(fireBaseAppFactory());
    }
}
