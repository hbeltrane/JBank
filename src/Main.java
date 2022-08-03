import java.util.ArrayList;

import entity.Account;
import entity.Agent;
import entity.Customer;
import entity.Movement;
import entity.Return;
import ui.MainFrame;
import ui.SearchPanel;

public class Main {

	public static void main(String[] args) {
        /* This code creates a Java Frame */
        MainFrame mainFrame = new MainFrame();  // Instantiate a MainFrame (JFrame) object
		
//        // Login Test
//        Agent activeAgent = new Agent();
//        Return operation = new Return();
//        System.out.println("\n\n***** LOGIN TEST *****");
//        activeAgent.agentLogin("fboxe0", "ua8w6WmM", activeAgent, operation);
//        if (operation.getCode() == "00") {
//        	System.out.println(operation.getCode() + " - " + operation.getMessage() + "\nWelcome " + activeAgent.getFirstName() + " " + activeAgent.getLastName());
//        }
//        else {
//        	System.out.println(operation.getCode() + " - " + operation.getMessage());
//        }
//
//        // Search test
//        operation = new Return();
//        System.out.println("\n\n***** SEARCH TEST *****");
//        ArrayList<Customer> resultCustomers = new ArrayList<Customer>();
//        ArrayList<Account> resultAccounts = new ArrayList<Account>();
//        activeAgent.agentSearchCustomers("0", resultCustomers, operation);
//        if (operation.getCode() == "00") {
//        	System.out.println("\nCUSTOMERS:");
//        	for(int i=0; i<resultCustomers.size(); i++) {
//        		System.out.print(resultCustomers.get(i).getFirstName() + "\n");
//        	}
//        }
//        else {
//        	System.out.println(operation.getCode() + " - " + operation.getMessage());
//        }
//        operation = new Return();
//        activeAgent.agentSearchAccounts("0", resultAccounts, operation);
//        if (operation.getCode() == "00") {
//        	System.out.println("\nACCOUNTS:");
//        	for(int i=0; i<resultAccounts.size(); i++) {
//        		System.out.print(resultAccounts.get(i).getAccNumber() + " " + resultAccounts.get(i).getAccType() + "\n");
//        	}
//        }
//        else {
//        	System.out.println(operation.getCode() + " - " + operation.getMessage());
//        }
//
//        // View customer test
//        operation = new Return();
//        System.out.println("\n\n***** VIEW CUSTOMER TEST *****");
//        Customer activeCustomer = new Customer(resultCustomers.get(0));
//        ArrayList<Account> customerAccounts = new ArrayList<Account>();
//        activeCustomer.viewCustomer(activeCustomer, customerAccounts, operation);
//        if (operation.getCode() == "00") {
//        	System.out.print("Customer ID: " + activeCustomer.getCustomerId() + "\nName: " + activeCustomer.getFirstName() + " " + activeCustomer.getLastName());
//        	System.out.println("\nCUSTOMER ACCOUNTS");
//        	for(int i=0; i<customerAccounts.size(); i++) {
//        		System.out.print("\nAccount: " + customerAccounts.get(i).getAccNumber() + "\nAccount Type: " + customerAccounts.get(i).getAccType() + "\nBalance: " + customerAccounts.get(i).getBalance());
//        	}
//        }
//        else {
//            System.out.println(operation.getCode() + " - " + operation.getMessage());
//        }
//
//        // View account test
//        operation = new Return();
//        System.out.println("\n\n***** VIEW ACCOUNT TEST *****");
//        Customer activeCustomer2 = new Customer();
//        Account activeAccount = new Account(customerAccounts.get(0));
//        ArrayList<Movement> accountMovements = new ArrayList<Movement>();
//        activeAccount.viewAccount(activeCustomer2, activeAccount, accountMovements, operation);
//        if (operation.getCode() == "00") {
//        	System.out.print("Customer ID: " + activeCustomer2.getCustomerId() + "\nName: " + activeCustomer2.getFirstName() + " " + activeCustomer2.getLastName());
//        	System.out.print("\nAccount: " + activeAccount.getAccNumber() + "\nAccount Type: " + activeAccount.getAccType() + "\nBalance " + activeAccount.getBalance());
//        	System.out.println("\nACCOUNT MOVEMENTS");
//        	for(int i=0; i<accountMovements.size(); i++) {
//        		System.out.print("\nDate: " + accountMovements.get(i).getMovementDate() + "\nDescription: " + accountMovements.get(i).getDescription() + "\nAmount: " + accountMovements.get(i).getAmount());
//        	}
//        }
//        else {
//        	System.out.println(operation.getCode() + " - " + operation.getMessage());
//        }
//
//        // Create customer test
//        operation = new Return();
//        System.out.println("\n\n***** CREATE CUSTOMER TEST *****");
//        activeCustomer = new Customer();
//        activeCustomer.setPin("1234");
//        activeCustomer.setFirstName("Test1");
//        activeCustomer.setLastName("Test1");
//        activeCustomer.setAddress("Test1 Test1 Test1");
//        activeCustomer.setPhoneNumber("9999999999");
//        activeCustomer.setEmail("test1@test.test1");
//        activeAgent.agentCreateCustomer(activeCustomer, activeAgent, operation);
//        if (operation.getCode() == "00") {
//        	System.out.print("New Customer ID: " + activeCustomer.getCustomerId() + "\nName: " + activeCustomer.getFirstName() + " " + activeCustomer.getLastName());
//        }
//        else {
//        	System.out.println(operation.getCode() + " - " + operation.getMessage());
//        }
//
//        // Update customer test
//        operation = new Return();
//        System.out.println("\n\n***** UPDATE CUSTOMER TEST *****");
//        activeCustomer.setPin("1234");
//        activeCustomer.setFirstName("newTest1");
//        activeCustomer.setLastName("newTest1");
//        activeCustomer.setAddress("Test1 Test1 Test1");
//        activeCustomer.setPhoneNumber("9999999999");
//        activeCustomer.setEmail("test1@test.test1");
//        activeCustomer.updateCustomer(activeCustomer, operation);
//        if (operation.getCode() == "00") {
//        	System.out.print("New Customer ID: " + activeCustomer.getCustomerId() + "\nName: " + activeCustomer.getFirstName() + " " + activeCustomer.getLastName());
//        }
//        else {
//        	System.out.println(operation.getCode() + " - " + operation.getMessage());
//        }
    }
}