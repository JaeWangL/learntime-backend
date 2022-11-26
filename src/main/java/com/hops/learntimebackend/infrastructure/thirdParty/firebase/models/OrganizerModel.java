package com.hops.learntimebackend.infrastructure.thirdParty.firebase.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizerModel {
    private String id;
    private String description;
    private String name;
    private String profileUrl;
    private Long createdAt;
    private Long updatedAt;
}
