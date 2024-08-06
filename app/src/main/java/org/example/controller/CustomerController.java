//package org.example.controller;
//
//import org.example.entities.Customer;
//import org.example.service.CustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/customer")
//public class CustomerController {
//    @Autowired
//    private CustomerService customerService;
//
//    @GetMapping
//    public List<Customer> getAllCustomers() {
//        return customerService.getAllCustomers();
//    }
//
//    @GetMapping("/{customerId}")
//    public Customer getCustomerById(@PathVariable String customerId) {
//        return customerService.getCustomerById(customerId);
//    }
//
//    @PostMapping
//    public Customer addCustomer(@RequestBody Customer customer) {
//        return customerService.addCustomer(customer);
//    }
//
//    @DeleteMapping("/{customerId}")
//    public void deleteCustomer(@PathVariable String customerId) {
//        customerService.deleteCustomer(customerId);
//    }
//
//}
//
//package org.example.controller;
//
//import org.example.entities.Customer;
//import org.example.service.CustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.List;
//@RestController
//@RequestMapping("/customers")
//public class CustomerController {
//    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
//
//    @Autowired
//    private CustomerService customerService;
//
//    @GetMapping
//    public List<Customer> getAllCustomers() {
//        logger.info("Fetching all customers");
//        return customerService.getAllCustomers();
//    }
//
//    @GetMapping("/{customerId}")
//    public Customer getCustomerById(@PathVariable Long customerId) {
//        logger.info("Fetching customer with ID: {}", customerId);
//        return customerService.getCustomerById(customerId);
//    }
//
//    @PostMapping
//    public Customer addCustomer(@RequestBody Customer customer) {
//        logger.info("Adding new customer: {}", customer);
//        System.out.println("Received Customer: " + customer);
//        return customerService.addCustomer(customer);
//    }
//
//    @DeleteMapping("/{customerId}")
//    public void deleteCustomer(@PathVariable Long customerId) {
//        logger.info("Deleting customer with ID: {}", customerId);
//        customerService.deleteCustomer(customerId);
//    }
//}
package org.example.controller;

import org.example.entities.Customer;
import org.example.request.CustomerRequestDTO;
import org.example.response.CustomerResponseDTO;
import org.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<CustomerResponseDTO> getAllCustomers() {
        logger.info("Fetching all customers");
        List<Customer> customers = customerService.getAllCustomers();
        return customers.stream().map(this::convertToResponseDTO).collect(Collectors.toList());
    }

    @GetMapping("/{customerId}")
    public CustomerResponseDTO getCustomerById(@PathVariable Long customerId) {
        logger.info("Fetching customer with ID: {}", customerId);
        Customer customer = customerService.getCustomerById(customerId);
        return convertToResponseDTO(customer);
    }

    @PostMapping
    public CustomerResponseDTO addCustomer(@RequestBody CustomerRequestDTO customerRequestDTO) {
        logger.info("Adding new customer: {}", customerRequestDTO);
        Customer customer = convertToEntity(customerRequestDTO);
        customer = customerService.addCustomer(customer);
        return convertToResponseDTO(customer);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable Long customerId) {
        logger.info("Deleting customer with ID: {}", customerId);
        customerService.deleteCustomer(customerId);
    }

    // Conversion methods
    private CustomerResponseDTO convertToResponseDTO(Customer customer) {
        CustomerResponseDTO responseDTO = new CustomerResponseDTO();
        responseDTO.setCustomerId(customer.getCustomerId().toString());
        responseDTO.setCustomerName(customer.getCustomerName());
        return responseDTO;
    }

    private Customer convertToEntity(CustomerRequestDTO customerRequestDTO) {
        Customer customer = new Customer();
        customer.setCustomerName(customerRequestDTO.getCustomerName());
        // Set other fields if needed
        return customer;
    }
}
