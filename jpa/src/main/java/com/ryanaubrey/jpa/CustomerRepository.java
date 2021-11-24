package com.ryanaubrey.jpa;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, UUID> {

    List<Customer> findByLastName(String lastName);

    Optional<Customer> findById(String id);

}
