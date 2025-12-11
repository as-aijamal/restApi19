package peaksoft.dto.auth;

import lombok.Builder;
import peaksoft.enums.Role;

@Builder
public record AuthResponse(
        Long id,
        String token,
        Role role
) {
}
