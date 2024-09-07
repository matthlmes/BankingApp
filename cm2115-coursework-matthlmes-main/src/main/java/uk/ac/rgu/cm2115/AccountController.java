package uk.ac.rgu.cm2115;

import java.io.IOException;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;

public class AccountController extends Controller<AccountManager>{

    @FXML 
    private Label accountNameLabel;

    @FXML 
    private Label accountSortCodeLabel;

    @FXML 
    private Label accountNumberLabel;

    @FXML 
    private Label accountBalanceLabel;

    @FXML 
    private Button BackToCustomerbtn;

    @FXML 
    private Button depositBtn;

    @FXML 
    private Button withdrawBtn;

    private int accountIndex;

    


    @Override
    public void setModel(AccountManager model) {
        this.model = model;
        this.accountIndex = this.model.getSelectedAccountIndex();
        populateScene();
        
    }

     
    public void populateScene(){

                //Sets Labels to Account Info
                this.accountNameLabel.setText(this.model.getCurrentAccounts().get(accountIndex).getAccountName());
                this.accountNumberLabel.setText("" + this.model.getCurrentAccounts().get(accountIndex).getAccountNumber());
                this.accountSortCodeLabel.setText("" + this.model.getCurrentAccounts().get(accountIndex).getSortCode());
                this.accountBalanceLabel.setText("" + this.model.getCurrentAccounts().get(accountIndex).getBalance());

        }

    
    @FXML
    public void depositButton() throws IOException{
        TextInputDialog depositInput = new TextInputDialog("Deposit Amount");
        depositInput.setHeaderText("Enter Deposit Amount");
        Optional<String> resultString = depositInput.showAndWait();
        
        //Converting optional string to string to integer
        String stringResult = resultString.get();
        int result = Integer.parseInt(stringResult);

        this.model.getCurrentAccounts().get(accountIndex).deposit(result);

        this.accountBalanceLabel.setText("" + this.model.getCurrentAccounts().get(accountIndex).getBalance());
    }

    @FXML
    public void withdrawButton() throws IOException{
        TextInputDialog depositInput = new TextInputDialog("Withdraw Amount");
        depositInput.setHeaderText("Enter Withdraw Amount");
        Optional<String> resultString = depositInput.showAndWait();
        
        //Converting optional string to string to integer
        String stringResult = resultString.get();
        int result = Integer.parseInt(stringResult);

        this.model.getCurrentAccounts().get(accountIndex).withdraw(result);

        this.accountBalanceLabel.setText("" + this.model.getCurrentAccounts().get(accountIndex).getBalance());

        //If withdraw does not go through shows warning alert
        if(this.model.getCurrentAccounts().get(accountIndex).withdraw(result) == false){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Insufficient Funds");
            alert.showAndWait();
        }


    }

    @FXML 
    public void BackToCustomerClick() throws IOException{
        MainApp.setScene("Customer", this.model);
    }
}
