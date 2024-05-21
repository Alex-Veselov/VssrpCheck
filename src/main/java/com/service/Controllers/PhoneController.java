package com.service.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.Models.Order;
import com.service.Models.Phone;
import com.service.Models.User;
import com.service.Repositories.OrderRepository;
import com.service.Repositories.PhoneRepository;

@RestController
@RequestMapping("/api/phone")
public class PhoneController extends BaseController<Phone, Long> {
    private final PhoneRepository phoneRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public PhoneController(PhoneRepository userRepository, OrderRepository orderRepository) {
        super(userRepository);
        this.phoneRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Phone> phoneOptional = phoneRepository.findById(id);
        if (phoneOptional.isPresent()) {
            Phone phone = phoneOptional.get();
            
            List<Order> orders = orderRepository.findByPhone(phone);
            orderRepository.deleteAll(orders);
            
            phoneRepository.delete(phone);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}