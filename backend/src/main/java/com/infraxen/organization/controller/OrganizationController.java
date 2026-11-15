
package com.infraxen.organization.controller;

import com.infraxen.organization.dto.OrganizationRequest;
import com.infraxen.organization.dto.OrganizationResponse;
import com.infraxen.organization.service.OrganizationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/organizations")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    @PostMapping
    public ResponseEntity<OrganizationResponse> createOrganization(
            @Valid @RequestBody OrganizationRequest request) {

        OrganizationResponse response =
                organizationService.createOrganization(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationResponse> getOrganizationById(
            @PathVariable UUID id) {

        OrganizationResponse response =
                organizationService.getOrganizationById(id);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<OrganizationResponse>> getAllOrganizations() {

        List<OrganizationResponse> organizations =
                organizationService.getAllOrganizations();

        return ResponseEntity.ok(organizations);
    }
}
