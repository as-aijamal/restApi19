package peaksoft.dto.studentDto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import peaksoft.enums.Role;
import peaksoft.enums.StudyFormat;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentRequest {
    String firstName;
    String lastName;
    String email;
    String password;
    int age;
    StudyFormat studyFormat;
    Role role;
}
