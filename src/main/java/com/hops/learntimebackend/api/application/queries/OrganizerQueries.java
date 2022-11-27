package com.hops.learntimebackend.api.application.queries;

import com.hops.learntimebackend.infrastructure.thirdParty.firebase.models.OrganizerModel;
import java.util.List;

public interface OrganizerQueries {
    List<OrganizerModel> getAllOrganizers();
}
