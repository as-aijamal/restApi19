package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.studentDto.request.StudentRequest;
import peaksoft.dto.studentDto.response.StudentByIdResponse;
import peaksoft.dto.studentDto.response.StudentResponse;
import peaksoft.model.Student;
import peaksoft.model.User;
import peaksoft.repository.StudentRepository;
import peaksoft.repository.UserRepository;
import peaksoft.service.StudentService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public SimpleResponse saveStudent(StudentRequest studentRequest) {
        User user = new User();
        user.setFirstName(studentRequest.getFirstName());
        user.setLastName(studentRequest.getLastName());
        user.setEmail(studentRequest.getEmail());
        user.setPassword(passwordEncoder.encode(studentRequest.getPassword()));
        user.setRole(studentRequest.getRole());
        userRepository.save(user);
        Student student = new Student();
        student.setAge(studentRequest.getAge());
        student.setStudyFormat(studentRequest.getStudyFormat());
        student.setUser(user);
        studentRepository.save(student);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Student saved successfully")
                .build();
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        return studentRepository.getAllStudent();
    }

    @Override
    public StudentByIdResponse getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException(
                        "Student with id :" + id + " is not found"
                ));

        return StudentByIdResponse
                .builder()
                .id(student.getId())
//                .firstName(student.getFirstName())
//                .lastName(student.getLastName())
//                .email(student.getEmail())
                .age(student.getAge())
                .build();
    }

    @Override
    public SimpleResponse updateStudent(Long id, StudentRequest studentRequest) {
        Student oldStudent = studentRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException(
                        "Student with id :" + id + " is not found"
                ));
//        oldStudent.setFirstName(studentRequest.getFirstName());
//        oldStudent.setLastName(studentRequest.getLastName());
//        oldStudent.setEmail(studentRequest.getEmail());
        oldStudent.setAge(studentRequest.getAge());
        studentRepository.save(oldStudent);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Student updated successfully")
                .build();
    }

    @Override
    public SimpleResponse deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new NoSuchElementException("Student with id :" + id + " is not found");
        }
        studentRepository.deleteById(id);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Student deleted successfully")
                .build();
    }

//    @Override
//    public StudentResponse getStudentByEmail(String email) {
//        return studentRepository.getStudentByEmail(email);
//    }
}
