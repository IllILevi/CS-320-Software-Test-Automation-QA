package tests;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import classes.Contact;
import services.ContactService;

class ContactServiceTest {
	
	private ContactService contactService;

	// Before each test there is a new instance of contactService
	@BeforeEach
	public void setUp() {
		contactService = new ContactService();
	}
	
	// Tests if a contact is actually created
	@Test
	public void testAddContact() {
		contactService.addContact("Nathaniel", "Hawthorne", "1234567890", "123 burger street", "1");
		
		Contact testContact = contactService.retrieveContactId("1");
		
		assertNotNull(testContact);
		assertEquals("Nathaniel", testContact.getFirstName());
		assertEquals("Hawthorne", testContact.getLastName());
		assertEquals("1234567890", testContact.getPhoneNum());
		assertEquals("123 burger street", testContact.getAddress());
		assertEquals("1", testContact.getContactId());
	}
	
	// Makes sure each contact has a unique contact ID and throws exception if not
	@Test 
	public void testAddDuplicateContactId() {
		contactService.addContact("Nathaniel", "Hawthorne", "1234567890", "123 burger street", "1");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	contactService.addContact("Charles", "Dickens", "0987654321", "321 hotdog street", "1");
        });
	}
	
	// Tests if contacts are successfully deleted
	@Test
	public void testDeleteContact() {
		contactService.addContact("Nathaniel", "Hawthorne", "1234567890", "123 burger street", "1");
		
		contactService.deleteContact("1");
		
		// Tests if contact ID that doesn't exists is attempted to be deleted, it throws exception
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	contactService.deleteContact("1");
		});	
	}
	
	// Tests if contact is updated correctly.
	@Test
	public void testUpdateContact() {
		contactService.addContact("Nathaniel", "Hawthorne", "1234567890", "123 burger street", "1");
		
		contactService.updateContact("Charles", "Dickens", "9876543210", "321 hotdog street", "1");
		
		Contact testContact = contactService.retrieveContactId("1");
		
		// Tests if contact ID exists to update it, throws exception if not
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContact("Charles", "Dickens", "9876543210", "321 hotdog street", "5");
		});	
		
		assertEquals("Charles", testContact.getFirstName());
		assertEquals("Dickens", testContact.getLastName());
		assertEquals("9876543210", testContact.getPhoneNum());
		assertEquals("321 hotdog street", testContact.getAddress());
	}

}
