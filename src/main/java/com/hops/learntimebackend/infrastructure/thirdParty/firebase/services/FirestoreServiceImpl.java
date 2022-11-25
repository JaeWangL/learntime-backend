package com.hops.learntimebackend.infrastructure.thirdParty.firebase.services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.hops.learntimebackend.infrastructure.thirdParty.firebase.models.CreateOrganizerInput;
import com.hops.learntimebackend.infrastructure.thirdParty.firebase.models.CreatePostInput;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.concurrent.ExecutionException;

@Service
public class FirestoreServiceImpl implements FirestoreService {

    @Value("${app.firebase.collection.organizers}")
    private String collectionOrganizers;

    @Value("${app.firebase.collection.posts}")
    private String collectionPosts;

    @Override
    public String saveOrganizer(CreateOrganizerInput request) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> future = db.collection(collectionOrganizers)
                .document(request.id())
                .set(request);

        return future.get().getUpdateTime().toString();
    }

    @Override
    public String savePost(CreatePostInput request) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> future = db.collection(collectionPosts)
                .document(request.id())
                .set(request);

        return future.get().getUpdateTime().toString();
    }
}
