
package com.infraxen.organization.service.impl;

import com.infraxen.organization.dto.OrganizationRequest;
import com.infraxen.organization.dto.OrganizationResponse;
import com.infraxen.organization.entity.Organization;
import com.infraxen.organization.repository.OrganizationRepository;
import com.infraxen.organization.service.OrganizationService;
import com.infraxen.common.exception.DuplicateResourceException;
import com.infraxen.common.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    @Override
    public OrganizationResponse createOrganization(OrganizationRequest request) {

        String name = request.getName().trim();

        String slug = name.toLowerCase()
                .replaceAll("[^a-z0-9]+", "-")
                .replaceAll("^-|-$", "");

        if (organizationRepository.existsBySlug(slug)) {
            throw new DuplicateResourceException("Organization with slug '" + slug + "' already exists");
        }

        Organization organization = new Organization();
        organization.setName(name);
        organization.setSlug(slug);

        Organization savedOrganization =
                organizationRepository.save(organization);

        return mapToResponse(savedOrganization);
    }

    @Override
    public OrganizationResponse getOrganizationById(UUID id) {

        Organization organization = organizationRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Organization not found with ID: " + id)
                );

        return mapToResponse(organization);
    }

    @Override
    public List<OrganizationResponse> getAllOrganizations() {

        return organizationRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private OrganizationResponse mapToResponse(Organization organization) {

        return OrganizationResponse.builder()
                .id(organization.getId())
                .name(organization.getName())
                .slug(organization.getSlug())
                .createdAt(organization.getCreatedAt())
                .updatedAt(organization.getUpdatedAt())
                .build();
    }
}
