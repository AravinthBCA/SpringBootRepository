package profileservice.service;

import java.util.List;

import profileservice.model.Customer;

public interface CustomerService {


    Customer save(Customer customer);

    Customer fetchById(int profileId);

    List<Customer> fetchAllProfiles();
}
