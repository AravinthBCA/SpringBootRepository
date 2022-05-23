package profileservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import profileservice.model.Customer;

public interface CustomerRepository  extends JpaRepository<Customer,Integer> {
}
