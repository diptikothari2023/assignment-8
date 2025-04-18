// Thrown when attempting to retrieve all students and the list is empty.
public class NoStudentsException extends Exception {
    public NoStudentsException(String message) {
        super(message);
    }
}