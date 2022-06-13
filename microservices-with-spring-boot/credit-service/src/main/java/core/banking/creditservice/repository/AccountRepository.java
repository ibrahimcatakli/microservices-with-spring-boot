package core.banking.creditservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import core.banking.creditservice.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
}
