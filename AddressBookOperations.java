package com.Project.AddressBook;
import java.util.*;
public class AddressBookOperations implements AddressBookInterface {

	HashMap<Long, AddressBookContactDetails> addressBookContainer = new HashMap<Long, AddressBookContactDetails>();
	Scanner input = new Scanner(System.in);

	public HashMap<Long, AddressBookContactDetails> save(long phoneNumber, AddressBookContactDetails AddressBook) {
		addressBookContainer.put(phoneNumber, AddressBook);
		return addressBookContainer;
	}

	@Override
	public AddressBookContactDetails newAddressBook() {
		AddressBookContactDetails AddressBook = new AddressBookContactDetails();
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
		AddressBook.setfirstName(firstName);
		AddressBook.setlastName(lastName);
		AddressBook.setAddress(address);
		AddressBook.setCity(city);
		AddressBook.setState(state);
		AddressBook.setZip(zip);
		AddressBook.setPhone(phone);
		return AddressBook;
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
	public HashMap updateValue(long key, AddressBookContactDetails addressBook) {

		if (addressBookContainer.containsKey(key) == false) {
			System.out.println("Key Not Found");
		} else if (addressBookContainer.containsKey(key) == true) {
			addressBookContainer.put(key, addressBook);
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
	@Override
	public void sortByZipCode() {

		List<AddressBookContactDetails> value = new ArrayList<>();
		if (addressBookContainer != null) {
			value.addAll(addressBookContainer.values());

			Collections.sort(value, new Comparator<AddressBookContactDetails>() {
				public int compare(AddressBookContactDetails Person1, AddressBookContactDetails Person2) {
					return Person1.getZip() - Person2.getZip();
				}
			});
		}
		for (AddressBookContactDetails sortedValue : value) {
			System.out.println(sortedValue);
		}
	}
	
	public void searchByCity(String icity, AddressBookContactDetails addressBook) {
	
			Set keys = addressBookContainer.keySet();
			Iterator iterate = keys.iterator();
			Collection<AddressBookContactDetails> getValues = addressBookContainer.values();
			iterate = getValues.iterator();
			while (iterate.hasNext()) 
			{
				System.out.println(addressBook.getCity() +"  "+ icity );
				if (addressBook.getCity().equals(icity)) 
				 { 
				    System.out.println("Details are : "+ addressBook.getfirstName()+"  "+addressBook.getlastName()+"  "+addressBook.getState()+"  "+addressBook.getPhone()+" "+addressBook.getZip());
			     }
				iterate.hasNext();
				break;
		}
				
	}
	public void searchByState(String inputState, AddressBookContactDetails addressBook) {
		
		Set keys = addressBookContainer.keySet();
		Iterator iterate = keys.iterator();
		Collection<AddressBookContactDetails> getValues = addressBookContainer.values();
		iterate = getValues.iterator();
		while (iterate.hasNext()) 
		{
			System.out.println(addressBook.getState() +"  "+ inputState );
			if (addressBook.getState().equals(inputState)) 
			 { 
			    System.out.println("Details are : "+ addressBook.getfirstName()+"  "+addressBook.getlastName()+"  "+addressBook.getPhone()+"  "+addressBook.getCity()+"  "+addressBook.getZip());
					
		     }
			iterate.hasNext();
			break;
	      }
	  }
			
  }

