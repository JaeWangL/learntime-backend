package com.hops.learntimebackend.infrastructure.thirdParty.firebase.models;

import java.time.LocalDateTime;

public record CreateOrganizerInput(
        String id,
        String name,
        String profileUrl,
        LocalDateTime createdAt,
        LocalDateTime updatedAt)
{
}
