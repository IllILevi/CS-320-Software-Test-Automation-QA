package services;

import classes.Appointment;
import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
	
	// Creates a map to store appointments
	private Map<String, Appointment> appointments;
	
	public AppointmentService() {
		this.appointments = new HashMap<>();
	}
	
	
	// Takes in arguments of Appointment object, If appointmentId is already in HashMap, throw exception, otherwise put it into HashMap
	public void addAppointment(Appointment appointment) {
		if (appointments.containsKey(appointment.getAppointmentId())) {
			throw new IllegalArgumentException("Appointment ID already exists");
		}
		appointments.put(appointment.getAppointmentId(), appointment);
	}
	
	// If specified appointmentId isn't in HashMap, throw exception, otherwise remove appointmentId
	public void deleteAppointment(String appointmentId) {
		if (!appointments.containsKey(appointmentId)) {
			throw new IllegalArgumentException("Appointment ID does not exist");
		}
		appointments.remove(appointmentId);
	}
	
	// Gets appointmentId from HashMap
	public Appointment retrieveAppointmentId(String appointmentId) {
		return appointments.get(appointmentId);
	}

}
