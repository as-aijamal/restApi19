package peaksoft.dto.auth;

import peaksoft.enums.Role;

public record SignUpRequest(
        String firstName,
        String lastName,
        String email,
        String password

) {
}
