package com.hops.learntimebackend.api.application.commands;

import an.awesome.pipelinr.Command;
import com.github.f4b6a3.ulid.UlidCreator;
import com.hops.learntimebackend.infrastructure.thirdParty.firebase.models.CreateOrganizerInput;
import com.hops.learntimebackend.infrastructure.thirdParty.firebase.services.FirestoreService;
import com.hops.learntimebackend.shared.CommandHandler;
import java.time.Instant;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;

@CommandHandler
@RequiredArgsConstructor
public class CreateOrganizerCommandHandler implements Command.Handler<CreateOrganizerCommand, String> {
    private final FirestoreService firestoreSvc;

    @Override
    public String handle(CreateOrganizerCommand command) {
        final String updatedTimestamp;
        try {
            updatedTimestamp = firestoreSvc.saveOrganizer(
                CreateOrganizerInput.builder()
                    .id(UlidCreator.getUlid().toString())
                    .name(command.name())
                    .description(command.description())
                    .profileUrl(command.profileUrl())
                    .createdAt(Instant.now().getEpochSecond())
                    .updatedAt(Instant.now().getEpochSecond())
                    .build()
            );

            return updatedTimestamp;
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
