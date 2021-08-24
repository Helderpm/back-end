package com.bank;

import com.bank.domain.ClientBankDomainImpl;
import com.bank.model.Account;
import com.bank.spi.AccountRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

public class StepDefinitions {

    private int element;
    private int result;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ClientBankDomainImpl bankService;
    private Double balance = 0.0;

    public StepDefinitions(final AccountRepository accountRepository, final ClientBankDomainImpl bankService) {
        this.accountRepository = accountRepository;
        this.bankService = bankService;
    }

    @Given("the number '{}'")
    public void initElement(int element) {
        this.element = element;
    }

    @When("the number is multiplied by '{}'")
    public void doMultiply(int mult) {
        this.result = element * mult;
    }

    @When("the result should be '{}'")
    public void checkResult(int expectedResult) {
        Assertions.assertThat(this.result).isEqualTo(expectedResult);
    }



    @Given("I am a client with {string} on my account {string}")
    public void iAmAClientWithOnMyAccountTEST_(String value, String code) {
        Account account = new Account(code);
        account.setBalance(Double.parseDouble(value));
        accountRepository.save(account);

    }

    //Scenario : a client should be able to read his accounts
    @When("I check my account {string}")
    public void iCheckMyAccountTEST_(String code) throws Exception {
        balance = bankService.checkBalanceAccount(code);
    }

    //Scenario : a client should be able to make a deposit on his accounts
    @When("I deposit {string} on my account {string}")
    public void iDepositOnMyAccountTEST_(String value, String code) throws Exception {
        balance = bankService.depositAccount(Double.parseDouble(value),code);
    }

    //Scenario : a client should be able to make a withdraw on his accounts
    @When("I withdraw {string} from my account {string}")
    public void iWithdrawFromMyAccountTEST_(String value, String code) throws Exception {
        balance = bankService.withdrawlAccount(Double.parseDouble(value),code);
    }

    @Then("my balance should be {string}")
    public void myBalanceShouldBeTEST_(String expectedBalance) {
        Assertions.assertThat(this.balance).isEqualTo(Double.parseDouble(expectedBalance));
    }

}
