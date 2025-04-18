
// Thrown when attempting to add a student with an existing ID.

public class DuplicateStudentException extends Exception {
    public DuplicateStudentException(String message) {
        super(message);
    }
}
