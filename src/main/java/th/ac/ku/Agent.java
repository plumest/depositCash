package th.ac.ku;

import java.util.HashMap;

public class Agent {
    private BankAccount bankAccount;
    private HashMap<String, Double> config;

    public Agent(BankAccount bankAccount, HashMap<String, Double> config) {
        this.bankAccount = bankAccount;
        this.config = config;
        if (!config.containsKey("minimumCashToDeposit")) {
            config.put("minimumCashToDeposit", 0.00);
        }
        if (!config.containsKey("limitedTransaction")) {
            config.put("limitedTransaction", Double.POSITIVE_INFINITY);
        }
        if (!config.containsKey("limitedCashPerDay")) {
            config.put("limitedCashPerDay", Double.POSITIVE_INFINITY);
        }
    }

    public boolean checkDepositPerTransaction(double depositCash) {
        if (config.get("minimumCashToDeposit") <= depositCash) {
            return depositCash <= config.get("limitedTransaction") && !bankAccount.getConfig().get("isSuspendAccount");
        } else {
            return false;
        }
    }

    public boolean checkDepositPerDay(double depositCash) {
        if (bankAccount.getWasDepositCashThisDay() < config.get("limitedCashPerDay") && config.get("minimumCashToDeposit") <= depositCash) {
            return depositCash <= config.get("limitedCashPerDay") - bankAccount.getWasDepositCashThisDay()  && !bankAccount.getConfig().get("isSuspendAccount");
        }
        return false;
    }
}
