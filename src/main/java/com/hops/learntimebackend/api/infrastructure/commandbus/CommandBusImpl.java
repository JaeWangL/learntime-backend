package com.hops.learntimebackend.api.infrastructure.commandbus;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CommandBusImpl implements  CommandBus {
    private final Pipeline pipeline;

    @Override
    public <R, C extends Command<R>> R send(C c) {
        return pipeline.send(c);
    }
}
