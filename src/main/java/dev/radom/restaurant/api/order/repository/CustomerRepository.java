package dev.radom.restaurant.api.order.repository;

import dev.radom.restaurant.api.order.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Boolean existsByFirstNameAndLastNameAndDob(String firstName, String lastName, LocalDate dob);

    Optional<Customer> findCustomerByUuid(String uuid);
}
