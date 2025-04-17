package com.example.markethub1.customer.service;

import com.example.markethub1.customer.dto.CustomerDTO;
import com.example.markethub1.customer.entity.Customer;
import com.example.markethub1.customer.repository.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {


    private CustomerRepo customerRepo;

    private ModelMapper modelMapper;

    @Override
    public List<CustomerDTO> getAllCustomers() {

        List<Customer> customerList = new ArrayList<>();
        customerList.addAll(customerRepo.findAll());
        return customerList.stream().map(customer -> modelMapper.map(customer, CustomerDTO.class)).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long customerId) {
        Optional<Customer> optionalCustomer = customerRepo.findById(customerId);
        if (optionalCustomer.isPresent()) {
            return modelMapper.map(optionalCustomer.get(), CustomerDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        customerRepo.save(modelMapper.map(customerDTO, Customer.class));
    }

    @Override
    public CustomerDTO updateCustomer(Long customerId, CustomerDTO customerDTO) {
        Optional<Customer> optionalCustomer = customerRepo.findById(customerId);
        if (optionalCustomer.isPresent()) {
            Customer updatingCustomer = optionalCustomer.get();
            updatingCustomer.setFullName(customerDTO.getFullName());
            updatingCustomer.setAddress(customerDTO.getAddress());
            updatingCustomer.setJob(customerDTO.getJob());
            updatingCustomer.setBirthday(customerDTO.getBirthday());
            updatingCustomer.setSNS(customerDTO.getSNS());
            updatingCustomer.setEmail(customerDTO.getEmail());
            updatingCustomer.setPhoneNumber(customerDTO.getPhoneNumber());
            updatingCustomer.setPostalCode(customerDTO.getPostalCode());
            customerRepo.save(updatingCustomer);
            return modelMapper.map(updatingCustomer, CustomerDTO.class);
        } else {
            System.out.println("The Id Not Found!!!");
            return null;
        }
    }

    @Override
    public void deleteCustomer(Long customerId) {
        Optional<Customer> optionalCustomer = customerRepo.findById(customerId);
        if (optionalCustomer.isPresent()) {
            customerRepo.deleteById(customerId);
        } else
            System.out.println("This Id Not Found!!!");
    }
}
