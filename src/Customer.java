
public class Customer {		//add abstract later if abstract method is used
	protected String name;
	private String phone_no;
	private int customerid=0;
	Customer()				//constructor overloading
	{
		this.name="";
		this.phone_no="";
		//this.customerid=0;
	}
	Customer(String name)
	{
		this.name=name;
		this.phone_no="";
	}
	Customer(String name, String phnno)
	{
		this.name=name;
		//this.age=age;
		this.phone_no=phnno;
	}
	
	public void setcustomerid(int cusid)
	{
		this.customerid=cusid;
	}
	
	public int getcustomerid()
	{
		return this.customerid;
	}
	
	public void printdetails()
	{
		if(this.name.length()!=0)
			System.out.println("Name of the customer: "+this.name);
		else
			System.out.println("Name not provided");
		if(this.phone_no.length()!=0)
			System.out.println("Phone number of the customer: "+this.phone_no);
		else
			System.out.println("Phone number not provided");
	}
	//abstract void funct1();
}
