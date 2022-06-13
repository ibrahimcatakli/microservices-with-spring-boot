package core.banking.creditservice.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import core.banking.creditservice.entity.Account;
import core.banking.creditservice.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsConsumer {

    @Autowired
    AccountRepository accountRepository;

    @JmsListener(destination = "${account.jms.destination}")
    public void consumeMessage(String data) {

        try {

            ObjectMapper mapper = new ObjectMapper();
            Account account = mapper.readValue(data, Account.class);
            account.setName(account.getName() + "account servisine eklendi.");
            accountRepository.save(account);

        } catch (JsonProcessingException e) {
            e.getStackTrace();
        }
    }

}
