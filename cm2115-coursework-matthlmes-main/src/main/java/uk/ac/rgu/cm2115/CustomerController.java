package uk.ac.rgu.cm2115;

import java.io.IOException;
import java.util.Optional;
import java.util.Random;

import Accounts.BasicAccount;
import Accounts.ISA;
import Accounts.RewardAccount;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;

public class CustomerController extends Controller<AccountManager>{

    @FXML
    private Label customerNameLabel;

    @FXML
    private Label customerAddressLabel;

    @FXML
    private Label customerTypeLabel;
    
    @FXML
    private ListView<String> accountListView;

    @FXML
    private ComboBox<AccountType> newAccountTypeComboBox;

    @FXML 
    private Button BackToAccManBtn;

    Random rand = new Random();

    private int selectedCustomerIndex;

    private Customer customer;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setModel(AccountManager model) {
        this.model = model;
        this.customer = this.model.getCustomerObject();
        this.selectedCustomerIndex = this.model.getCurrentSelectedIndex();
        populateScene();

        //Sets the ComboBox inputs
        this.newAccountTypeComboBox.getItems().addAll(
            AccountType.BasicAccount,
            AccountType.RewardAccount,
            AccountType.ISA);
    }

    @FXML
    private void AddNewAccount(){
        TextInputDialog nameInput = new TextInputDialog("Account Name");
        nameInput.setHeaderText("Enter Account Name");
        Optional<String> result = nameInput.showAndWait();

        this.setName(result.get());
        BankAccount account;

        AccountType accountType = newAccountTypeComboBox.getSelectionModel().getSelectedItem();

        //creates random numbers for Account number and Sort Code
        int accountNum = rand.nextInt(999999999);
        int sortCode = rand.nextInt(999999);

        int Balance = 0;

        //Checks account type and opens relevant Account
        if(accountType == AccountType.BasicAccount){
            account = new BasicAccount(this.getName(), accountNum, sortCode, Balance);
            this.customer.openAccount(account);
            this.accountListView.getItems().add(account.getAccountName());
        }
        else if (accountType == AccountType.RewardAccount){
            account = new RewardAccount(this.getName(), accountNum, sortCode, Balance);
            this.customer.openAccount(account);
            this.accountListView.getItems().add(account.getAccountName());
        }
        else if (accountType == AccountType.ISA){
            account = new ISA(this.getName(), accountNum, sortCode, Balance);
            this.customer.openAccount(account);
            this.accountListView.getItems().add(account.getAccountName());
        }
    }

    @FXML
    public void updateCustomerDetails(){
        //Gets new name and sets Customer object to new name
        TextInputDialog newNameInput = new TextInputDialog("Enter New Name");
        newNameInput.setHeaderText("Enter New Name");
        Optional<String> resultStringName = newNameInput.showAndWait();
        
        //Converting optional string to string
        String stringResultName = resultStringName.get();

        //Gets new Address and sets Customer object to new name
        TextInputDialog newAddressInput = new TextInputDialog("Enter New Address");
        newNameInput.setHeaderText("Enter New Address");
        Optional<String> resultStringAddress = newAddressInput.showAndWait();
        
        //Converting optional string to string
        String stringResultAddress = resultStringAddress.get();

        //Sets new Name and Address in Customer Object
        this.model.getCustomerObject().setAddress(stringResultAddress);
        this.model.getCustomerObject().setName(stringResultName);

        //Sends new Name and Address to update ListView Items
        this.model.updateCustomerDetails(stringResultName, selectedCustomerIndex, stringResultAddress);

        //Sets Labels to new Name and Address
        this.customerAddressLabel.setText(this.customer.getAddress());
        this.customerNameLabel.setText(this.customer.getName());
    }

    @FXML
    private void populateScene(){

        //Sets customer type to string
        String custType = this.customer.getType().toString();

        //Sets Labels to customer Info
        this.customerNameLabel.setText(this.customer.getName());
        this.customerAddressLabel.setText(this.customer.getAddress());
        this.customerTypeLabel.setText(custType);

        //Checks if Accounts is null, if not then populates List View of accounts
        if(this.model.getCurrentAccounts() == null){
            System.out.println("Accounts Empty");
        }else if (this.model.getCurrentAccounts() != null){
            for(int i = 0; i < this.model.getCurrentAccounts().size(); i++){
                this.accountListView.getItems().add(this.model.getCurrentAccounts().get(i).getAccountName());
            }
        }
    }

    @FXML
    public void ViewAccountButton() throws IOException{
        MainApp.setScene("Account", this.model);
    }

    @FXML
    public void BackToAccountManager() throws IOException{
        MainApp.setScene("AccountManager", this.model);
    }

    @FXML
    public void SelectedAccountClick() throws IOException{
       this.model.setSelectedAccountIndex(accountListView.getSelectionModel().getSelectedIndex());
    }

    
}
