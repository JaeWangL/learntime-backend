package com.hops.learntimebackend.infrastructure.thirdParty.firebase.services;

import com.hops.learntimebackend.infrastructure.thirdParty.firebase.models.CreateOrganizerInput;
import com.hops.learntimebackend.infrastructure.thirdParty.firebase.models.CreatePostInput;
import com.hops.learntimebackend.infrastructure.thirdParty.firebase.models.OrganizerModel;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

public interface FirestoreService {
    Optional<OrganizerModel> findOrganizerById(String id) throws ExecutionException, InterruptedException;

    String saveOrganizer(CreateOrganizerInput request);

    String savePost(CreatePostInput request);
}
