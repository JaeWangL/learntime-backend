package com.hops.learntimebackend.infrastructure.thirdParty.firebase.models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateOrganizerInput {
    private final String id;
    private final String description;
    private final String name;
    private final String profileUrl;
    private final Long createdAt;
    private final Long updatedAt;
}
