package services;

import classes.Contact;
import java.util.HashMap;
import java.util.Map;

public class ContactService {
	
	// Creates map to hold contacts
	private Map<String, Contact> contacts;  
	
	public ContactService() {
		this.contacts = new HashMap<>();
	}
	
	// Adds contact info when given arguments, if contact ID already exists in map, throw exception
	public void addContact(String firstName, String lastName, String phoneNum, String address, String contactId) {
		if (contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact Id already exists");
		}
		Contact contact = new Contact(firstName, lastName, phoneNum, address, contactId);
		contacts.put(contactId, contact);
	}
	
	// Deletes contact by contact ID, if contactId is not in map, throw exception else remove contactID from map
	public void deleteContact(String contactId) {
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact Id doesn't exist");	
		}
		contacts.remove(contactId);
	}
	
	// Updates contact info based on contact ID
	public void updateContact(String firstName, String lastName, String phoneNum, String address, String contactId) {
		Contact contact = contacts.get(contactId);
		
		if (contact == null) {
			throw new IllegalArgumentException("Contact Id not found");
		}
		
		if (firstName != null && firstName.length() <= 10) {
			contact.setFirstName(firstName);
		}
		
		if (lastName != null && lastName.length() <= 10) {
			contact.setLastName(lastName);
		}
		
		if (phoneNum != null && phoneNum.length() == 10) {
			contact.setPhoneNum(phoneNum);
		}
		
		if (address != null && address.length() <= 30) {
			contact.setAddress(address);
		}
	}
	
	// gets contact ID from map
	public Contact retrieveContactId(String contactId) {
		return  contacts.get(contactId);
	}

}
