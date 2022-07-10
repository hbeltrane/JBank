import java.util.ArrayList;

import entity.Account;
import entity.Agent;
import entity.Customer;
import entity.Movement;
import ui.MainFrame;
import ui.SearchPanel;

public class Main {

	public static void main(String[] args) {
        /* This code creates a Java Frame */
        //MainFrame mainFrame = new MainFrame();  // Instantiate a MainFrame (JFrame) object
        
        Agent activeAgent = new Agent();
        // Login Test
        System.out.println("\n\n***** LOGIN TEST *****");
        int status = activeAgent.agentLogin("fboxe0", "ua8w6WmM", activeAgent);
        switch (status) {
        case 0:
        	System.out.println("Login OK\nWelcome " + activeAgent.getFirstName() + " " + activeAgent.getLastName());
        	break;
        case 1:
        case 2:
        	System.out.println("Login failed\nInvalid username or password");
        	break;
        case 99:
        	System.out.println("Login failed\nDatabase error");
        	break;
        default:
        	System.out.println("Login failed\nUnknown error");
        	break;
        }
        
        // Search test
        System.out.println("\n\n***** SEARCH TEST *****");
        ArrayList<Customer> resultCustomers = new ArrayList<Customer>();
        ArrayList<Account> resultAccounts = new ArrayList<Account>();
        activeAgent.agentSearch("0", resultCustomers, resultAccounts);
        System.out.println("\nCUSTOMERS:");
        for(int i=0; i<resultCustomers.size(); i++) {
        	System.out.print(resultCustomers.get(i).getFirstName() + "\n");
        }
        System.out.println("\nACCOUNTS:");
        for(int i=0; i<resultAccounts.size(); i++) {
        	System.out.print(resultAccounts.get(i).getAccNumber() + " " + resultAccounts.get(i).getAccType() + "\n");
        }
        
        // View customer test
        System.out.println("\n\n***** VIEW CUSTOMER TEST *****");
        Customer activeCustomer = new Customer(resultCustomers.get(0));
        ArrayList<Account> customerAccounts = new ArrayList<Account>();
        activeCustomer.viewCustomer(activeCustomer, customerAccounts);
        System.out.print("Customer ID: " + activeCustomer.getCustomerId() + "\nName: " + activeCustomer.getFirstName() + " " + activeCustomer.getLastName());
        System.out.println("\nCUSTOMER ACCOUNTS");
        for(int i=0; i<customerAccounts.size(); i++) {
        	System.out.print("\nAccount: " + customerAccounts.get(i).getAccNumber() + "\nAccount Type: " + customerAccounts.get(i).getAccType() + "\nBalance: " + customerAccounts.get(i).getBalance());
        }
        
        // View account test
        System.out.println("\n\n***** VIEW ACCOUNT TEST *****");
        Customer activeCustomer2 = new Customer();
        Account activeAccount = new Account(customerAccounts.get(0));
        ArrayList<Movement> accountMovements = new ArrayList<Movement>();
        activeAccount.viewAccount(activeCustomer2, activeAccount, accountMovements);
        System.out.print("Customer ID: " + activeCustomer2.getCustomerId() + "\nName: " + activeCustomer2.getFirstName() + " " + activeCustomer2.getLastName());
        System.out.print("\nAccount: " + activeAccount.getAccNumber() + "\nAccount Type: " + activeAccount.getAccType() + "\nBalance " + activeAccount.getBalance());
        System.out.println("\nACCOUNT MOVEMENTS");
        for(int i=0; i<accountMovements.size(); i++) {
        	System.out.print("\nDate: " + accountMovements.get(i).getMovementDate() + "\nDescription: " + accountMovements.get(i).getDescription() + "\nAmount: " + accountMovements.get(i).getAmount());
        }
    }
}