package com.service.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.Models.Order;
import com.service.Models.User;
import com.service.Repositories.OrderRepository;
import com.service.Repositories.UserRepository;

@RestController
@RequestMapping("/api/order")
public class OrderController extends BaseController<Order, Long> {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository, UserRepository userRepository) {
        super(orderRepository);
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/total-price/{userId}")
    public ResponseEntity<Double> getTotalCostForUser(@PathVariable Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            List<Order> orders = orderRepository.findByUser(user);
            double totalCost = orders.stream()
                    .mapToDouble(Order::getTotalPrice)
                    .sum();
            return ResponseEntity.ok(totalCost);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}