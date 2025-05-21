package Calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    public void testValidAccountCreation() {
        BankAccount account = new BankAccount("Damien", 100000.0);
        assertEquals("Damien", account.getOwner());
        assertEquals(100000.0, account.getBalance());
    }

    @Test
    public void testInvalidAccountCreation() {
        assertThrows(IllegalArgumentException.class, () -> new BankAccount("Damien", -50.0));
    }

    @Test
    public void testDepositValidAmount() {
        BankAccount account = new BankAccount("Damien", 200.0);
        account.deposit(50.0);
        assertEquals(250.0, account.getBalance());
    }

    @Test
    public void testDepositInvalidAmount() {
        BankAccount account = new BankAccount("Damien", 100.0);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0));
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-20));
    }

    @Test
    public void testValidWithdrawal() {
        BankAccount account = new BankAccount("Damien", 150.0);
        account.withdraw(50.0);
        assertEquals(100.0, account.getBalance());
    }

    @Test
    public void testWithdrawMoreThanBalance() {
        BankAccount account = new BankAccount("Damien", 80.0);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(100.0));
    }

    @Test
    public void testWithdrawInvalidAmount() {
        BankAccount account = new BankAccount("Damien", 60.0);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0));
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-10));
    }
}

