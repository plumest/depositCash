package th.ac.ku;

import java.util.HashMap;

public class BankAccount {
    private double remainingCash;
    private double wasDepositCashThisDay;
    private HashMap<String, Boolean> config;

    public BankAccount(double remainingCash, double wasDepositCashThisDay, HashMap<String, Boolean> config) {
        this.remainingCash = remainingCash;
        this.wasDepositCashThisDay = wasDepositCashThisDay;

        if (config == null) {
            HashMap<String, Boolean> bankAccountConfig = new HashMap<String, Boolean>();
            bankAccountConfig.put("isSuspendAccount", false);
            this.config = bankAccountConfig;
        } else {
            this.config = config;
            if (!config.containsKey("isSuspendAccount")) {
                config.put("isSuspendAccount", false);
            }
        }
    }

    double getRemainingCash() {
        return remainingCash;
    }

    double getWasDepositCashThisDay() {
        return wasDepositCashThisDay;
    }

    void setWasDepositCashThisDay(double wasDepositCashThisDay) {
        this.wasDepositCashThisDay = wasDepositCashThisDay;
    }

    void setRemainingCash(double cash) {
        this.remainingCash = cash;
    }

    public HashMap<String, Boolean> getConfig() {
        return config;
    }
}
