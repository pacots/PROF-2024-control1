package es.upm.grise.prof.curso2024.control1;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class AccountTest {

    @Test
    public void testGetCurrentBalance() {
        // Constants for test data
        final float INITIAL_AMOUNT = 1000.0f;
        final float TRANSACTION_1_AMOUNT = 200.0f;
        final float TRANSACTION_2_AMOUNT = -150.0f;
        final float EXPECTED_BALANCE = 1050.0f;

        // Mock transactions
        Transaction transaction1 = mock(Transaction.class);
        Transaction transaction2 = mock(Transaction.class);

        // Configure mocks
        when(transaction1.getAmount()).thenReturn(TRANSACTION_1_AMOUNT);
        when(transaction2.getAmount()).thenReturn(TRANSACTION_2_AMOUNT);

        // Create an account and set up initial data
        Account account = new Account();
        account.setInitialAmount(INITIAL_AMOUNT);
        account.addTransaction(transaction1);
        account.addTransaction(transaction2);

        // Execute the method under test
        float result = account.getCurrentBalance();

        // Verify the result
        assertEquals(EXPECTED_BALANCE, result, 0.01, "The current balance should match the expected balance.");
    }
}
