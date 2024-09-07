package uk.ac.rgu.cm2115;

import java.util.ArrayList;

public class Customer {
    private String name;
    private String address;
    private ArrayList<BankAccount> accounts;
    private CustomerType type;

    //Default Constructor
    public Customer(){
        name = "Not Set";
        address = "Not Set";
        accounts = new ArrayList<>();
        type = CustomerType.Individual;
        
    }

    //Constructor
    public Customer(String name, String address, CustomerType type){
        this.name = name;
        this.address = address;
        accounts = new ArrayList<>();
        this.type = type;
    }


    //Name Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Address Getter and Setter
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //Accounts Getter and Setter
    public ArrayList<BankAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<BankAccount> accounts) {
        this.accounts = accounts;
    }

    //Type Getter and Setter
    public CustomerType getType() {
        return type;
    }

    public void setType(CustomerType type) {
        this.type = type;
    }

    public boolean openAccount(BankAccount account){
        boolean result = this.accounts.add(account);
        return result;
    }
    
    @Override
    public String toString() {
        return "{" + name + "::" + address + "::" + type + "}";
    }
}
