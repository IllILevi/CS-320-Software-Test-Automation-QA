package tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import classes.Contact;

class ContactTest {
	
	
	// Makes sure the Contact object is successfully created given valid inputs.
	@Test
	@DisplayName("Test a valid constructor")
	void testGoodConstructor() {
        Contact testContact = new Contact("Nathaniel", "Hawthorne", "1234567891", "123 burger street", "1");
        
		assertEquals("Nathaniel", testContact.getFirstName());
		assertEquals("Hawthorne", testContact.getLastName());
		assertEquals("1234567891", testContact.getPhoneNum());
		assertEquals("123 burger street", testContact.getAddress());
		assertEquals("1", testContact.getContactId());
	}
	
	// Validates exceptions for when first name is too long or null
	@Test
	@DisplayName("First name is too long or null")
	void testFirstNameInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Contact("ThisFirstNameIsTooLong", "Hawthorne", "1234567898", "123 burger street", "3");
        });
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Contact(null, "Hawthorne", "1234567898", "123 burger street", "3");
        });
	}
	
	
	// Validates exceptions for when last name is too long or null
	@Test
	@DisplayName("Last name is too long or null")
	void testLastNameInvalid() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Contact("Nathaniel", "ThisLastNameIsTooLong", "1234567898", "123 burger street", "3");
        });
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Contact("Nathaniel", null, "1234567898", "123 burger street", "3");
        });
	}
	
	
	// Validates exceptions for when phone number is not equal to 10 or null
	@Test
	@DisplayName("Phone Number is not equal to 10 or null")
	void testPhoneNumInvalid() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Contact("Nathaniel", "Hawthorne", "123456789", "123 burger street", "3");
        });
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Contact("Nathaniel", "Hawthorne", "123456789812", "123 burger street", "3");
        });
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Contact("Nathaniel", "Hawthorne", null, "123 burger street", "3");
        });
	}
	
	// Validates exceptions for when address is longer than 30 characters or null
	@Test
	@DisplayName("Address is null or longer than 30")
	void testAddressInvalid() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Contact("Nathaniel", "Hawthorne", "1234567891", "This address is most certainly way too long", "3");
        });
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Contact("Nathaniel", "Hawthorne", "1234567891", null, "3");
        });
	}
	
	// Validates exceptions for when contact ID is longer than 10 or null
	@Test
	@DisplayName("Contact ID is longer than 10 or null")
	void contactIdInvalid() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Contact("Nathaniel", "Hawthorne", "1234567891", "123 burger street", "12345678999999");
        });
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Contact("Nathaniel", "Hawthorne", "1234567891", "123 burger street", null);
        });
	}
	
	// Validates when first name is set
	@Test
	@DisplayName("Set first name is valid")
	void testSetFirstName() {
		Contact testContact = new Contact("Nathaniel", "Hawthorne", "1234567891", "123 burger street", "1");
		
		testContact.setFirstName("Charles");
		
		assertEquals("Charles", testContact.getFirstName());
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setFirstName("ThisFirstNameIsTooLong");
        });
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setFirstName(null);
        });
	}
	
	// Validates when last name is set
	@Test
	@DisplayName("Set last name is valid")
	void testSetlastName() {
		Contact testContact = new Contact("Nathaniel", "Hawthorne", "1234567891", "123 burger street", "1");
		
		testContact.setLastName("Dickens");
		
		assertEquals("Dickens", testContact.getLastName());
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setLastName("ThisLastNameIsTooLong");
        });
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setLastName(null);
        });
	}
	
	// Validates when phone number is set
	@Test
	@DisplayName("Set phone number is valid")
	void testSetPhoneNum() {
		Contact testContact = new Contact("Nathaniel", "Hawthorne", "1234567891", "123 burger street", "1");
		
		testContact.setPhoneNum("1987654321");
		
		assertEquals("1987654321", testContact.getPhoneNum());
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setPhoneNum("123456789");
        });
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setPhoneNum("123456789101112");
        });
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setPhoneNum(null);
        });
	}
	
	// Validates when address is set
	@Test
	@DisplayName("Set address is valid")
	void testSetAddress() {
		Contact testContact = new Contact("Nathaniel", "Hawthorne", "1234567891", "123 burger street", "1");
		
		testContact.setAddress("321 hotdog street");
		
		assertEquals("321 hotdog street", testContact.getAddress());
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setAddress("This address is most certainly way too long");
        });
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setAddress(null);
        });
	}
}
