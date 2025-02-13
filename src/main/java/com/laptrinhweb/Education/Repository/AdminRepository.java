package com.laptrinhweb.Education.Repository;

import com.laptrinhweb.Education.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Optional<Admin> findByUsernameOrEmail(String username, String email);
}
