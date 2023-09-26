package com.somika.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //    @RequestMapping(
//            path = "api/v1/customers",
//            method = RequestMethod.GET
//    )
    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }


    @GetMapping(path = "{customerId}")
    public Customer getCustomerById(@PathVariable("customerId") Long customerId) {
        return customerService.getCustomer(customerId);
    }

    @PostMapping
    public void registerCustomer(
            @RequestBody CustomerRegistrationRequest request
    ) {
        customerService.addCustomer(request);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(
            @PathVariable("customerId") Long customerId
    ) {
        customerService.deleteCustomerById(customerId);
    }

    @PutMapping(path = "{customerId}")
    public void updateCustomer(
            @PathVariable("customerId") Long customerId,
            @RequestBody CustomerUpdateRequest updateRequest
    ){
        customerService.updateCustomer(customerId, updateRequest);
    }

}