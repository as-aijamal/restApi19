package peaksoft.dto.studentDto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import peaksoft.enums.StudyFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentResponse {
    Long id;
    String firstName;
    String lastName;
    String email;
    int age;
    StudyFormat studyFormat;
}
