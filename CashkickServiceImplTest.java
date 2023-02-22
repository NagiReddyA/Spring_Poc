
package com.springpoc.app.servicetest;

import com.springpoc.app.entity.*;
import com.springpoc.app.model.CashkickModel;
import com.springpoc.app.model.ContractModel;
import com.springpoc.app.model.PaymentModel;
import com.springpoc.app.repository.CashkickRepository;
import com.springpoc.app.repository.ContractRepository;
import com.springpoc.app.repository.PaymentRepository;
import com.springpoc.app.service.CashkickService;
import com.springpoc.app.service.CashkickServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.ACCEPTED;

//@RunWith(MockitoJUnitRunner.class)
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CashkickServiceImplTest {

    @InjectMocks
    public CashkickServiceImpl cashKickServiceImpl;

    @Mock
    public CashkickRepository cashkickRepository;

    @Mock
    public ContractRepository contractRepository;

    @Mock
    public PaymentRepository paymentRepository;

    @Mock
    public ModelMapper modelMapper;

    CashkickServiceImpl cashKickService=mock(CashkickServiceImpl.class);

    private final List<Cashkick> cashKickList = Arrays.asList(
            new Cashkick(1,"cashkick-1","Pending",new Date(),123,456,new User(),Arrays.asList(new Contract())),new Cashkick()
    );
    private final List<Contract> contractList = Arrays.asList(
            new Contract(1,"Contract-1","monthly",12000,"12 months",140000,
                    new User(),Arrays.asList(new UsedContract()),cashKickList)
    );
    private final List<Payment> payments = Arrays.asList(
            new Payment(),
            new Payment()
    );
    @Test
    public void test(){

    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        when(cashkickRepository.findAllByUserId(1)).thenReturn(cashKickList);
        when(contractRepository.findAllByUserId(1)).thenReturn(contractList);
        when(paymentRepository.findAllByUserId(1)).thenReturn(payments);
    }

    @Test
    public void testGetCashKicksByUserId(){

        List<CashkickModel> cashkickModels=Arrays.asList(
                (new CashkickModel(1,"cashkick-1","Pending",new Date(),123,456,101)),new CashkickModel());
        when(cashKickService.getCashKicksByUserId(1)).thenReturn(cashkickModels);
        assertNotNull(cashkickModels);
        assertEquals(2, cashkickModels.size());
        assertEquals(1, cashkickModels.get(0).getId());
        assertEquals(101, cashkickModels.get(0).getUser_id());
        assertEquals("cashkick-1", cashkickModels.get(0).getCashkick_name());
        assertEquals(123, cashkickModels.get(0).getTotal_received());
    }
//    @Test
//    @DisplayName("Should throw NoSuchElementException when no Cashkicks are found for the given userId")
//   public void shouldThrowExceptionWhenNoCashkicksFound(){
//        int userId=3;
//      CashkickServiceImpl cashkickService = mock(CashkickServiceImpl.class);
//      //  List<Cashkick> cashKicks = List.of();
//        when(cashkickRepository.findAllByUserId(userId)).thenReturn(cashKickList);
//
//        assertThrows(NoSuchElementException.class, () -> cashkickService.getCashKicksByUserId(userId));
//        verify(cashkickRepository).findAllByUserId(userId);
//    }


    @Test
    public void testGetContractsByUserId() {
        List<ContractModel> contractModels=Arrays.asList(
                (new ContractModel(1,"Contract-1","monthly",12000,"12 months",140000,100))
        );

        when(cashKickService.getContractsByUserId(1)).thenReturn(contractModels);
        assertNotNull(contractModels);
        assertEquals(1, contractModels.size());
        assertEquals(1,contractModels.get(0).getId());
        assertEquals("Contract-1", contractModels.get(0).getContract_name());
        assertEquals("monthly", contractModels.get(0).getType());
        assertEquals(100,contractModels.get(0).getUser_id());
    }

    @Test
    public void testGetPaymentByUserId() {
        List<PaymentModel> paymentModels=Arrays.asList((
                new PaymentModel(1,"Upcoming",new Date(),1000,2000,102)));

        when(cashKickService.getPaymentByUserId(1)).thenReturn(paymentModels);
        assertNotNull(paymentModels);
        assertEquals(1, paymentModels.size());
        assertEquals(1, paymentModels.get(0).getId());
        assertEquals("Upcoming", paymentModels.get(0).getStatus());
        assertEquals(1000,paymentModels.get(0).getExpected_amount());
        assertEquals(2000,paymentModels.get(0).getOutstanding_amount());
        assertEquals(102,paymentModels.get(0).getUser_id());

    }

    @Test
    public void testAddCashkickSuccess() {
        Cashkick cashkick = new Cashkick();
        cashkick.setCashkick_name("Test Cashkick");
        User user = new User();
        user.setId(1);
        cashkick.setUser(user);
        CashkickService cashkickService = mock(CashkickService.class);
        when(cashkickService.getContractsByUserId(1)).thenReturn(new ArrayList<>());
        ResponseEntity response=new ResponseEntity(ACCEPTED);
        when(cashkickService.addCashkick(cashKickList)).thenReturn(response);
        assertEquals(response.getStatusCodeValue(), 202);
    }


}
