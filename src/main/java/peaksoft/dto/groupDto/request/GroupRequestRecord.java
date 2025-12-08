package peaksoft.dto.groupDto.request;

import java.time.LocalDate;

public record GroupRequestRecord(
        String groupName,
        String description,
        LocalDate finishes) {
}
