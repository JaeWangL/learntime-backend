package com.hops.learntimebackend.api.application.queries;

import com.hops.learntimebackend.infrastructure.thirdParty.firebase.models.PostModel;
import java.util.List;

public interface PostQueries {
    List<PostModel> getAllPosts();
}
