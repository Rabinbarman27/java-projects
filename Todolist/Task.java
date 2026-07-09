package Todolist;

public class Task {
    String name;
    boolean isUrgent;
    Task(String name,boolean isUrgent){
        this.name= name;
        this.isUrgent=isUrgent;
    }
    public String getName(){
        return name;
    }
    public boolean isItUrgent(){
        return isUrgent;
    }
}
