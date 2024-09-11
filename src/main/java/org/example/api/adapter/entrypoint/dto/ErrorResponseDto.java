package org.example.api.adapter.entrypoint.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ErrorResponseDto {
    private List<String> errors;
}

