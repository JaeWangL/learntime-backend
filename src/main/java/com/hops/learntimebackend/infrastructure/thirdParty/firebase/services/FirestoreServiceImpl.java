package com.hops.learntimebackend.infrastructure.thirdParty.firebase.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.hops.learntimebackend.infrastructure.thirdParty.firebase.models.CreateOrganizerInput;
import com.hops.learntimebackend.infrastructure.thirdParty.firebase.models.CreatePostInput;
import com.hops.learntimebackend.infrastructure.thirdParty.firebase.models.OrganizerModel;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<OrganizerModel> findOrganizerById(String id) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<DocumentSnapshot> future = db.collection(collectionOrganizers)
            .document(id).get();
        DocumentSnapshot documentSnapshot = future.get();

        System.out.println(documentSnapshot.toObject(OrganizerModel.class));

        return documentSnapshot.exists() ? Optional.ofNullable(documentSnapshot.toObject(OrganizerModel.class)) : Optional.empty();
    }

    @Override
    public String saveOrganizer(CreateOrganizerInput request) {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> future = db.collection(collectionOrganizers)
                .document(request.getId())
                .set(request);

        return request.getId();
    }

    @Override
    public String savePost(CreatePostInput request) {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> future = db.collection(collectionPosts)
                .document(request.getId())
                .set(request);

        return request.getId();
    }
}
