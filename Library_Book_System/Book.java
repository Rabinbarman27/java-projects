package Library_Book_System;
public class Book {
    private String Title;
    private String Author;
    private boolean Available;

    public Book(String Title,String Author){
        this.Title=Title;
        this.Author= Author;
        Available=true;

    }
    public String gettitle(){
        return Title;
    }
    public String getAuthor(){
        return Author;
    }
    public boolean isAvailable(){
        return Available;
    }
    public void borrowBook(){
        Available=false;
    } 
    public void returnBook(){
        Available=true;
    }
    public String toString() {
        return Title + "-" + Author;
    }
}