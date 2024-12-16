package tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.Task;

class TaskTest {
	
	Task testTask;
	
	// Helper method that creates a new Task object before each test
	@BeforeEach
	void setUp() {
		testTask = new Task("1", "TaskOne", "This is a good description");
	}
	
	// Makes sure the Task object is successfully created given valid inputs
	@Test
	void testGoodConstructor() {
		
		assertEquals("1", testTask.getTaskId());
		assertEquals("TaskOne", testTask.getName());
		assertEquals("This is a good description", testTask.getDescription());
	}
	
	// Validates exceptions for when taskId is too long or null
	@Test
	void testInvalidTaskId() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Task("123465789101112", "TaskOne", "This is a good description");
        });
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Task(null, "TaskOne", "This is a good description");
        });
	}
	
	// Validates exceptions for when name is too long or null
	@Test
	void testInvalidName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Task("1", "This task name is way too long", "This is a good description");
        });
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Task("1", null, "This is a good description");
        });
	}
	
	// Validates exceptions for when description is too long or null
	@Test
	void testInvalidDescription() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Task("1", "TaskOne", "This description is much too long and exceeds the character limit of 50 characters");
        });
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Task("1", "TaskOne", null);
        });
	}
	
	// Validates when name is set
	@Test
	void testSetName() {
		
		testTask.setName("TaskTwo");
		
		assertEquals("TaskTwo", testTask.getName());
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testTask.setName("This task name is way too long");
        });
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testTask.setName(null);
        });
	}
	
	// Validates when description is set
	@Test
	void testSetDescription() {
		
		testTask.setDescription("This is also a good description");
		
		assertEquals("This is also a good description", testTask.getDescription());
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testTask.setDescription("This description is much too long and exceeds the character limit of 50 characters");
        });
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testTask.setDescription(null);
        });
		
	}
}