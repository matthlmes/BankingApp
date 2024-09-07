package Accounts;

import java.util.ArrayList;

import uk.ac.rgu.cm2115.BankAccount;
import uk.ac.rgu.cm2115.CurrentAccount;
import uk.ac.rgu.cm2115.SavingsAccount;

public class RewardAccount extends BankAccount implements CurrentAccount, SavingsAccount{
    private ArrayList<String> rewards;

    public RewardAccount(String name, int accountNum, int sortCode, int Balance){
        super(name, accountNum, sortCode, Balance);
    }

    public void addReward(String reward){
        
    }

    @Override
    public void applyInterest() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'applyInterest'");
    }

    @Override
    public int getInterestRate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInterestRate'");
    }

    @Override
    public void setInterestRate(int rate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setInterestRate'");
    }

    @Override
    public boolean processCardTransaction() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'processCardTransaction'");
    }
}
