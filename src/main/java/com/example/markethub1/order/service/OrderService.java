package com.example.markethub1.order.service;

import com.example.markethub1.order.dto.OrderDTO;
import com.example.markethub1.order.entity.Order;
import java.util.List;

public interface OrderService {
    public void saveOrder(OrderDTO orderDTO);
    public List<OrderDTO> getAllOrders();
    public OrderDTO getOrderById(Long orderId);
    public void updateOrder(Long orderId, OrderDTO orderDTO);
    public void deleteOrder(Long orderId);
}
