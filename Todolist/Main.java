package Todolist;

public class Main {
    public static void main(String[] args) {
        System.out.println(//
                "===============================\r\n" + //
                "TASK MANAGER v1.0\r\n" + //
                "================================");
        TaskManager t1 = new TaskManager();
        boolean isGoing = true;
        while (isGoing) {
            isGoing = t1.menu();
        }
    }
}
