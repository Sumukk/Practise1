
public class customerpayment extends Customer implements finalpaymentinterface{
	float payment;
	double finalpayment=0.0;
	customerpayment()
	{
		super();
		this.payment=0.0f;
	}
	customerpayment(float payment)
	{
		super();
		this.payment=payment;
	}
	customerpayment(String name, float payment)
	{
		super(name);
		this.payment=payment;
	}
	customerpayment(String name, String phoneno, float payment)
	{
		super(name,phoneno);
		this.payment=payment;
	}
	//override
	public void printdetails()
	{
		super.printdetails();
		//System.out.println("Adding other statements here");
		System.out.println("Payment made: "+this.payment);
		System.out.println();
		
	}
	public void finalpayment(float payment)
	{
		this.finalpayment=payment+(0.1*payment);
	}
}
