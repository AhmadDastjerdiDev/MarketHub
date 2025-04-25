package com.example.markethub1.customer.service;

import com.example.markethub1.customer.dto.CustomerDTO;
import com.example.markethub1.customer.entity.Customer;
import com.example.markethub1.customer.exceptions.CustomerAlreadyExistsException;
import com.example.markethub1.customer.exceptions.NoSuchCustomerExistsException;
import com.example.markethub1.customer.repository.CustomerRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepo customerRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<CustomerDTO> getAllCustomers() {

        List<Customer> customerList = customerRepo.findAll();
            return customerList.stream().map(customer -> modelMapper.map(customer, CustomerDTO.class)).collect(Collectors.toList());

    }

    @Override
    public CustomerDTO getCustomerById(Long customerId) {
        Optional<Customer> optionalCustomer = customerRepo.findById(customerId);
        if (optionalCustomer.isPresent())
            return modelMapper.map(optionalCustomer.get(), CustomerDTO.class);
        else
            throw new NoSuchCustomerExistsException("No Such Customer Exists By This Id!");


    }

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        Optional<Customer> optionalCustomer = customerRepo.findById(customerDTO.getCustomerId());
        if (optionalCustomer.isPresent())
            throw new CustomerAlreadyExistsException("This Customer Already Exixts!");
        else
            customerRepo.save(modelMapper.map(customerDTO, Customer.class));
    }

    @Override
    public CustomerDTO updateCustomer(Long customerId, CustomerDTO customerDTO) {
        Optional<Customer> optionalCustomer = customerRepo.findById(customerId);
        if (optionalCustomer.isPresent()) {
            Customer updatingCustomer = optionalCustomer.get();
            extractProperties(customerDTO, updatingCustomer);
            customerRepo.save(updatingCustomer);
            return modelMapper.map(updatingCustomer, CustomerDTO.class);
        } else {
            throw new NoSuchCustomerExistsException("No Such Customer Exists For Update!");
        }
    }

    @Override
    public void deleteCustomer(Long customerId) {
        Optional<Customer> optionalCustomer = customerRepo.findById(customerId);
        if (optionalCustomer.isPresent()) {
            customerRepo.deleteById(customerId);
        } else
            throw new NoSuchCustomerExistsException("No Such Customer Exists For Delete!");
    }

    public void extractProperties(CustomerDTO customerDTO, Customer customer){
        customer.setFullName(customerDTO.getFullName());
        customer.setAddress(customerDTO.getAddress());
        customer.setJob(customerDTO.getJob());
        customer.setBirthday(customerDTO.getBirthday());
        customer.setSNS(customerDTO.getSNS());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setPostalCode(customerDTO.getPostalCode());

    }
}
