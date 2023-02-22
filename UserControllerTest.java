package com.springpoc.app.servicetest;

import com.springpoc.app.controller.UserController;
import com.springpoc.app.entity.Cashkick;
import com.springpoc.app.entity.Contract;
import com.springpoc.app.entity.User;
import com.springpoc.app.model.CashkickModel;
import com.springpoc.app.model.ContractModel;
import com.springpoc.app.model.PaymentModel;
import com.springpoc.app.service.CashkickServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private CashkickServiceImpl cashkickServiceimpl;

    @Test
    public void testCreateNewUser() {
        User user = new User();
        when(cashkickServiceimpl.addUser(user)).thenReturn(user);

        User result = userController.createNewUser(user);

        assertThat(result).isEqualTo(user);
    }

    @Test
    public void testCreateContracts() {
        List<Contract> contracts = Arrays.asList(new Contract(), new Contract());
        when(cashkickServiceimpl.addContracts(contracts)).thenReturn(contracts);

        List<Contract> result = userController.createContracts(contracts);

        assertThat(result).isEqualTo(contracts);
    }

    @Test
    public void testCreateNewCashkick() {
        List<Cashkick> cashkick = Arrays.asList(new Cashkick(), new Cashkick());
        when(cashkickServiceimpl.addCashkick(cashkick)).thenReturn(ResponseEntity.ok().build());

        ResponseEntity<String> result = userController.createNewCashkick(cashkick);

        assertThat(result.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    public void testGetCashkicksByUserId() {
        List<CashkickModel> cashkickModels = Arrays.asList(new CashkickModel(), new CashkickModel());
        when(cashkickServiceimpl.getCashKicksByUserId(any(int.class))).thenReturn(cashkickModels);

        List<CashkickModel> result = userController.getCashkicksByUserId(1);

        assertThat(result).isEqualTo(cashkickModels);
    }

    @Test
    void getContractsByUserId_Success() {
        int userId = 1;
        List<ContractModel> contractModels = Arrays.asList(
                (new ContractModel(1, "Contract-1", "monthly", 12000, "12 months", 140000, 100))
        );
        when(cashkickServiceimpl.getContractsByUserId(userId)).thenReturn(contractModels);

        List<ContractModel> actualContracts = userController.getContractsByUserId(userId);

        verify(cashkickServiceimpl).getContractsByUserId(userId);
        assertEquals(contractModels, actualContracts);
    }

    @Test
    void getPaymentByUserId_Success() {
        int userId = 1;
        List<PaymentModel> paymentModels = Arrays.asList((
                new PaymentModel(1, "Upcoming", new Date(), 1000, 2000, 102)));

        when(cashkickServiceimpl.getPaymentByUserId(userId)).thenReturn(paymentModels);

        List<PaymentModel> actualPayments = userController.getPaymentByUserId(userId);

        verify(cashkickServiceimpl).getPaymentByUserId(userId);
        assertEquals(paymentModels, actualPayments);
    }
}