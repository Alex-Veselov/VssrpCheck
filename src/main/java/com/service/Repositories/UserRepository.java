package com.service.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.service.Models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}