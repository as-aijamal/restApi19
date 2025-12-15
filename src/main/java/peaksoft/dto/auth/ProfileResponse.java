package peaksoft.dto.auth;

import lombok.Builder;
import peaksoft.enums.Role;

@Builder
public record ProfileResponse (
        Long id,
        String email,
        Role role
){
}
