import java.util.*;
import java.util.regex.Pattern;
public class OperationsOnCollections {
	HashSet<customerpayment> customerPayment1=new HashSet<customerpayment>();
	public void checkIfIdPresent(int custID) throws CustomerIdAlreadyUsedException{
		for(customerpayment cs:customerPayment1)
		{
			if(cs.getcustomerid()==custID)
				throw new CustomerIdAlreadyUsedException("Customer ID already used");
		}
	}
	public void validPhoneNumber(String phone) throws CustomerPhoneNumberException {
		String regex = "(0/91)?[7-9][0-9]{9}";
		 Pattern pat = Pattern.compile(regex);
		 if(!pat.matcher(phone).matches())
			 throw new CustomerPhoneNumberException();
	}
	public void addRecords() {
		Scanner sc=new Scanner(System.in);
		System.out.println("To add new customer, enter the details:");
		int customerId=0;
		boolean flag=true;
		int tries=0;
		while(flag) {
			try {
				
				System.out.println("Please Enter Customer ID(unique)");
				
				customerId=sc.nextInt();
				checkIfIdPresent(customerId);
				flag=false;
				
			}
			catch(CustomerIdAlreadyUsedException e) {
				//e.printStackTrace();
				if(tries<3) {
				System.out.println(e.getMessage());
				System.out.println("\nAttempts left: "+(3-tries));
				tries++;
				}
				else
				{
					System.out.println("Couldn't add a record");
					System.out.println("Reverting to main meun");
					return;
				}
			}
		}
		System.out.println("Enter Customer Name");
		sc.nextLine();
		String customerName=sc.nextLine();
		System.out.println("Enter Phone no");
		String phoneNo=sc.nextLine();
		try {
			validPhoneNumber(phoneNo);
			
		}catch(CustomerPhoneNumberException e)
		{
			phoneNo="NONE";
			System.out.println(e.toString());
		}
		System.out.println("Enter amount paid/bill amount");
		float payment=sc.nextFloat();
		customerPayment1.add(new customerpayment(customerId,customerName,phoneNo,payment));
		System.out.println("Record added successfully\n");
	}
	
	public void updateRecord() 
	{
		if(customerPayment1.isEmpty())
		{
			System.out.println("No records available. Cannot update.");
			return;
		}
		Scanner sc=new Scanner(System.in);
		int customerId=0;
		boolean flag=true;
		int tries=0;
		while(flag) {
			try {
				System.out.println("\nAttempts left: "+(3-tries));
				System.out.println("\nPlease provide proper Customer ID");
				if(tries<3) {
				customerId=sc.nextInt();
				checkIfIdPresent(customerId);
				tries++;
				System.out.println("Customer Id not available\n");
				}
				else
				{
					System.out.println("Reverting to main menu");
					return;
				}
			}
			catch(CustomerIdAlreadyUsedException e) {
				flag=false;
			}
		}
		
		customerpayment customer=null;
		for(customerpayment obj1:customerPayment1)
		{
			if(obj1.getcustomerid()==customerId)
				customer=obj1;
		}
		System.out.println("\nEnter the type of attribute to update:\n1:Name\n2:Phone number\n3:Amount");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("\nEnter name:");
			sc.nextLine();
			String name=sc.nextLine();
			customer.setName(name);
			break;
		case 2:
			System.out.println("\nEnter phone number:");
			sc.nextLine();
			String num=sc.nextLine();
			try {
				validPhoneNumber(num); 
			}
			catch(CustomerPhoneNumberException e) {
				num="NONE";
				System.out.println(e.toString());
			}
			customer.setPhoneNo(num);
			break;
		case 3:
			System.out.println("\nEnter amount:");
			float amount=sc.nextFloat();
			customer.setPayment(amount);
			break;
		}
		System.out.println("Updated succesfully");
	}
	
	public void viewRecords()
	{
		if(customerPayment1.size()>0)
		{
		System.out.println("Available records:");
		for(customerpayment element:customerPayment1) {
			System.out.println(element+"\n");
		}
		}
		else
			System.out.println("There are no records to show");
	}
	public void deleteRecord() {
		if(customerPayment1.isEmpty())
		{
			System.out.println("There are no records to delete.");
			return;
		}
		Scanner sc=new Scanner(System.in);
		int customerId=0;
		boolean flag=true;
		int tries=0;
		while(flag) {
			try {
				System.out.println("\nAttempts left: "+(3-tries));
				if(tries<3) {
					System.out.println("\nPlease provide proper Cusotmer id");
				customerId=sc.nextInt();
				checkIfIdPresent(customerId);
				tries++;
				System.out.println("Customer Id not available");
				}
				else
				{
					System.out.println("\nReverting to main menu\n");
					return;
				}
				}
			catch(CustomerIdAlreadyUsedException e) {
				flag=false;
			}
		}
		customerpayment obj=null;
		for(customerpayment cs: customerPayment1)
		{
			if(cs.getcustomerid()==customerId)
			{
				obj=cs;
				break;
			}
		}
		customerPayment1.remove(obj);
		System.out.println("The record has been deleted.");
		
	}
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		OperationsOnCollections o1=new OperationsOnCollections();
		int choice=0;
		boolean flag=true;
		while(flag) {
			System.out.println("\nOperations:\n1:Add record\n2:View record\n3:Update record\n4:Delete record\n5:Exit");
			choice = sc.nextInt();
			switch(choice)
			{
				case 1:
				  o1.addRecords();
				  break;
				case 2:
					o1.viewRecords();
					break;
				case 3:
					o1.updateRecord();
					break;
				case 4:
					o1.deleteRecord();
					break;
				case 5:
					System.out.println("\nThank you!");
					flag=false;
			}
			
			}
		
			
		}
	}

