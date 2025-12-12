package peaksoft.service;

import peaksoft.dto.SimpleResponse;
import peaksoft.dto.studentDto.request.StudentRequest;
import peaksoft.dto.studentDto.response.StudentByIdResponse;
import peaksoft.dto.studentDto.response.StudentResponse;
import peaksoft.model.Student;

import java.util.List;

public interface StudentService {
    SimpleResponse saveStudent(StudentRequest studentRequest);

    List<StudentResponse> getAllStudents();

    StudentByIdResponse getStudentById(Long id);

    SimpleResponse updateStudent(Long id, StudentRequest studentRequest);

    SimpleResponse deleteStudent(Long id);

//    StudentResponse getStudentByEmail(String email);
}
