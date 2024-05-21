package com.service.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.Models.Order;
import com.service.Models.User;
import com.service.Repositories.OrderRepository;
import com.service.Repositories.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController<User, Long> {
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public UserController(UserRepository userRepository, OrderRepository orderRepository) {
        super(userRepository);
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            
            List<Order> orders = orderRepository.findByUser(user);
            orderRepository.deleteAll(orders);
            
            userRepository.delete(user);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}