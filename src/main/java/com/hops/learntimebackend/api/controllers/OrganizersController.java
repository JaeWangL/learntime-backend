package com.hops.learntimebackend.api.controllers;

import com.hops.learntimebackend.api.application.commands.CreateOrganizerCommand;
import com.hops.learntimebackend.api.infrastructure.commandbus.CommandBus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Organizers", description = "organizers api")
@RequestMapping("organizers")
@RestController
@RequiredArgsConstructor
@Validated
public class OrganizersController {
    private final CommandBus commandBus;

    @Operation(summary = "create organizer", description = "create new organizer")
    @PostMapping("")
    public ResponseEntity<String> createOrganizer(
            @RequestBody @Valid CreateOrganizerCommand command
    ) {
        return ResponseEntity.ok(commandBus.send(command));
    }
}
