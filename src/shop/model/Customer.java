package shop.model;

import shop.util.User;

public class Customer extends User {
    public Customer() {
    }
    
    public Customer(String username) {
		super(username);
	}

	public Customer(String username,String password) {
    	super(username,password);
    }

    public Customer(String phone,String firstName, String lastName, String gender, String nationalId) {
        super(firstName, lastName, gender, nationalId, phone);
    }

}
