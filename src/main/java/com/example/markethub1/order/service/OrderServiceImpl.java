package com.example.markethub1.order.service;

import com.example.markethub1.order.dto.OrderDTO;
import com.example.markethub1.order.entity.Order;
import com.example.markethub1.order.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private OrderRepo orderRepo;
    private ModelMapper modelMapper;

    @Override
    public void saveOrder(OrderDTO orderDTO) {
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
            return null;
    }

    @Override
    public OrderDTO updateOrder(Long orderId, OrderDTO orderDTO) {
        Optional<Order> optionalOrder = orderRepo.findById(orderId);
        if (optionalOrder.isPresent()){
            Order updatingOrder = optionalOrder.get();
            updatingOrder.setOrderCode(orderDTO.getOrderCode());
            updatingOrder.setDate(orderDTO.getDate());
            updatingOrder.setScore(orderDTO.getScore());
            updatingOrder.setReceiver(orderDTO.getReceiver());
            updatingOrder.setShippingCost(orderDTO.getShippingCost());
            updatingOrder.setTotalPayable(orderDTO.getTotalPayable());
            orderRepo.save(updatingOrder);
            return modelMapper.map(updatingOrder, OrderDTO.class);
        }
        else {
            System.out.println("This Id Not Found!!!");
            return null;
        }
    }

    @Override
    public void deleteOrder(Long orderId) {
        Optional<Order> optionalOrder = orderRepo.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order deletingOrder = optionalOrder.get();
            orderRepo.delete(deletingOrder);
        }
        else
            System.out.println("This Id Not Found!!!");
    }
}
