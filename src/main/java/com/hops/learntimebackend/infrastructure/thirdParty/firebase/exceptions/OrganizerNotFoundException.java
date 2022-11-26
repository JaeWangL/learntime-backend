package com.hops.learntimebackend.infrastructure.thirdParty.firebase.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "organizer not found")
public class OrganizerNotFoundException extends RuntimeException {
}
