package com.example.markethub1.order.controller;

import com.example.markethub1.order.dto.OrderDTO;
import com.example.markethub1.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<OrderDTO> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable Long id){
        OrderDTO orderDTO = orderService.getOrderById(id);
        if(orderDTO != null)
            return new ResponseEntity<>(orderDTO, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderDTO orderDTO){
        orderService.saveOrder(orderDTO);
        return new ResponseEntity<>("Order created successfully!",HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateOrder(@PathVariable Long id, @RequestBody OrderDTO orderDTO){
        OrderDTO updatingOrderDTO = orderService.updateOrder(id, orderDTO);
        if (updatingOrderDTO != null)
            return new ResponseEntity<>("Order updated successfully!", HttpStatus.OK);
        else
            return new ResponseEntity<>("Order not found!", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id){
        OrderDTO deletingOrderDto = orderService.getOrderById(id);
        if (deletingOrderDto != null){
            orderService.deleteOrder(id);
            return new ResponseEntity<>("Order deleted successfully!", HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("Order not found!", HttpStatus.NOT_FOUND);
    }
}
