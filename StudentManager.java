import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    final private List<Student> students = new ArrayList<>();

    // Adds a new student to the list
    public void addStudent(Student student) throws DuplicateStudentException {
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                throw new DuplicateStudentException("Student with ID " + student.getId() + " already exists.");
            }
        }
        students.add(student);
    }

    // Deletes a student by ID
    public void deleteStudent(int id) throws StudentNotFoundException {
        Student student = findStudentById(id);
        students.remove(student);
    }

    // Searches for a student by ID
    public Student searchStudent(int id) throws StudentNotFoundException {
        return findStudentById(id);
    }

    // Searches for students by name (case-insensitive)
    public List<Student> searchStudentByName(String name) {
        List<Student> results = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                results.add(student);
            }
        }
        return results;
    }

    // Placeholder for search by position (requires definition of 'position')
    public Student searchStudentByPosition(int position) throws StudentNotFoundException {
        if (position >= 0 && position < students.size()) {
            return students.get(position);
        } else {
            throw new StudentNotFoundException("Student at position " + position + " not found.");
        }
    }

    // Updates an existing student's information
    public void updateStudent(int id, String newName, int newAge) throws StudentNotFoundException {
        Student student = findStudentById(id);
        student.setName(newName);
        student.setAge(newAge);
        System.out.println("Student with ID " + id + " updated successfully.");
    }

    // Displays all students
    public List<Student> getAllStudents() throws NoStudentsException {
        if (students.isEmpty()) {
            throw new NoStudentsException("No student records available.");
        }
        return new ArrayList<>(students);
    }

    // Helper method to find a student by ID
    private Student findStudentById(int id) throws StudentNotFoundException {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        throw new StudentNotFoundException("Student with ID " + id + " not found.");
    }
}