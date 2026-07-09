package Todolist;

import java.util.*;

public class TaskManager {
    static Scanner sc = new Scanner(System.in);
    private LinkedList<Task> taskList = new LinkedList<>();

    public void taskValidation(Task task) {
        for (Task value : taskList) {
            if (task.name.equals(value.name)) {
                throw new DuplicateItemException(task.name + "Already in the Task list");
            }
        }
        if (task.isUrgent) {
            taskList.addFirst(task);
        } else {
            taskList.addLast(task);
        }
    }

    public void addUrgentTask() {
        try {
            System.out.println("Enter Task name :");
            String task = sc.nextLine();
            boolean isUrgent = true;
            Task newUrgentTask = new Task(task, isUrgent);
            taskValidation(newUrgentTask);
            System.out.println("Added to the front :" + task + " [URGENT]");
        } catch (DuplicateItemException e) {
            System.out.println("outor" + e.getMessage());
        }
    }

    public void addnormalTask() {
        try {
            System.out.println("Enter Task name :");
            String task = sc.nextLine();
            boolean isUrgent = false;
            Task newTask = new Task(task, isUrgent);
            taskValidation(newTask);
        } catch (DuplicateItemException e) {
            System.out.println("outor" + e.getMessage());
        }
    }

    public void completeTask() {
        if (taskList.isEmpty()) {
            throw new EmptyListException("List is empty!");
        }
        {
            System.out.println("Enter task name :");
            String task = sc.nextLine();
            for (Task t : taskList) {
                if (task.equalsIgnoreCase(t.name)) {
                    taskList.remove(t);
                    System.out.println(t.name + ", is completed !");
                    break;
                }
            }
        }
    }

    public void listTask() {
        if (taskList.isEmpty()) {
            throw new EmptyListException("List is empty!");
        } else {
            System.out.println("--PENDING TASK---");
            for (Task task : taskList) {
                if (task.isUrgent) {
                    System.out.println(task.name + " [URGENT]");
                } else {
                    System.out.println(task.name);
                }

            }
            System.out.println("-----------------");
        }
    }

    public boolean menu() {
        System.out.println("1.Add Normal\r\n" +
                "2.Add Urgent\r\n" +
                "3.Complete \r\n" + "4.list \r\n" + "5.Exit");
        System.out.print("Choose : ");
        int choose = sc.nextInt();
        System.out.println("================================");
        sc.nextLine();
        switch (choose) {
            case 1:
                addnormalTask();
                break;
            case 2:
                addUrgentTask();
                break;
            case 3:
                completeTask();
                break;
            case 4:
                listTask();
                break;
            case 5:
                return false;
            default:
                System.out.println("invalid input");
                break;
        }
        return true;
    }

}
