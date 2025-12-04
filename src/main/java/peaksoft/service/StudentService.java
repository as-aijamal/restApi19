package peaksoft.service;

import peaksoft.model.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student updateStudent(Long id, Student student);

    String deleteStudent(Long id);

    Student getStudentByEmail(String email);
}
