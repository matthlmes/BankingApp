package uk.ac.rgu.cm2115;

import java.util.ArrayList;

import Advanced_Technique.toCSV;

public class AccountManager{
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<String> names = new ArrayList<>();
    private int currentSelectedIndex;

    private ArrayList<BankAccount> currentAccounts = new ArrayList<>();
    
    public ArrayList<BankAccount> getCurrentAccounts(){
        return currentAccounts;
    }

    public void setCurrentAccounts(ArrayList<BankAccount> currentAccounts){
        this.currentAccounts = currentAccounts;
    }

    
    public ArrayList<String> getCustomers() {
        return this.names;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public boolean addCustomer(Customer customer){
        boolean result = this.customers.add(customer);
        names.add("Name: " + customer.getName() + " Address: " + customer.getAddress());

        return result;
    }

    public void updateCustomerDetails(String name, int index, String address){
        names.set(index, "Name: " + name + " Address: " + address);
    }

    public int getCurrentSelectedIndex(){
        return currentSelectedIndex;
    }

    public void setCurrentSelectedIndex(int currentSelectedIndex){
        this.currentSelectedIndex = currentSelectedIndex;
    }

    public Customer getCustomerObject(){
        Customer customer = this.customers.get(currentSelectedIndex);
        setCurrentAccounts(customer.getAccounts());
        return customer;
    }

    //Gets the index number of selected account in view list
    public int selectedAccountIndex;

    public int getSelectedAccountIndex() {
        return selectedAccountIndex;
    }

    public void setSelectedAccountIndex(int selectedAccountIndex) {
        this.selectedAccountIndex = selectedAccountIndex;
    }


    ArrayList<BankAccount> accs = new ArrayList<>();

    //Calls toCSV functions
    public void tocsv(){
       
        int custLength = customers.size();

        for (int i = 0; i < custLength; i++){
            Customer customer = this.customers.get(i);
            accs.addAll(customer.getAccounts());
        }


        toCSV.writeToCustomerCSV(customers, accs);
        System.out.println("File Created");
        
    }

}
