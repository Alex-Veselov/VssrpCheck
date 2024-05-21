package com.service.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.service.Models.Order;
import com.service.Models.Phone;
import com.service.Models.User;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
    List<Order> findByPhone(Phone phone);
}