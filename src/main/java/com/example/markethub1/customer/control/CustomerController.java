package com.example.markethub1.customer.control;

import com.example.markethub1.customer.dto.CustomerDTO;
import com.example.markethub1.customer.entity.Customer;
import com.example.markethub1.customer.service.CustomerService;
import com.example.markethub1.customer.service.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Long id){
        CustomerDTO customerDTO = customerService.getCustomerById(id);
        if (customerDTO != null)
            return new ResponseEntity<>(customerDTO, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
        return new ResponseEntity<>("Customer created successfully!", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO){
        CustomerDTO updatedCustomerDTO = customerService.updateCustomer(id, customerDTO);
        if (updatedCustomerDTO != null)
            return new ResponseEntity<>("Customer updated successfully!",HttpStatus.OK);
        else
            return new ResponseEntity<>("Customer not found!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
        CustomerDTO deletingCustomerDTO = customerService.getCustomerById(id);
        if (deletingCustomerDTO != null) {
            customerService.deleteCustomer(id);
            return new ResponseEntity<>("Customer deleted successfully!", HttpStatus.OK);
        }
            else
            return new ResponseEntity<>("Customer not found!", HttpStatus.NOT_FOUND);
    }
}
