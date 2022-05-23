package profileservice.controller;


import profileservice.model.Customer;
import profileservice.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/services")
public class ProfileController {


    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/cutomers", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('create_profile')")
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public Customer fetch(@PathVariable("id") int customerId) {
        return customerService.fetchById(customerId);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_admin')")
    public List<Customer> fetch() {
        return customerService.fetchAllProfiles();
    }
}
