package com.bank;

import com.bank.domain.ClientBankDomainImpl;
import com.bank.model.Account;
import com.bank.spi.AccountRepository;
import org.assertj.core.api.Fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
 class ClientBankDomainTest {

    public static final String CAN_T_FIND_ACCOUNT = "Can't find account.";
    public static final String CODE = "TEST_002";
    private final double value = 10;

    private ClientBankDomainImpl bankService;

    @InjectMocks
    private AccountRepository accountRepository;

    @BeforeEach
    public void setUp() {
        bankService = new ClientBankDomainImpl();
    }

    /*@Test
    void uselessTest() {
        Assertions.assertThat(1).isEqualTo(1);
    }*/

    //Check account
    @Test
    void checkBalanceAccount_OK() throws Exception {
        Account ac1 = getAccount();
        Double amountResult = bankService.checkBalanceAccount(CODE);
        assertEquals(ac1.getBalance(), amountResult);

    }

    @Test
    void checkBalanceAccount_NOK(){
        try{
            Double amountResult = bankService.checkBalanceAccount(CODE);
            Fail.fail("Didn't throw expected exception");
        }
        catch(Exception e)
        {
            assertEquals(CAN_T_FIND_ACCOUNT, e.getMessage());
        }

    }

    //DEPOSIT
    @Test
    void depositAccount_OK() throws Exception{
        Account ac1 = getAccount();

        Double amountResult = bankService.depositAccount(value, CODE);
        Double expectAmount = ac1.getBalance()+value;
        assertEquals(expectAmount, amountResult );

    }

    @Test
    void depositAccount_NOK(){
        try{
            Double amountResult = bankService.depositAccount(value, CODE);
            Fail.fail("Didn't throw expected exception");
        }
        catch(Exception e)
        {
            assertEquals(CAN_T_FIND_ACCOUNT, e.getMessage());
        }

    }

    //WITHDRAWAL
    @Test
    void withdrawalAccount_OK() throws Exception{
        Account ac1 = getAccount();

        Double amountResult = bankService.withdrawlAccount(value, CODE);
        Double expectAmount = ac1.getBalance()-value;
        assertEquals(expectAmount, amountResult );

    }

    @Test
    void withdrawalAccount_NOK(){
        try{
            Double amountResult = bankService.withdrawlAccount(value, CODE);
            Fail.fail("Didn't throw expected exception");
        }
        catch(Exception e)
        {
            assertEquals(CAN_T_FIND_ACCOUNT, e.getMessage());
        }

    }

    private Account getAccount() {
        Account ac1 = new Account(CODE);
        ac1.setBalance(100);
        accountRepository.save(ac1);
        return ac1;
    }

}
