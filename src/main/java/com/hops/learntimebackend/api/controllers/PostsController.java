package com.hops.learntimebackend.api.controllers;

import com.hops.learntimebackend.api.application.commands.CreatePostCommand;
import com.hops.learntimebackend.api.infrastructure.commandbus.CommandBus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Posts", description = "posts api")
@RequestMapping("posts")
@RestController
@RequiredArgsConstructor
@Validated
public class PostsController {
    private final CommandBus commandBus;

    @Operation(summary = "create post", description = "create new post")
    @PostMapping("")
    public ResponseEntity<String> createPost(
        @RequestBody @Valid CreatePostCommand command
    ) {
        return ResponseEntity.ok(commandBus.send(command));
    }
}
