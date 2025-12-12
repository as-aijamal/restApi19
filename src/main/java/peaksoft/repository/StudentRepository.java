package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dto.studentDto.response.StudentResponse;
import peaksoft.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

//    @Query("""
//            select new peaksoft.dto.studentDto.response.StudentResponse(s.id,concat( s.firstName, s.lastName) ,s.email,s.group.groupName)
//                       from Student  s join s.group""")
//    StudentResponse getStudentByEmail(String email);

    @Query("select new peaksoft.dto.studentDto.response.StudentResponse(u.id,u.firstName ,u.lastName,u.email,s.age,s.studyFormat  )" +
            " from Student s  join s.user u"  )
    List<StudentResponse> getAllStudent();
}
