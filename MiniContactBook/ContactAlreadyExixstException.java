package MiniContactBook;

public class ContactAlreadyExixstException extends RuntimeException{
    public ContactAlreadyExixstException(String message){
        super(message);
    }
}
