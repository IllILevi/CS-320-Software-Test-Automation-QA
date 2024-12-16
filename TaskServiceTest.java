package tests;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import classes.Task;
import services.TaskService;

class TaskServiceTest {
	private TaskService taskService;

	// Helper method that create a new instance of TaskService object before each test
	@BeforeEach
	void setup() {
		taskService = new TaskService();
	}
	
	// Test if object is actually created
	@Test
	void testAddTask() {
		taskService.addTask("1", "TaskOne", "This is a good description");
		
		Task testTask = taskService.RetrieveTaskId("1");
		
		assertNotNull(testTask);
		assertEquals("1", testTask.getTaskId());
		assertEquals("TaskOne", testTask.getName());
		assertEquals("This is a good description", testTask.getDescription());
	}
	
	// Makes sure that each taskId has a unique ID and throws exception if not
	@Test
	void testAddTaskDuplicateId() {
		taskService.addTask("1", "TaskOne", "This is a good description");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	taskService.addTask("1", "TaskTwo", "This is also a good description");
        });
	}
	
	// Tests if task is actually deleted based on taskId and if taskId doesn't exist, throw exception
	@Test
	void testDeleteTask() {
		taskService.addTask("1", "TaskOne", "This is a good description");
		
		taskService.deleteTask("1");
		
		assertNull(taskService.RetrieveTaskId("1"));
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	taskService.deleteTask("1");
		});	
	}
	
	// Makes sure name is updated correctly
	@Test
	void testUpdateTaskName() {
		taskService.addTask("1", "TaskOne", "This is a good description");
		
		taskService.updateTaskName("1", "TaskTwo");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	taskService.updateTaskName("5", "TaskTwo");
        });
		
		Task testTask = taskService.RetrieveTaskId("1");
		
		assertEquals("1", testTask.getTaskId());
		assertEquals("TaskTwo", testTask.getName());
	}
	
	// Makes sure description is updated correctly
	@Test
	void testUpdateDescription() {
		taskService.addTask("1", "TaskOne", "This is a good description");
		
		taskService.updateTaskDescription("1", "This is also a good description");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	taskService.updateTaskDescription("5", "This is also a good description");
        });
		
		Task testTask = taskService.RetrieveTaskId("1");
		
		assertEquals("1", testTask.getTaskId());
		assertEquals("This is also a good description", testTask.getDescription());
		
	}
}
