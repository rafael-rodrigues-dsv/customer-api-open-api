package org.example.api.adapter.entrypoint.usecase.impl;

import lombok.RequiredArgsConstructor;
import org.example.api.adapter.entrypoint.dto.customer.CreateCustomerDto;
import org.example.api.adapter.entrypoint.dto.customer.CustomerDto;
import org.example.api.adapter.entrypoint.dto.customer.UpdateCustomerDto;
import org.example.api.adapter.entrypoint.mapper.CustomMapper;
import org.example.api.adapter.entrypoint.usecase.CustomerUseCase;
import org.example.api.domain.CustomerService;
import org.example.api.domain.model.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerUseCaseImpl implements CustomerUseCase {

    private final CustomerService service;
    private final CustomMapper customMapper;

    @Override
    public CustomerDto create(CreateCustomerDto createCustomerDto) {
        return customMapper.map(service.add(customMapper.map(createCustomerDto, CustomerModel.class)),
                CustomerDto.class);
    }

    @Override
    public CustomerDto update(UpdateCustomerDto updateCustomerDto) {
        return customMapper.map(service.update(updateCustomerDto.getId(),
                customMapper.map(updateCustomerDto, CustomerModel.class)), CustomerDto.class);
    }

    @Override
    public CustomerDto findById(Long id) {
        return customMapper.map(service.findById(id), CustomerDto.class);
    }
}
