package org.example.api.adapter.entrypoint.dto.customer;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.api.domain.enumeration.CustomerTypeEnum;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreateCustomerDto {

    @NotNull(message = "Customer type is mandatory")
    @Schema(description = "Type of the customer (NATURAL_PERSON or LEGAL_PERSON)", example = "NATURAL_PERSON")
    private CustomerTypeEnum customerType;

    @NotBlank(message = "Document number is mandatory")
    @Size(min = 11, max = 14, message = "Document number must be between 11 and 14 characters")
    @Pattern(regexp = "^(\\d{11})|(\\d{14})$", message = "Invalid document number")
    @Schema(description = "Document number, can be CPF (11 digits) or CNPJ (14 digits)", example = "12345678901")
    private String documentNumber;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 150, message = "Name must be at most 150 characters")
    @Schema(description = "Customer's full name", example = "John Doe")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Invalid email address")
    @Size(max = 35, message = "Email must be at most 35 characters")
    @Schema(description = "Customer's email address", example = "john.doe@example.com")
    private String email;

    @NotBlank(message = "Phone number is mandatory")
    @Size(min = 11, max = 11, message = "Phone number must be 11 characters")
    @Pattern(regexp = "^(\\d{11})$", message = "Invalid phone number")
    @Schema(description = "Customer's phone number (11 digits)", example = "12345678901")
    private String phoneNumber;
}
