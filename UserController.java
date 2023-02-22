package com.springpoc.app.controller;

import com.springpoc.app.entity.Cashkick;
import com.springpoc.app.entity.Contract;
import com.springpoc.app.entity.User;
import com.springpoc.app.model.CashkickModel;
import com.springpoc.app.model.ContractModel;
import com.springpoc.app.model.PaymentModel;
import com.springpoc.app.service.CashkickServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private CashkickServiceImpl cashkickServiceimpl;

    @PostMapping("/user")
    public User createNewUser(@RequestBody User user){
        return cashkickServiceimpl.addUser(user);
    }

    @PostMapping("/contract")
    public List<Contract> createContracts(@RequestBody List<Contract> contracts){
        return cashkickServiceimpl.addContracts(contracts);
    }

    @Transactional
    @PostMapping("/cashkick")
    public ResponseEntity<String> createNewCashkick(@RequestBody List<Cashkick> cashkick){
        return cashkickServiceimpl.addCashkick(cashkick);
    }


    @GetMapping("/cashkick/{userId}")
    public List<CashkickModel> getCashkicksByUserId(@PathVariable int userId){
        return  cashkickServiceimpl.getCashKicksByUserId(userId);
    }

    @GetMapping("/contract/{userId}")
    public List<ContractModel> getContractsByUserId(@PathVariable int userId){
       List<ContractModel> contracts= cashkickServiceimpl.getContractsByUserId(userId);
        return contracts;
    }

    @GetMapping("/payment/{userId}")
    public List<PaymentModel> getPaymentByUserId(@PathVariable int userId){
       return cashkickServiceimpl.getPaymentByUserId(userId);
    }
}
