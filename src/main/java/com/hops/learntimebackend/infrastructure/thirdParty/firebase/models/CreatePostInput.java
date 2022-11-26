package com.hops.learntimebackend.infrastructure.thirdParty.firebase.models;

import com.hops.learntimebackend.infrastructure.thirdParty.firebase.models.embedded.LocationModel;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreatePostInput {
    private final String id;
    private final String title;
    private final String description;
    private final Integer likes;
    private final Integer bookmarks;
    private final List<String> photoUrls;
    private final LocationModel location;
    private final Long createdAt;
    private final Long updatedAt;
    private final CreateOrganizerInput organizer;
}