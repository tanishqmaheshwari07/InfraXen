
package com.infraxen.organization.dto;

import lombok.Getter;
import lombok.Builder;
import lombok.AllArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class OrganizationResponse {

    private UUID id;

    private String name;

    private String slug;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;
}
