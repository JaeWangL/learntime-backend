package com.hops.learntimebackend.api.application.commands;

import an.awesome.pipelinr.Command;
import jakarta.validation.constraints.NotNull;

public record CreateOrganizerCommand(
        @NotNull(message = "No order number found")
        String id,

        @NotNull(message = "No order number found")
        String name,

        @NotNull(message = "No order number found")
        String profileUrl) implements Command<String> {
}
