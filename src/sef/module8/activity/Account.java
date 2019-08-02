package sef.module8.activity;


/**
 * This class represents a simple representation of an account encapsulating
 * a name 
 * 
 * @author John Doe
 *
 */
public class Account {

	private String name;

	/**
	 * Creates an Account object with the specified name.  If the account name
	 * given violates the minimum requirements, then an AccountException is thrown
	 * 
	 * @param accountName
	 * @throws AccountException
	 */
	public  Account(String accountName) throws AccountException{

			if (accountName.length() < 5)
				throw new AccountException (AccountException.NAME_TOO_SHORT, accountName);
			boolean valid = true;
			char[] a = accountName.toCharArray();
			for (char c: a) {
				valid = ((c >= 'a') && (c <= 'z')) ||
						((c >= 'A') && (c <= 'Z')) ||
						((c >= '0') && (c <= '9'));
				if (!valid) {
					break;
				}
			}
			if (!valid) throw new AccountException (AccountException.NAME_TOO_SIMPLE, accountName);
			this.name = accountName;
	}
	
	
	/**
	 * Returns the account name
	 * 
	 * @return the account name
	 */
	public String getName(){
		return this.name;
	}
}
