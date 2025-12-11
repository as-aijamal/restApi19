package peaksoft.dto.auth;

public record SignInRequest(
        String email,
        String password
) {
}
