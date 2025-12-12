package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import peaksoft.config.jwt.JwtService;
import peaksoft.dto.auth.AuthResponse;
import peaksoft.dto.auth.SignInRequest;
import peaksoft.dto.auth.SignUpRequest;
import peaksoft.enums.Role;
import peaksoft.model.User;
import peaksoft.repository.UserRepository;
import peaksoft.service.AuthService;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepo;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse signUp(SignUpRequest signUpRequest) {
        if (userRepo.findUserByEmail(signUpRequest.email()).isPresent()) {
            throw new
                    BadCredentialsException(String.format("User with email %s already exists", signUpRequest.email()));
        }
        User user = User.builder()
                .firstName(signUpRequest.firstName())
                .lastName(signUpRequest.lastName())
                .email(signUpRequest.email())
                .password(passwordEncoder.encode(signUpRequest.password()))
                .role(Role.ADMIN)
                .build();
        userRepo.save(user);

        // Create token
        String token = jwtService.generateToken(user);
        return AuthResponse
                .builder()
                .id(user.getId())
                .token(token)
                .role(user.getRole())
                .build();
    }

    @Override
    public AuthResponse signIn(SignInRequest signInRequest) {
        User user = userRepo.findUserByEmail(signInRequest.email()).orElseThrow(()
                -> new NullPointerException(String.format("User with email %s does not exists", signInRequest.email())));
        if (!passwordEncoder.matches(signInRequest.password(), user.getPassword())) {
            throw new BadCredentialsException(String.format("Invalid username or password"));
        }
        String token = jwtService.generateToken(user);
        return AuthResponse
                .builder()
                .id(user.getId())
                .token(token)
                .role(user.getRole())
                .build();
    }
}
