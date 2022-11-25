package com.hops.learntimebackend.infrastructure.thirdParty.firebase.services;

import com.hops.learntimebackend.infrastructure.thirdParty.firebase.models.CreateOrganizerInput;
import com.hops.learntimebackend.infrastructure.thirdParty.firebase.models.CreatePostInput;

import java.util.concurrent.ExecutionException;

public interface FirestoreService {
    String saveOrganizer(CreateOrganizerInput request) throws ExecutionException, InterruptedException;

    String savePost(CreatePostInput request) throws ExecutionException, InterruptedException;
}
