package models;

public class Owner {
	private int ownerId;
	private String email;
	private String phoneNumber;
	private String password;
	private String firstName;
	private String lastName;
	
	
	public Owner(int ownerId, String email, String phoneNumber, String password, String firstName, String lastName) {
		super();
		this.ownerId = ownerId;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	

	public Owner(String email, String phoneNumber, String password, String firstName, String lastName) {
		super();
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Owner [ownerId=" + ownerId + ", email=" + email + ", phoneNumber=" + phoneNumber + ", password="
				+ password + "]";
	}
	
	
	
}
