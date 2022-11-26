package com.hops.learntimebackend.api.application.commands;

import an.awesome.pipelinr.Command;
import jakarta.validation.constraints.NotNull;

public record CreateOrganizerCommand(
        @NotNull(message = "No organizer name found")
        String name,

        @NotNull(message = "No organizer description found")
        String description,

        @NotNull(message = "No organizer profileUrl found")
        String profileUrl) implements Command<String> {
}
