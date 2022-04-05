public class demo {
	public static void main(String args[])
	{
		customerpayment customerpayment1=new customerpayment();
		customerpayment customerpayment2=new customerpayment("Naruto",67.9f);
		customerpayment customerpayment3=new customerpayment("Sasuke","1234567890",67.9f);
		customerpayment customerpayment4=new customerpayment(65.78f);
		Customer customer4;
		
		customerpayment1.printdetails();
		System.out.println(customerpayment1.payment);
		System.out.println(customerpayment1.finalpayment+"\n");
		
		customerpayment2.printdetails();
		customerpayment2.finalpayment(customerpayment2.payment);
		System.out.printf("%.1f\n", customerpayment2.finalpayment);
		System.out.println(customerpayment2.finalpayment+"\n");
		
		customerpayment3.printdetails();
		customerpayment4.printdetails();
		
		customer4=customerpayment1;
		customer4.printdetails();
		
		customer4=customerpayment2;
		//System.out.println(customer4.payments); gives error as customer4 is object of customer class which doesn't have payment attribute.
		customer4.printdetails();
		
		customer4=customerpayment3;
		customer4.printdetails();
		
		customer4.setcustomerid(104);
		System.out.println("customer id of 4 is "+customer4.getcustomerid());		
		
		customerpayment1.setcustomerid(101);
		System.out.println("customer id of 1 is "+customerpayment1.getcustomerid());
	}
}
