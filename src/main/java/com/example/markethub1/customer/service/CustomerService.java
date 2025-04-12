package com.example.markethub1.customer.service;

import com.example.markethub1.customer.dto.CustomerDTO;
import com.example.markethub1.customer.entity.Customer;
import java.util.List;

public interface CustomerService {
    public List<CustomerDTO> getAllCustomers();
    public CustomerDTO getCustomerById(Long customerId);
    public void saveCustomer(CustomerDTO customerDTO);
    public void updateCustomer(Long customerId, CustomerDTO customerDTO);
    public void deleteCustomer(Long customerId);

}
