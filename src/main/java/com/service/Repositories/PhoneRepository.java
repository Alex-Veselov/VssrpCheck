package com.service.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.service.Models.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

}