package com.hops.learntimebackend.infrastructure.thirdParty.firebase.models.embedded;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LocationModel {
    private final String address1DepthName;
    private final String address2DepthName;
    private final String address3DepthName;
    private final String address4DepthDetail;
    private final String addressName;
    private final Double latitude;
    private final Double longitude;
}