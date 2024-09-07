package Accounts;

import uk.ac.rgu.cm2115.BankAccount;
import uk.ac.rgu.cm2115.CurrentAccount;

public class BasicAccount extends BankAccount implements CurrentAccount{


    public BasicAccount(String name, int accountNum, int sortCode, int Balance){
        super(name, accountNum, sortCode, Balance);
    }

    @Override
    public boolean processCardTransaction() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'processCardTransaction'");
    }
    
}
