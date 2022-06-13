package core.banking.creditservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import core.banking.creditservice.entity.Account;
import core.banking.creditservice.repository.AccountRepository;

import java.util.List;

@RestController
@RequestMapping("/credit")
public class CreditController {

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/getCredits")
    List<Account> getCreditAccount() {
        return accountRepository.findAll();
    }

    @GetMapping("/deleteOne/{id}")
    void deleteAccount(@PathVariable Long id) {
        accountRepository.deleteById(id);
    }

    @GetMapping("/deleteAll")
    void deleteAccounts() {
        accountRepository.deleteAll();
    }

    @GetMapping("/info")
    String getInfo() {
        return "credit microservice";
    }
}
