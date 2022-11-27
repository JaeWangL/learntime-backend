package com.hops.learntimebackend.infrastructure.thirdParty.firebase.models;

import com.hops.learntimebackend.infrastructure.thirdParty.firebase.models.embedded.GetLocationModel;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostModel {
    private String id;
    private String title;
    private String description;
    private Integer likes;
    private Integer bookmarks;
    private List<String> photoUrls;
    private GetLocationModel location;
    private Long createdAt;
    private Long updatedAt;
    private OrganizerModel organizer;
}
