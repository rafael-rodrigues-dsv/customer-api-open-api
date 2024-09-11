package org.example.api.domain;

import org.example.api.domain.model.CustomerModel;

public interface CustomerService {
    CustomerModel add(CustomerModel customer);
    CustomerModel update(Long id, CustomerModel customer);
    CustomerModel findById(Long id);
}
