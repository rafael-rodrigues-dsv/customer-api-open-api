package org.example.api.adapter.entrypoint.dto.customer;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdateCustomerDto {

    @Schema(hidden = true)  // Esse campo é ignorado no Swagger
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 150, message = "Name must be at most 150 characters")
    @Schema(description = "Customer's full name", example = "Jane Doe")
    private String name;

    @NotBlank(message = "Email address is mandatory")
    @Email(message = "Invalid email address")
    @Size(max = 35, message = "Email must be at most 35 characters")
    @Schema(description = "Customer's email address", example = "jane.doe@example.com")
    private String email;

    @NotBlank(message = "Phone number is mandatory")
    @Size(min = 11, max = 11, message = "Phone number must be 11 characters")
    @Pattern(regexp = "^(\\d{11})$", message = "Invalid phone number")
    @Schema(description = "Customer's phone number (11 digits)", example = "10987654321")
    private String phoneNumber;
}
