package peaksoft.service;

import lombok.Setter;
import org.springframework.stereotype.Service;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.auth.AuthResponse;
import peaksoft.dto.auth.ProfileResponse;
import peaksoft.dto.auth.SignInRequest;
import peaksoft.dto.auth.SignUpRequest;

@Service
public interface AuthService {

    AuthResponse signUp(SignUpRequest signUpRequest);

    AuthResponse signIn(SignInRequest signInRequest);
    ProfileResponse getProfileToken();
}
