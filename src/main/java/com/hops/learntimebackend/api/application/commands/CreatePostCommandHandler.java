package com.hops.learntimebackend.api.application.commands;

import an.awesome.pipelinr.Command;
import com.github.f4b6a3.ulid.UlidCreator;
import com.hops.learntimebackend.infrastructure.thirdParty.firebase.exceptions.OrganizerNotFoundException;
import com.hops.learntimebackend.infrastructure.thirdParty.firebase.models.CreateOrganizerInput;
import com.hops.learntimebackend.infrastructure.thirdParty.firebase.models.CreatePostInput;
import com.hops.learntimebackend.infrastructure.thirdParty.firebase.services.FirestoreService;
import com.hops.learntimebackend.shared.CommandHandler;
import java.time.Instant;
import java.util.concurrent.ExecutionException;
import lombok.RequiredArgsConstructor;

@CommandHandler
@RequiredArgsConstructor
public class CreatePostCommandHandler implements Command.Handler<CreatePostCommand, String> {
    private final FirestoreService firestoreSvc;

    @Override
    public String handle(CreatePostCommand command) {
        try {
            final var organizer = firestoreSvc.findOrganizerById(command.organizerId())
                .orElseThrow(OrganizerNotFoundException::new);

            return firestoreSvc.savePost(
                CreatePostInput.builder()
                    .id(UlidCreator.getUlid().toString())
                    .title(command.title())
                    .description(command.description())
                    .likes(0)
                    .bookmarks(0)
                    .photoUrls(command.photoUrls())
                    .location(command.location())
                    .createdAt(Instant.now().getEpochSecond())
                    .updatedAt(Instant.now().getEpochSecond())
                    .organizer(CreateOrganizerInput.builder()
                        .id(organizer.getId())
                        .name(organizer.getName())
                        .description(organizer.getDescription())
                        .profileUrl(organizer.getProfileUrl())
                        .createdAt(organizer.getCreatedAt())
                        .updatedAt(organizer.getUpdatedAt())
                        .build())
                    .build()
            );
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
