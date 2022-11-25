package com.hops.learntimebackend.api.controllers;

import com.hops.learntimebackend.api.application.commands.CreateOrganizerCommand;
import com.hops.learntimebackend.api.infrastructure.commandbus.CommandBus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RequestMapping('organizers')
@RestController
@RequiredArgsConstructor
@Validated
public class OrganizersController {
    private final CommandBus commandBus;

    @RequestMapping(value = "draft", method = RequestMethod.POST)
    public ResponseEntity<String> createOrderDraftFromBasketData(
            @RequestBody @Valid CreateOrganizerCommand command
    ) {
        return ResponseEntity.ok(commandBus.send(command));
    }
}
