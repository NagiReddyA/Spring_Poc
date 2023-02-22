package com.springpoc.app.service;

import com.springpoc.app.entity.Cashkick;
import com.springpoc.app.entity.Contract;
import com.springpoc.app.entity.User;
import com.springpoc.app.model.CashkickModel;
import com.springpoc.app.model.ContractModel;
import com.springpoc.app.model.PaymentModel;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface CashkickService {
    List<CashkickModel> getCashKicksByUserId(int userId);
    public List<ContractModel> getContractsByUserId(int userId);

    public List<PaymentModel> getPaymentByUserId(int userId);

    public User addUser(User user);

    public List<Contract> addContracts(List<Contract> contracts);

    public ResponseEntity<String> addCashkick(List<Cashkick> cashkick);

}
