package peaksoft.dto.studentDto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import peaksoft.model.Group;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentResponse {
    Long id;
    String fullName;
    String email;
    String groupName;
}
