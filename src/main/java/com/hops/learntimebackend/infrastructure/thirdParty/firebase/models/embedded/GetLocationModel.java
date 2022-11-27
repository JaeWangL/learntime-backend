package com.hops.learntimebackend.infrastructure.thirdParty.firebase.models.embedded;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetLocationModel {
    private String address1DepthName;
    private String address2DepthName;
    private String address3DepthName;
    private String address4DepthDetail;
    private String addressName;
    private Double latitude;
    private Double longitude;
}
