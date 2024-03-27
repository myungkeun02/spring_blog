package org.myungkeun.spring_blog.services.impl;

import lombok.RequiredArgsConstructor;
import org.myungkeun.spring_blog.entities.User;
import org.myungkeun.spring_blog.payload.UpdatePasswordRequestDto;
import org.myungkeun.spring_blog.payload.UserInfoResponseDto;
import org.myungkeun.spring_blog.repositories.UserRepository;
import org.myungkeun.spring_blog.services.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public String updatePassword(
            Principal connectedUser,
            UpdatePasswordRequestDto updatePasswordRequestDto
    ) {
        User user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
        if (!passwordEncoder.matches(updatePasswordRequestDto.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }
        if (!updatePasswordRequestDto.getNewPassword().equals(updatePasswordRequestDto.getConfirmPassword())) {
            throw new IllegalStateException("Password do not match");
        }
        user.setPassword(passwordEncoder.encode(updatePasswordRequestDto.getNewPassword()));
        userRepository.save(user);
        return "updated password";
    }

    @Override
    public UserInfoResponseDto getProfileInfoByToken(Principal connectedUser) {
        User user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
        UserInfoResponseDto userInfoResponse = UserInfoResponseDto.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .role(user.getRole())
                .build();
        return userInfoResponse;
    }
}
