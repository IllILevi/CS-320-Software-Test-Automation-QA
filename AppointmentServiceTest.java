package tests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import classes.Appointment;
import services.AppointmentService;

class AppointmentServiceTest {

	AppointmentService appointmentService;
	
	// Helper function to get a future date
	private Date getFutureDate(int daysInTheFuture) {
		return new Date(System.currentTimeMillis() + daysInTheFuture * 86400000); // 86400000 is the number of milliseconds in 24 hours
	}
	
	// Helper method that create a new instance of AppointmentService object before each test
	@BeforeEach
	void setUp() {
		appointmentService = new AppointmentService();
	}
	
	// Tests if object is successfully created
	@Test
	public void testAddAppointment() {
		Date futureDate = getFutureDate(1);
		Appointment testAppointment = new Appointment("123", futureDate, "This is a good description");
		
		appointmentService.addAppointment(testAppointment);
		
		assertEquals(testAppointment, appointmentService.retrieveAppointmentId("123"));
	}
	
	// Makes sure that each appointmentId is unique and throws exception if not 
	@Test
	public void testAddDuplicate() {
		Date futureDate = getFutureDate(1);
		Appointment testAppointment = new Appointment("123", futureDate, "This is a good description");
		
		appointmentService.addAppointment(testAppointment);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	appointmentService.addAppointment(testAppointment);
        });
	}
	
	// Tests if appointment is properly deleted based on appointmentId
	@Test
	public void testDeleteAppointment() {
		Date futureDate = getFutureDate(1);
		Appointment testAppointment = new Appointment("123", futureDate, "This is a good description");
		
		appointmentService.addAppointment(testAppointment);
		appointmentService.deleteAppointment("123");
		
		assertNull(appointmentService.retrieveAppointmentId("123"));
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	appointmentService.deleteAppointment("123");
        });
	}

}
