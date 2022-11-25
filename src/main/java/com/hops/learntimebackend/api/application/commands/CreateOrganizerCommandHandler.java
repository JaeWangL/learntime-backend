package com.hops.learntimebackend.api.application.commands;

import an.awesome.pipelinr.Command;
import com.github.f4b6a3.ulid.UlidCreator;
import com.hops.learntimebackend.infrastructure.thirdParty.firebase.models.CreateOrganizerInput;
import com.hops.learntimebackend.infrastructure.thirdParty.firebase.services.FirestoreService;
import com.hops.learntimebackend.shared.CommandHandler;
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
            updatedTimestamp = firestoreSvc.saveOrganizer(new CreateOrganizerInput(
                    UlidCreator.getUlid().toString(),
                    command.name(),
                    command.profileUrl(),
                    LocalDateTime.now(),
                    LocalDateTime.now()
            ));

            return updatedTimestamp;
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
