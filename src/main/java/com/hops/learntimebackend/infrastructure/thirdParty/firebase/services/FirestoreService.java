package com.hops.learntimebackend.infrastructure.thirdParty.firebase.services;

import com.hops.learntimebackend.infrastructure.thirdParty.firebase.models.CreateOrganizerInput;
import com.hops.learntimebackend.infrastructure.thirdParty.firebase.models.CreatePostInput;
import com.hops.learntimebackend.infrastructure.thirdParty.firebase.models.OrganizerModel;
import com.hops.learntimebackend.infrastructure.thirdParty.firebase.models.PostModel;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

public interface FirestoreService {
    Optional<OrganizerModel> findOrganizerById(String id) throws ExecutionException, InterruptedException;

    List<OrganizerModel> findOrganizers() throws ExecutionException, InterruptedException;

    String saveOrganizer(CreateOrganizerInput request);

    List<PostModel> findPosts() throws ExecutionException, InterruptedException;

    String savePost(CreatePostInput request);
}
