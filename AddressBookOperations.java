package com.Project.AddressBook;

import java.util.HashMap;
import java.util.Scanner;

public class AddressBookOperations implements AddressBookInterface {

	HashMap<Long, AddressBookContactDetails> addressBookContainer = new HashMap<Long, AddressBookContactDetails>();
	Scanner input = new Scanner(System.in);

	public HashMap<Long, AddressBookContactDetails> save(long phoneNumber, AddressBookContactDetails newAddressBook) {
		addressBookContainer.put(phoneNumber, newAddressBook);
		return addressBookContainer;
	}

	@Override
	public AddressBookContactDetails newAddressBook() {
		AddressBookContactDetails newAddressBook = new AddressBookContactDetails();
		System.out.println("Enter the First Name");
		String firstName = input.next();
		System.out.println("Enter the Last Name");
		String lastName = input.next();
		System.out.println("Enter The Address");
		String address = input.next();
		System.out.println("Enter the city");
		String city = input.next();
		System.out.println("Enter the state");
		String state = input.next();
		System.out.println("Enter the zip Code");
		int zip = input.nextInt();
		System.out.println("Enter the Phone number");
		long phone = input.nextLong();
		newAddressBook.setfirstName(firstName);
		newAddressBook.setlastName(lastName);
		newAddressBook.setAddress(address);
		newAddressBook.setCity(city);
		newAddressBook.setState(state);
		newAddressBook.setZip(zip);
		newAddressBook.setPhone(phone);
		return newAddressBook;
	}
	

}