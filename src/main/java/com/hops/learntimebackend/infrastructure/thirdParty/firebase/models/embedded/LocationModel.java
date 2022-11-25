package com.hops.learntimebackend.infrastructure.thirdParty.firebase.models.embedded;

public record LocationModel(
        String address1DepthName,
        String address2DepthName,
        String address3DepthName,
        String address4DepthDetail,
        String addressName,
        Double latitude,
        Double longitude
) {}