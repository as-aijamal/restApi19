package peaksoft.dto.studentDto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import peaksoft.enums.Role;

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
    Role role;
}
