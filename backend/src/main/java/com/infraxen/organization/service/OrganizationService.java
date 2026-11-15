package com.infraxen.organization.service;

import com.infraxen.organization.dto.OrganizationRequest;
import com.infraxen.organization.dto.OrganizationResponse;

import java.util.List;
import java.util.UUID;

public interface OrganizationService {

    OrganizationResponse createOrganization(OrganizationRequest request);

    OrganizationResponse getOrganizationById(UUID id);

    List<OrganizationResponse> getAllOrganizations();
}
