package com.laptrinhweb.Education.Repository;

import com.laptrinhweb.Education.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountReposiroty extends JpaRepository<Account, Integer> {
    Optional<Account> findByUsername(String username);
}
