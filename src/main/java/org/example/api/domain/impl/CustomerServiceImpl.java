package org.example.api.domain.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.api.adapter.database.repository.CustomerRepository;
import org.example.api.domain.CustomerService;
import org.example.api.domain.model.CustomerModel;
import org.example.api.exception.DomainRuleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerModel add(CustomerModel customer) {
        if (hasCustomerWithDocumentNumber(customer.getDocumentNumber())) {
            throw new DomainRuleException("A customer with document number " + customer.getDocumentNumber() + " already exists.");
        }

        return customerRepository.save(customer);
    }

    @Override
    public CustomerModel update(Long id, CustomerModel customer) {
        return customerRepository.findById(id).map(existingCustomer -> {
            existingCustomer.setName(customer.getName());
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setPhoneNumber(customer.getPhoneNumber());
            return customerRepository.save(existingCustomer);
        }).orElseThrow(() -> new EntityNotFoundException("Customer not found with id " + id));
    }

    @Override
    public CustomerModel findById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer not found with id " + id));
    }

    private Boolean hasCustomerWithDocumentNumber(String document) {
        Example<CustomerModel> filter = Example.of(CustomerModel.builder()
                .documentNumber(document)
                .build());

        return customerRepository.exists(filter);
    }
}
