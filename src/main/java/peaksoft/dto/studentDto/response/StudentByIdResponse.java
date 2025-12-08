package peaksoft.dto.studentDto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentByIdResponse {
    Long id;
    String firstName;
    String lastName;
    String email;
    int age;
}
