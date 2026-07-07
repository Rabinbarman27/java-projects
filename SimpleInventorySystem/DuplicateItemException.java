package SimpleInventorySystem;
/**
 * DuplicateItemException
 */
public class DuplicateItemException extends RuntimeException{
    public DuplicateItemException(String message){
        super(message);
    }
    
}