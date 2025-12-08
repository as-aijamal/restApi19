package peaksoft.dto.groupDto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@Builder
public class GroupResponse {
    private Long id;
    private String groupName;
    private String description;
    private LocalDate starts;
    private LocalDate finishes;
}
