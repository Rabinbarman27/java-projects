package Library_Management_System;

public class Book {
    String title;
    String Author;
    private Boolean isAvailable;

    Book(String title, String Author) {
        this.title = title;
        this.Author = Author;
        isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return Author;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void borrowB() {
        isAvailable = false;
    }

    public void returnB() {
        isAvailable = true;

    }

    public String toString() {
        return title + "--" + Author;
    }

}
