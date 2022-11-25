package com.hops.learntimebackend.infrastructure.thirdParty.firebase.models;

import com.hops.learntimebackend.infrastructure.thirdParty.firebase.models.embedded.LocationModel;

import java.time.LocalDateTime;
import java.util.List;

public record CreatePostInput(
        String id,
        String title,
        String description,
        Integer likes,
        Integer bookmarks,
        List<String> photoUrls,
        LocationModel location,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        CreateOrganizerInput organizer) {
}