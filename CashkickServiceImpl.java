package com.springpoc.app.service;

import com.springpoc.app.entity.Cashkick;
import com.springpoc.app.entity.Contract;
import com.springpoc.app.entity.Payment;
import com.springpoc.app.entity.User;
import com.springpoc.app.exceptions.EmptyInputException;
import com.springpoc.app.model.CashkickModel;
import com.springpoc.app.model.ContractModel;
import com.springpoc.app.model.PaymentModel;
import com.springpoc.app.repository.CashkickRepository;
import com.springpoc.app.repository.ContractRepository;
import com.springpoc.app.repository.PaymentRepository;
import com.springpoc.app.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import static com.springpoc.app.converter.ObjectMapperUtils.mapAll;

@Service
public class CashkickServiceImpl implements CashkickService {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CashkickRepository cashkickRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private ModelMapper modelMapper;


    public List<CashkickModel> getCashKicksByUserId(int userId) {
        List<Cashkick> cashKicks = cashkickRepository.findAllByUserId(userId);
        if(cashKicks.isEmpty()){
            throw new NoSuchElementException();
        }
        return mapAll(cashKicks, CashkickModel.class);
    }

    public List<ContractModel> getContractsByUserId(int userId) {
       List<Contract> contracts= contractRepository.findAllByUserId(userId);
        if(contracts.isEmpty()){
            throw new NoSuchElementException();
        }
        return mapAll(contracts, ContractModel.class);
    }


    public List<PaymentModel> getPaymentByUserId(int userId) {
       List<Payment> payments= paymentRepository.findAllByUserId(userId);
       if(payments.isEmpty()){
           throw new NoSuchElementException();
       }
        return mapAll(payments, PaymentModel.class);
    }

    @Override
    public User addUser(User user) {
        if(user.getUser_name() == null){
            throw new EmptyInputException("601","Please provide input,");
        }
       User savedUser= userRepository.save(user);
            return savedUser;
    }

    public List<Contract> addContracts(List<Contract> contracts) {
        if(contracts.get(0).getContract_name() == null){
            throw new EmptyInputException("600"," You are passing empty data, Please look into it.");
        }
        List<Contract> contractList=contractRepository.saveAll(contracts);
        return contractList;
    }

    public ResponseEntity<String> addCashkick(List<Cashkick> cashkick) {

        if(cashkick.get(0).getCashkick_name() == null){
            throw new EmptyInputException("600","you are passing empty data, Please look into it.");
        }
        Cashkick cash=new Cashkick();
        cash.setCashkick_name(cashkick.get(0).getCashkick_name());
        int userId=cashkick.get(0).getUser().getId();
        User user=new User();
        user.setId(userId);
        cash.setUser(user);
        List<ContractModel> contractsByUserId = this.getContractsByUserId(userId);
        long totalReceived = contractsByUserId.stream()
                .mapToLong(ContractModel:: getPayment_amount)
                .sum();
        long totalFinanced = (long) (totalReceived + (totalReceived * 0.12));
        cash.setTotal_received(totalReceived);
        cash.setTotal_financed(totalFinanced);
        cash.setStatus("Pending");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 12);
        Date maturityDate = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String maturityDateString = dateFormat.format(maturityDate);
        cash.setMaturity(maturityDate);
        cash.setContracts(contractRepository.findAllByUserId(userId));
        Payment payment = new Payment();
        payment.setDue_date(maturityDate);
        payment.setExpected_amount(totalFinanced);
        payment.setOutstanding_amount(totalReceived);
        payment.setStatus("Upcoming");
        payment.setUser(user);
        paymentRepository.save(payment);
        cashkickRepository.save(cash);
        return ResponseEntity.ok("New Cashkick created");
    }
}
