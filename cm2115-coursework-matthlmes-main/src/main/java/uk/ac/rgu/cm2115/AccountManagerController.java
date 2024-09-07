package uk.ac.rgu.cm2115;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AccountManagerController extends Controller<AccountManager>{

    @FXML
    private ListView<String> CustomerList;

    @FXML
    private TextField newCustomerNameTextField;

    @FXML
    private TextField newCustomerAddressTextField;

    @FXML
    private ComboBox<CustomerType> newCustomerAccountTypeComboBox;

    @FXML
    private Button AddNewCustomerButton;

    @FXML
    private Button ViewSelectedCustomerBtn;


    @Override
    public void setModel(AccountManager model){
        this.model = model;
        this.CustomerList.getItems().addAll(this.model.getCustomers());

        //Sets the ComboBox inputs
        this.newCustomerAccountTypeComboBox.getItems().addAll(
            CustomerType.Individual,
            CustomerType.Business,
            CustomerType.Charity);

        // Clears and Updates the customer list view
        CustomerList.getItems().clear();
        CustomerList.getItems().addAll(model.getCustomers());
    }

    @FXML
    public void AddNewCustomer() throws IOException{
        //Getting new customer variables via inputs
        String newCustomerName = newCustomerNameTextField.getText();
        String newCustomerAddress = newCustomerAddressTextField.getText();
        CustomerType newCustomerType = newCustomerAccountTypeComboBox.getSelectionModel().getSelectedItem();

        //Creates and Adds new Customer
        Customer newCustomer = new Customer(newCustomerName, newCustomerAddress, newCustomerType);
        model.addCustomer(newCustomer);

        // Clears and Updates the customer list view
        CustomerList.getItems().clear();
        CustomerList.getItems().addAll(model.getCustomers());

        // Clears the new customer fields
        newCustomerNameTextField.setText("");
        newCustomerAddressTextField.setText("");
        newCustomerAccountTypeComboBox.getSelectionModel().select(-1);

    }

    @FXML
    public void getCustIndex(){
        this.model.setCurrentSelectedIndex(this.CustomerList.getSelectionModel().getSelectedIndex());
    }

    @FXML
    public void ViewCustomerButtonClick() throws IOException{
        getCustIndex();
        MainApp.setScene("Customer", this.model);
    }

    //Calls tocsv function in account manager which calls toCSV function in toCSV.java
    @FXML
    public void toCSVClick() throws IOException{
        this.model.tocsv();
    }

}
 