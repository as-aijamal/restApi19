package peaksoft.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.boot.internal.Abstract;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SimpleResponse {
    HttpStatus httpStatus;
    String message;
}
