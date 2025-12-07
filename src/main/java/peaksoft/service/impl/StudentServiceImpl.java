package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.model.Student;
import peaksoft.repository.StudentRepository;
import peaksoft.service.StudentService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException(
                        "Student with id :" + id + " is not found"
                ));
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student oldStudent = studentRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException(
                        "Student with id :" + id + " is not found"
                ));
        oldStudent.setFirstName(student.getFirstName());
        oldStudent.setLastName(student.getLastName());
        oldStudent.setEmail(student.getEmail());
        oldStudent.setAge(student.getAge());
        studentRepository.save(oldStudent);
        return oldStudent;
    }

    @Override
    public String deleteStudent(Long id) {
        if (!studentRepository.existsById(id)){
            throw new NoSuchElementException("Student with id :" + id + " is not found");
        }
        studentRepository.deleteById(id);
        return "Student with id: "+id+" is successfully deleted";
    }

    @Override
    public Student getStudentByEmail(String email) {
        return studentRepository.getStudentByEmail(email);
    }
}
