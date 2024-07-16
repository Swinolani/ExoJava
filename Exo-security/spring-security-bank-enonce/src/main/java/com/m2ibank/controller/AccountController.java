package com.m2ibank.controller;

import com.m2ibank.dto.BaseResponseDto;
import com.m2ibank.dto.UserLoginDto;
import com.m2ibank.model.Accounts;
import com.m2ibank.repository.AccountsRepository;
import com.m2ibank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AccountController {

    @Autowired
    private AccountsRepository accountsRepository;


    @GetMapping("/myAccount")
    public List <Accounts> getAccountDetails(@RequestParam int id) {
       List<Accounts> accounts = accountsRepository.findByCustomerId(id);
        if (accounts != null ) {
            return accounts;
        }else {
            return null;
        }
    }

    @PostMapping("/createAccount")
    public Accounts createAccount(@RequestBody Accounts account) {
        return accountsRepository.save(account);
    }

}
