package com.hops.learntimebackend.configs;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class FirebaseConfig {

    @Value("${app.firebase.config-path}")
    private String configPath;

    @PostConstruct
    public void init(){
        try{
            FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(getFirebaseConfig()))
                .build();
            FirebaseApp.initializeApp(options, "Learntime");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private InputStream getFirebaseConfig() throws IOException {
        ClassPathResource file = new ClassPathResource(configPath);
        if (file.exists()) {
            return file.getInputStream();
        } throw new RuntimeException("No firebase config found");
    }
}
