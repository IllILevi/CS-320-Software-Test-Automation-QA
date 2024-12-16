package tests;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Date;

import classes.Appointment;

class AppointmentTest {
	
	// Helper function to get a future date
	private Date getFutureDate(int daysInTheFuture) {
		return new Date(System.currentTimeMillis() + daysInTheFuture * 86400000); // 86400000 is the number of milliseconds in 24 hours
	}
	
	// Tests if the appointment object was successfully created
	@Test
	public void testGoodConstructor() {
		
		// One day in the future
		Date futureDate = getFutureDate(1);
		
		Appointment testAppointment = new Appointment("123", futureDate, "This is a good description");
		
		assertEquals("123", testAppointment.getAppointmentId());
		assertEquals(futureDate, testAppointment.getAppointmentDate());
		assertEquals("This is a good description", testAppointment.getDescription());
	}
	
	// Tests if exceptions are thrown properly when appointmentId is null or longer than 10 characters
	@Test
	public void testInvalidAppointmentId() {
		Date futureDate = getFutureDate(1);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Appointment(null, futureDate, "This is a good description");
        });
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Appointment("This ID is way too long", futureDate, "This is a good description");
        });
	}
	
	// Tests if the proper exceptions are thrown when appointmentDate is in the past or null
	@Test
	public void testInvalidAppointmentDate() {
		Date pastDate = new Date(System.currentTimeMillis() - 86400000); // 24 hours in the past
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Appointment("123", null, "This is a good description");
        });
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Appointment("123", pastDate, "This is a good description");
        });
	}
	
	// Tests if the description is too long or null
	@Test
	public void testInvalidDescription() {
		Date futureDate = getFutureDate(1);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Appointment("123", futureDate, null);
        });
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Appointment("123", futureDate, "This is a bad description because it is most certainly way too long");
        });
	}
	
	// Tests if setter for appointmentDate is validated 
	@Test
	public void testSetAppointmentDate() {
		Date futureDate = getFutureDate(1); 
		Appointment appointment = new Appointment("123", futureDate, "This is a good description");
		
		Date newFutureDate = getFutureDate(5); // Five days in the future
		appointment.setAppointmentDate(newFutureDate);
		
		assertEquals(newFutureDate, appointment.getAppointmentDate());
		
		Date pastDate = new Date(System.currentTimeMillis() - 86400000); // 24 hours in the past
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	appointment.setAppointmentDate(null);
        });
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	appointment.setAppointmentDate(pastDate);
        });
	}
	
	// Tests if setter for description is validated 
	@Test
	public void testSetDescription() {
		Date futureDate = getFutureDate(1);
		Appointment appointment = new Appointment("123", futureDate, "This is a good description");
		
		appointment.setDescription("This is also a good description");
		
		assertEquals("This is also a good description", appointment.getDescription());
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	appointment.setDescription(null);
        });
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	appointment.setDescription("This is a bad description because it is most certainly way too long");
        });
	}
}