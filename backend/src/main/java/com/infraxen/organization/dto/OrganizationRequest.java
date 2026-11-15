
package com.infraxen.organization.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationRequest {

    @NotBlank(message = "Organization name is required")
    @Size(min = 2, max = 150,
          message = "Organization name must be between 2 and 150 characters")
    private String name;
}
