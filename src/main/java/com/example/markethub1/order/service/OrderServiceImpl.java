package com.example.markethub1.order.service;

import com.example.markethub1.customer.entity.Customer;
import com.example.markethub1.customer.exceptions.CustomerAlreadyExistsException;
import com.example.markethub1.order.dto.OrderDTO;
import com.example.markethub1.order.entity.Order;
import com.example.markethub1.order.exception.NoSuchOrderExistsException;
import com.example.markethub1.order.exception.OrderAlreadyExistsException;
import com.example.markethub1.order.repository.OrderRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepo orderRepo;
    private final ModelMapper modelMapper;

    @Override
    public void saveOrder(OrderDTO orderDTO) {
        Optional<Order> optionalOrder = orderRepo.findById(orderDTO.getOrderId());
        if (optionalOrder.isPresent())
            throw new OrderAlreadyExistsException("This Order Already Exixts!");
        else
            orderRepo.save(modelMapper.map(orderDTO, Order.class));
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepo.findAll().stream().map(order -> modelMapper.map(order, OrderDTO.class)).collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrderById(Long orderId) {
        Optional<Order> optionalOrder = orderRepo.findById(orderId);
        if (optionalOrder.isPresent()){
            return modelMapper.map(optionalOrder.get(),OrderDTO.class);
        }
        else
            throw new NoSuchOrderExistsException("No Such Order Exists with this Id!");
    }

    @Override
    public OrderDTO updateOrder(Long orderId, OrderDTO orderDTO) {
        Optional<Order> optionalOrder = orderRepo.findById(orderId);
        if (optionalOrder.isPresent()){
            Order updatingOrder = optionalOrder.get();
            extractProperties(orderDTO, updatingOrder);
            orderRepo.save(updatingOrder);
            return modelMapper.map(updatingOrder, OrderDTO.class);
        }
        else
            throw new NoSuchOrderExistsException("No Such Order Exists for Update!");
    }

    @Override
    public void deleteOrder(Long orderId) {
        Optional<Order> optionalOrder = orderRepo.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order deletingOrder = optionalOrder.get();
            orderRepo.delete(deletingOrder);
        }
        else
            throw new NoSuchOrderExistsException("No Such Order Exists For Delete!");
    }

    public void extractProperties(OrderDTO orderDTO, Order order){
        order.setOrderCode(orderDTO.getOrderCode());
        order.setDate(orderDTO.getDate());
        order.setScore(orderDTO.getScore());
        order.setShippingCost(orderDTO.getShippingCost());
        order.setTotalPayable(orderDTO.getTotalPayable());
    }
}
