package uk.ac.rgu.cm2115;

public abstract class BankAccount {
    private int accountNumber;
    private int SortCode;
    private int balance;
    private final String accountName;

    //Constructor
    public BankAccount(String name, int accountNum, int sortCode, int Balance){
        accountNumber = accountNum;
        SortCode = sortCode;
        balance = Balance;
        accountName = name;
    }

    //Account Number Getter and Setter
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    //SortCode Getter and Setter
    public int getSortCode() {
        return SortCode;
    }

    public void setSortCode(int sortCode) {
        SortCode = sortCode;
    }

    //Balance Getter and Setter
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    //Account Name Getter
    public String getAccountName() {
        return accountName;
    }
    

    public boolean deposit(int amount){
        this.balance = balance + amount;
        return true;
    }

    public boolean withdraw(int amount){

        int newBal = balance - amount;

        if(newBal < 0){
            System.out.println("Insufficient funds");
            return false;
        }else{
            this.balance = newBal;
            return true;
        }
    }
    
}
