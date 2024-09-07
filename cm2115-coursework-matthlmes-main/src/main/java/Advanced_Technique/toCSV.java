package Advanced_Technique;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import uk.ac.rgu.cm2115.BankAccount;
import uk.ac.rgu.cm2115.Customer;


public class toCSV {

	private static final String CSV_SEPERATOR = ",";

    public static void writeToCustomerCSV(ArrayList<Customer> customer, ArrayList<BankAccount> accounts){

		try{
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("customers.csv"), "UTF-8"));

			for (Customer cust : customer){
				StringBuffer oneLine = new StringBuffer();
				oneLine.append(cust.getName());
				oneLine.append(CSV_SEPERATOR);
				oneLine.append(cust.getAddress());
				oneLine.append(CSV_SEPERATOR);
				oneLine.append(cust.getType().toString());

				for(BankAccount acc : accounts){
					oneLine.append(CSV_SEPERATOR);
					oneLine.append(acc.getAccountName());
					oneLine.append(CSV_SEPERATOR);
					oneLine.append(acc.getAccountNumber());
					oneLine.append(CSV_SEPERATOR);
					oneLine.append(acc.getBalance());
					oneLine.append(CSV_SEPERATOR);
					oneLine.append(acc.getSortCode());
				}
				bw.write(oneLine.toString());
				bw.newLine();
			}
			bw.flush();
			bw.close();
		}
		catch (UnsupportedEncodingException e) {}
		catch (FileNotFoundException e ){}
		catch (IOException e) {}
		

	}

}
