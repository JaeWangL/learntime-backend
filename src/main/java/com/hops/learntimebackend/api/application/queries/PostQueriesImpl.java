package com.hops.learntimebackend.api.application.queries;

import com.hops.learntimebackend.infrastructure.thirdParty.firebase.models.PostModel;
import com.hops.learntimebackend.infrastructure.thirdParty.firebase.services.FirestoreService;
import com.hops.learntimebackend.shared.QueryHandler;
import java.util.List;
import java.util.concurrent.ExecutionException;
import lombok.RequiredArgsConstructor;

@QueryHandler
@RequiredArgsConstructor
public class PostQueriesImpl implements PostQueries {
    private final FirestoreService firestoreSvc;

    @Override
    public List<PostModel> getAllPosts() {
        try {
            return firestoreSvc.findPosts();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
