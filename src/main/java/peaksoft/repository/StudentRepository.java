package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student getStudentByEmail(String email);
}
