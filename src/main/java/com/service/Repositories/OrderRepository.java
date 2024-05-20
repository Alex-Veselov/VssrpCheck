package com.service.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.service.Models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}