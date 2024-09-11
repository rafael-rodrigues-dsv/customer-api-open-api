package org.example.api.adapter.entrypoint.usecase;

import org.example.api.adapter.entrypoint.dto.customer.CreateCustomerDto;
import org.example.api.adapter.entrypoint.dto.customer.CustomerDto;
import org.example.api.adapter.entrypoint.dto.customer.UpdateCustomerDto;

public interface CustomerUseCase {
    CustomerDto create(CreateCustomerDto createCustomerDto);

    CustomerDto update(UpdateCustomerDto updateCustomerDto);

    CustomerDto findById(Long id);
}
