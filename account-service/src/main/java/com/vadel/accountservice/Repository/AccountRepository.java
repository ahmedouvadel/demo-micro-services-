package com.vadel.accountservice.Repository;

import com.vadel.accountservice.Entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<BankAccount, String> {
}
