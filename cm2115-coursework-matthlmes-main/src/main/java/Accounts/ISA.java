package Accounts;

import uk.ac.rgu.cm2115.BankAccount;
import uk.ac.rgu.cm2115.SavingsAccount;

public class ISA extends BankAccount implements SavingsAccount{
    private int remainingAllowance;

    public ISA(String name, int accountNum, int sortCode, int Balance){
        super(name, accountNum, sortCode, Balance);
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
}
