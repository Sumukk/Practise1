
public class CustomerPhoneNumberException extends Exception {
	public String toString()
	{
		return "Invalid Phone number. Phone number should have 10 numbers.\nPhone number will be saved as NONE.";
	}

}
