package com.hops.learntimebackend.api.application.queries;

import com.hops.learntimebackend.infrastructure.thirdParty.firebase.models.OrganizerModel;
import com.hops.learntimebackend.infrastructure.thirdParty.firebase.services.FirestoreService;
import com.hops.learntimebackend.shared.QueryHandler;
import java.util.List;
import java.util.concurrent.ExecutionException;
import lombok.RequiredArgsConstructor;

@QueryHandler
@RequiredArgsConstructor
public class OrganizerQueriesImpl implements OrganizerQueries {
    private final FirestoreService firestoreSvc;

    @Override
    public List<OrganizerModel> getAllOrganizers() {
        try {
            return firestoreSvc.findOrganizers();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
