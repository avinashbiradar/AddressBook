package com.Project.AddressBook;

import java.util.HashMap;

public interface AddressBookInterface {

	public AddressBookContactDetails newAddressBook();
	public void printAllDetails();
	public HashMap<Long, AddressBookContactDetails> updateValue(long key, AddressBookContactDetails AddressBook);
	public void deleteAddress(long key);
}