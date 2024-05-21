package com.service.Controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.Models.Order;
import com.service.Models.Phone;
import com.service.Models.User;
import com.service.Repositories.OrderRepository;
import com.service.Repositories.PhoneRepository;
import com.service.Repositories.UserRepository;

@RestController
@RequestMapping("/api/order")
public class OrderController extends BaseController<Order, Long> {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final PhoneRepository phoneRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository, UserRepository userRepository, PhoneRepository phoneRepository) {
        super(orderRepository);
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.phoneRepository = phoneRepository;
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

    @GetMapping("/total-info/{orderId}")
    public ResponseEntity<Map<String, Object>> getOrderDetails(@PathVariable Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            Long userId = order.getUserId();
            Long phoneId = order.getPhoneId();

            Optional<User> userOptional = userRepository.findById(userId);
            Optional<Phone> phoneOptional = phoneRepository.findById(phoneId);

            if (userOptional.isPresent() && phoneOptional.isPresent()) {
                User user = userOptional.get();
                Phone phone = phoneOptional.get();

                Map<String, Object> response = new LinkedHashMap<>();
                response.put("orderId",                order.getId());
                response.put("totalPrice",             order.getTotalPrice());
                response.put("userName",               user.getName());
                response.put("userContactInformation", user.getContactInformation());
                response.put("phoneModel",             phone.getModel());
                response.put("phoneQuantity",          order.getQuantity());

                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
}