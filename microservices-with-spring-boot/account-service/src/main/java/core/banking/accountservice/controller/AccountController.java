package core.banking.accountservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.banking.accountservice.entity.Account;
import core.banking.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${account.jms.destination}")
    private String jmsQueue;


    @PostMapping("/addAccount")
    public Account addAccount(@RequestBody Account account) {
        return accountRepository.save(account);
    }

    @PostMapping("/addAccountList")
    public List<Account> addAccountList(@RequestBody List<Account> accounts) {
        return accountRepository.saveAll(accounts);
    }

    @GetMapping("/getAll")
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    @GetMapping("/info")
    public String getInfo() {
        return "account microservice";
    }

    @GetMapping("/sendToCredit/{id}")
    public ResponseEntity<Account> sendToCredit(@PathVariable long id) {

        Optional<Account> account = accountRepository.findById(id);

        if (!account.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try {

            ObjectMapper mapper = new ObjectMapper();

            String jsonInString = mapper.writeValueAsString(account.get());
            jmsTemplate.convertAndSend(jmsQueue, jsonInString);

            return new ResponseEntity<>(account.get(), HttpStatus.OK);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
