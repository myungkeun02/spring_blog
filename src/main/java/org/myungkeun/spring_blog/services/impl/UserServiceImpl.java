package org.myungkeun.spring_blog.services.impl;

import lombok.RequiredArgsConstructor;
import org.myungkeun.spring_blog.entities.User;
import org.myungkeun.spring_blog.payload.UpdatePasswordRequestDto;
import org.myungkeun.spring_blog.payload.UserInfoResponseDto;
import org.myungkeun.spring_blog.repositories.UserRepository;
import org.myungkeun.spring_blog.services.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

//@Service
//@RequiredArgsConstructor
//
//public class UserServiceImpl implements UserService {
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//    @Override
//    public String updatePassword(
//            Principal connectedUser,
//            UpdatePasswordRequestDto updatePasswordRequestDto
//    ) {
//        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
//        if (!passwordEncoder.matches(updatePasswordRequestDto.getCurrentPassword(), user.getPassword())) {
//            throw new IllegalStateException("Wrong password");
//        }
//        if (!updatePasswordRequestDto.getNewPassword().equals(updatePasswordRequestDto.getConfirmPassword())) {
//            throw new IllegalStateException("Password do not match");
//        }
//        user.setPassword(passwordEncoder.encode(updatePasswordRequestDto.getNewPassword()));
//        userRepository.save(user);
//        return "updated password";
//    }
//
//    @Override
//    public UserInfoResponseDto getProfileInfoByToken(
//            Principal connectedUser
//    ) {
//        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
//
//        UserInfoResponseDto userInfoResponse = UserInfoResponseDto.builder()
//                .email(user.getEmail())
//                .username(user.getUsername())
//                .role(user.getRole())
//                .build();
//        return userInfoResponse;
//    }
//}

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String updatePassword(UpdatePasswordRequestDto updatePasswordRequestDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new IllegalStateException("User not found"));

        if (!passwordEncoder.matches(updatePasswordRequestDto.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }

        if (!updatePasswordRequestDto.getNewPassword().equals(updatePasswordRequestDto.getConfirmPassword())) {
            throw new IllegalStateException("Passwords do not match");
        }

        user.setPassword(passwordEncoder.encode(updatePasswordRequestDto.getNewPassword()));
        userRepository.save(user);
        return "Updated password successfully";
    }

    @Override
    public UserInfoResponseDto getProfileInfoByToken() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new IllegalStateException("User not found"));

        UserInfoResponseDto userInfoResponse = UserInfoResponseDto.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .role(user.getRole())
                .build();
        return userInfoResponse;
    }
}
