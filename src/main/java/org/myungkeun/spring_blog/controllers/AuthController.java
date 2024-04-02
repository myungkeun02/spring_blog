package org.myungkeun.spring_blog.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.myungkeun.spring_blog.exception.UserAlreadyExistsException;
import org.myungkeun.spring_blog.exception.UserNotFoundException;
import org.myungkeun.spring_blog.exception.UserServiceLogicException;
import org.myungkeun.spring_blog.payload.UserLoginRequestDto;
import org.myungkeun.spring_blog.payload.UserLoginResponseDto;
import org.myungkeun.spring_blog.payload.UserRegisterRequestDto;
import org.myungkeun.spring_blog.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(
            @RequestBody UserRegisterRequestDto requestDto
            ) throws UserAlreadyExistsException, UserServiceLogicException {
        return new ResponseEntity<>(authService.registerUser(requestDto), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponseDto> loginUser(
            @RequestBody UserLoginRequestDto requestDto
            ) throws UserNotFoundException, UserServiceLogicException {
        return new ResponseEntity<>(authService.loginUser(requestDto), HttpStatus.OK);
    }

    @PostMapping("/refresh")
    public void generateRefreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        authService.refreshToken(request, response);
    }
}

