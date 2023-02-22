package com.springpoc.app.servicetest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import com.springpoc.app.repository.CashkickRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.springpoc.app.entity.Cashkick;
import com.springpoc.app.entity.Contract;
import com.springpoc.app.entity.User;
import com.springpoc.app.model.CashkickModel;
import com.springpoc.app.service.CashkickService;
import com.springpoc.app.service.CashkickServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CashkickServiceTest {

    @Mock
    private CashkickServiceImpl cashkickServiceImpl;
    @Mock
    private CashkickRepository cashkickRepository;

    private User user;
    private Contract contract;
    private Cashkick cashkick;

    @Before
    public void setUp() {
        user = new User();
        user.setId(1);
        user.setUser_name("hi");

        contract = new Contract();
        contract.setId(1);
        contract.setUser(user);
        contract.setPayment_amount(100);

        cashkick = new Cashkick();
        cashkick.setId(1);
        cashkick.setUser(user);
        cashkick.setTotal_financed(50);
    }

    @Test
    public void testGetCashKicksByUserId() {
        List<CashkickModel> expectedCashkicks = new ArrayList<>();
        CashkickModel cashkickModel = new CashkickModel();
        cashkickModel.setId(1);
        cashkickModel.setUser_id(1);
        cashkickModel.setTotal_financed(50);
        expectedCashkicks.add(cashkickModel);

        Mockito.when(cashkickServiceImpl.getCashKicksByUserId(1)).thenReturn(expectedCashkicks);

        List<CashkickModel> actualCashkicks = cashkickServiceImpl.getCashKicksByUserId(1);
        assertNotNull(actualCashkicks);
        assertEquals(expectedCashkicks.size(), actualCashkicks.size());
        assertEquals(expectedCashkicks.get(0).getId(), actualCashkicks.get(0).getId());
    }

}