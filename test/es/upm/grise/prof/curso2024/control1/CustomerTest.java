package es.upm.grise.prof.curso2024.control1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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

        assertThrows(NoAccountsException.class, customer::getAccountWithHighestBalance,
            "Expected NoAccountsException in getAccountWithHighestBalance(), but did not happen"
        );
    }


    @Test
    void testGetAccountWithHighestBalanceReturnsCorrectAccountNumber() {
        String expectedAccountNumber = account2.getAccountNumber();
        assertEquals(expectedAccountNumber, customer.getAccountWithHighestBalance());
    }
}
