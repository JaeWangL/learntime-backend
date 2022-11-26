package com.hops.learntimebackend.api.application.commands;

import an.awesome.pipelinr.Command;
import com.hops.learntimebackend.infrastructure.thirdParty.firebase.models.CreateOrganizerInput;
import com.hops.learntimebackend.infrastructure.thirdParty.firebase.models.embedded.LocationModel;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

public record CreatePostCommand(
    @NotNull(message = "No post title found")
    String title,

    @NotNull(message = "No post description found")
    String description,

    @NotNull(message = "No post photoUrl found")
    @Size(min=1, max=3, message = "Post photoUrls can be 1 ~ 5 photos")
    List<String> photoUrls,

    @NotNull(message = "No post location found")
    LocationModel location,

    @NotNull(message = "No organizer id found")
    String organizerId) implements Command<String>
{
}
