package th.ac.ku;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepositCashTest {
    @Test
    void deposit_Less_Than_30000_Result_Should_Be_True() {
        // Arrange
        boolean expectedResult = true;
        double depositCash = 5000.00;

        HashMap<String, Double> config = new HashMap<String, Double>();
        config.put("limitedTransaction", 30000.00);

        BankAccount bankAccount = new BankAccount(0, 0, null);
        Agent agent = new Agent(bankAccount, config);

        // Act
        boolean actualResult = agent.checkDepositPerTransaction(depositCash);

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void deposit_Equal_To_30000_Result_Should_Be_True() {
        // Arrange
        boolean expectedResult = true;
        double depositCash = 30000.00;

        HashMap<String, Double> config = new HashMap<String, Double>();
        config.put("limitedTransaction", 30000.00);

        BankAccount bankAccount = new BankAccount(0, 0, null);
        Agent agent = new Agent(bankAccount, config);

        // Act
        boolean actualResult = agent.checkDepositPerTransaction(depositCash);

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void deposit_More_Than_30000_Result_Should_Be_True() {
        // Arrange
        boolean expectedResult = false;
        double depositCash = 32000.00;

        HashMap<String, Double> config = new HashMap<String, Double>();
        config.put("limitedTransaction", 30000.00);

        BankAccount bankAccount = new BankAccount(0, 0, null);
        Agent agent = new Agent(bankAccount, config);

        // Act
        boolean actualResult = agent.checkDepositPerTransaction(depositCash);

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void deposit_Less_Than_50000_Per_Day_Result_Should_Be_True() {
        // Arrange
        boolean expectedResult = true;
        double depositCash = 30000.00;

        HashMap<String, Double> config = new HashMap<String, Double>();
        config.put("limitedCashPerDay", 50000.00);

        BankAccount bankAccount = new BankAccount(0, 0, null);
        Agent agent = new Agent(bankAccount, config);

        // Act
        boolean actualResult = agent.checkDepositPerDay(depositCash);

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void deposit_Equal_To_50000_Per_Day_Result_Should_Be_True() {
        // Arrange
        boolean expectedResult = true;
        double depositCash = 20000.00;

        HashMap<String, Double> config = new HashMap<String, Double>();
        config.put("limitedCashPerDay", 50000.00);

        BankAccount bankAccount = new BankAccount(0, 30000, null);
        Agent agent = new Agent(bankAccount, config);

        // Act
        boolean actualResult = agent.checkDepositPerDay(depositCash);

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void deposit_More_Than_50000_Per_Day_Result_Should_Be_False() {
        // Arrange
        boolean expectedResult = false;
        double depositCash = 30000.00;

        HashMap<String, Double> config = new HashMap<String, Double>();
        config.put("limitedCashPerDay", 50000.00);

        BankAccount bankAccount = new BankAccount(0, 30000, null);
        Agent agent = new Agent(bankAccount, config);

        // Act
        boolean actualResult = agent.checkDepositPerDay(depositCash);

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void deposit_With_Unsuspend_Account_Result_Should_Be_True() {
        // Arrange
        boolean expectedResult = true;
        double depositCash = 10000.00;

        HashMap<String, Double> config = new HashMap<String, Double>();

        HashMap<String, Boolean> bankAccountConfig = new HashMap<String, Boolean>();
        bankAccountConfig.put("isSuspendAccount", false);

        BankAccount bankAccount = new BankAccount(0, 0, bankAccountConfig);
        Agent agent = new Agent(bankAccount, config);

        // Act
        boolean actualResult = agent.checkDepositPerTransaction(depositCash);

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void deposit_With_Suspend_Account_Result_Should_Be_False() {
        // Arrange
        boolean expectedResult = false;
        double depositCash = 10000.00;

        HashMap<String, Double> config = new HashMap<String, Double>();

        HashMap<String, Boolean> bankAccountConfig = new HashMap<String, Boolean>();
        bankAccountConfig.put("isSuspendAccount", true);

        BankAccount bankAccount = new BankAccount(0, 0, bankAccountConfig);
        Agent agent = new Agent(bankAccount, config);

        // Act
        boolean actualResult = agent.checkDepositPerTransaction(depositCash);

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void deposit_More_Than_Minimum_Condition_Result_Should_Be_True() {
        // Arrange
        boolean expectedResult = true;
        double depositCash = 10000.00;

        HashMap<String, Double> config = new HashMap<String, Double>();
        config.put("minimumCashToDeposit", 100.00);

        BankAccount bankAccount = new BankAccount(0, 0, null);
        Agent agent = new Agent(bankAccount, config);

        // Act
        boolean actualResult = agent.checkDepositPerTransaction(depositCash);

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void deposit_Equal_To_Minimum_Condition_Result_Should_Be_True() {
        // Arrange
        boolean expectedResult = true;
        double depositCash = 100.00;

        HashMap<String, Double> config = new HashMap<String, Double>();
        config.put("minimumCashToDeposit", 100.00);

        BankAccount bankAccount = new BankAccount(0, 0, null);
        Agent agent = new Agent(bankAccount, config);

        // Act
        boolean actualResult = agent.checkDepositPerTransaction(depositCash);

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void deposit_Less_Than_Minimum_Condition_Result_Should_Be_False() {
        // Arrange
        boolean expectedResult = false;
        double depositCash = 1.00;

        HashMap<String, Double> config = new HashMap<String, Double>();
        config.put("minimumCashToDeposit", 100.00);

        BankAccount bankAccount = new BankAccount(0, 0, null);
        Agent agent = new Agent(bankAccount, config);

        // Act
        boolean actualResult = agent.checkDepositPerTransaction(depositCash);

        // Assert
        assertEquals(expectedResult, actualResult);
    }
}
