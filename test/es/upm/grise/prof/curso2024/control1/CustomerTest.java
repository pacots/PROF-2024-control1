package es.upm.grise.prof.curso2024.control1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.beans.Transient;

class CustomerTest {

    @BeforeEach
    void setUp() {
        customer = new Customer();
        account1 = new Account("12345", 100.0f);
        account2 = new Account("67890", 200.0f);
        account3 = new Account("54321", 50.0f);

        customer.addAccount(account1);
        customer.addAccount(account2);
        customer.addAccount(account3);
    }

    @Test
    void testGetAccountWithHighestBalanceThrowsWhenNoAccounts() {

        customer = new Customer();

        assertThrows(NoAccountsException.class, customer::getAccountWithHighestBalance,
            "Expected NoAccountsException in getAccountWithHighestBalance(), but did not happen"
        );
    }


    @Test
    void testGetAccountWithHighestBalanceReturnsCorrectAccountNumber() {
        String expectedAccountNumber = account2.getAccountNumber();
        assertEquals(expectedAccountNumber, customer.getAccountWithHighestBalance());
    }

    @Test
    public void testGetAccountWithHighestBalance() throws NoAccountsException {
        final String ACCOUNT_1_NUMBER = "ACC12345";
        final String ACCOUNT_2_NUMBER = "ACC67890";
        final float ACCOUNT_1_BALANCE = 1000.0f;
        final float ACCOUNT_2_BALANCE = 2500.0f;

        Account account1 = mock(Account.class);
        Account account2 = mock(Account.class);

        when(account1.getAccountNumber()).thenReturn(ACCOUNT_1_NUMBER);
        when(account1.getCurrentBalance()).thenReturn(ACCOUNT_1_BALANCE);

        when(account2.getAccountNumber()).thenReturn(ACCOUNT_2_NUMBER);
        when(account2.getCurrentBalance()).thenReturn(ACCOUNT_2_BALANCE);

        Customer customer = new Customer();
        customer.addAccount(account1);
        customer.addAccount(account2);

        String result = customer.getAccountWithHighestBalance();

        assertEquals(ACCOUNT_2_NUMBER, result, "The account with the highest balance was not returned");
    }

}
