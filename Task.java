package classes;

public class Task {
	// Private variables of Task info
	private final String taskId;
	private String name;
	private String description;
	
	// Constructor that takes the task info as arguments and validates them
	public Task(String taskId, String name, String description) {
		if (taskId == null || taskId.length() > 10) {
			throw new IllegalArgumentException("Invalid task ID");
		}
		
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid name");
		}
		
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		
		// assigns parameters to references variables
		this.taskId = taskId;
		this.name = name;
		this.description = description;
	}
	
	// Getters
	public String getTaskId() {
		return taskId;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	// Setters
	public void setName(String name) {
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid name");
		}
		this.name = name;
	}
	
	public void setDescription(String description) {
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		this.description = description;
	}

}
