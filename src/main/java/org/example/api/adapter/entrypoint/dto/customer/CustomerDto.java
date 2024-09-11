package org.example.api.adapter.entrypoint.dto.customer;

import io.swagger.v3.oas.annotations.media.Schema;
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
public class CustomerDto {

    @Schema(description = "Unique ID of the customer", example = "1")
    private Long id;

    @Schema(description = "Type of the customer", example = "NATURAL_PERSON")
    private CustomerTypeEnum customerType;

    @Schema(description = "Customer's document number", example = "12345678901")
    private String documentNumber;

    @Schema(description = "Customer's full name", example = "John Doe")
    private String name;

    @Schema(description = "Customer's email address", example = "john.doe@example.com")
    private String email;

    @Schema(description = "Customer's phone number (11 digits)", example = "12345678901")
    private String phoneNumber;
}
