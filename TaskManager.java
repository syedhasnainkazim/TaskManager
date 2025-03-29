import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Represents a single to-do item */
class Task {
    private String description;
    private boolean completed;

    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    public void markCompleted() {
        completed = true;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        return (completed ? "[x] " : "[ ] ") + description;
    }
}

/* Manages a list of tasks and includes the main method to run the app. */
public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        tasks.add(new Task(description));
    }

    public void completeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markCompleted();
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void listTasks() {
        System.out.println("Your Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + ": " + tasks.get(i));
        }
    }

    /* Main method — entry point of the program */
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Simple Task Manager");

        while (true) {
            System.out.println("\nOptions: [1] Add Task, [2] Complete Task, [3] List Tasks, [0] Exit");
            System.out.print("Select an option: ");
            int option;
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (option) {
                case 1:
                    System.out.print("Enter task description: ");
                    String desc = scanner.nextLine();
                    manager.addTask(desc);
                    break;
                case 2:
                    System.out.print("Enter task index to complete: ");
                    int index;
                    try {
                        index = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                        continue;
                    }
                    manager.completeTask(index);
                    break;
                case 3:
                    manager.listTasks();
                    break;
                case 0:
                    System.out.println("Exiting Task Manager.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
