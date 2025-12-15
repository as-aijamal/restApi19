package peaksoft.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.auth.AuthResponse;
import peaksoft.dto.auth.ProfileResponse;
import peaksoft.dto.auth.SignInRequest;
import peaksoft.dto.auth.SignUpRequest;
import peaksoft.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthApi {
    private final AuthService authService;

    @PostMapping("/signUp")
    public AuthResponse signUp(@RequestBody SignUpRequest signUpRequest) {
        return authService.signUp(signUpRequest);
    }

    @PostMapping("/signIn")
    public AuthResponse signIn(@RequestBody SignInRequest signInRequest) {
        return authService.signIn(signInRequest);
    }

    @GetMapping
    public ProfileResponse getProfile() {
        return authService.getProfileToken();
    }
}
