package services;

import classes.Task;
import java.util.HashMap;
import java.util.Map;

public class TaskService {
	// Creates a map to store tasks
	private final Map<String, Task> tasks;
	
	public TaskService() {
		this.tasks = new HashMap<>();
	}
	
	// Adds new task when given arguments and puts it into map, if taskId already exists in map, throw exception
	public void addTask(String taskId, String name, String description) {
		if (tasks.containsKey(taskId)) {
			throw new IllegalArgumentException("Task ID must be unique");
		}
		
		Task task = new Task(taskId, name, description);
		tasks.put(taskId, task);
	}
	
	// deletes task based on taskId, if no taskId is found, throws exception
	public void deleteTask(String taskId) {
		if (!tasks.containsKey(taskId)) {
			throw new IllegalArgumentException("Task ID does not exist");
		}
		
		tasks.remove(taskId);
	}
	
	// Updates task name based on taskId
	public void updateTaskName(String taskId, String name) {
		Task task = tasks.get(taskId);
		
		if (task == null) {
			throw new IllegalArgumentException("task ID not found");
		}
		
		if (name != null && name.length() <= 10) {
			task.setName(name);
		}
	}
	
	// Updates task description based on taskId
	public void updateTaskDescription(String taskId, String description) {
		Task task = tasks.get(taskId);
		
		if (task == null) {
			throw new IllegalArgumentException("task ID not found");
		}
		
		if (description != null && description.length() <= 50) {
			task.setDescription(description);
		}
	}
	
	// Gets taskId from map
	public Task RetrieveTaskId(String taskId) {
		return tasks.get(taskId);
	}
}
