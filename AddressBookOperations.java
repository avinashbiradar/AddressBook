package com.Project.AddressBook;
import java.util.*;
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
	@Override
	public void printAllDetails() {
		Set keys = addressBookContainer.keySet();
		Iterator iterate = keys.iterator();
		Collection<AddressBookContactDetails> getValues = addressBookContainer.values();
		iterate = getValues.iterator();
		while (iterate.hasNext()) {
			System.out.println("Details are : " + iterate.next());
		}
	}
	@Override
	public HashMap updateValue(long key, AddressBookContactDetails newaddressBook) {

		if (addressBookContainer.containsKey(key) == false) {
			System.out.println("Key Not Found");
		} else if (addressBookContainer.containsKey(key) == true) {
			addressBookContainer.put(key, newaddressBook);
			System.out.println("Values Updated");
		}
		return addressBookContainer;
	}
	@Override
	public void deleteAddress(long key) {

		if (addressBookContainer.containsKey(key) == false) {
			System.out.println("Invalid Key !!!!!!!");
		} else {
			addressBookContainer.remove(key);
			System.out.println(key + " Deleted Successfully");

		}

	}
	@Override
	public void sortByfirstName() {
		List<AddressBookContactDetails> value = new ArrayList<>();
		if (addressBookContainer != null) {
			value.addAll(addressBookContainer.values());
			Collections.sort(value, new Comparator<AddressBookContactDetails>() {
				public int compare(AddressBookContactDetails Person1, AddressBookContactDetails Person2) {
					return Person1.getfirstName().compareTo(Person2.getfirstName());
				}
			});
		}
		for (AddressBookContactDetails valueList : value) {
			System.out.println(valueList);
		}
	}
}