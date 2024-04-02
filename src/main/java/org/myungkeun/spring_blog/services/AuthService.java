package org.myungkeun.spring_blog.services;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.myungkeun.spring_blog.exception.UserAlreadyExistsException;
import org.myungkeun.spring_blog.exception.UserNotFoundException;
import org.myungkeun.spring_blog.exception.UserServiceLogicException;
import org.myungkeun.spring_blog.payload.UserLoginRequestDto;
import org.myungkeun.spring_blog.payload.UserLoginResponseDto;
import org.myungkeun.spring_blog.payload.UserRegisterRequestDto;

import java.io.IOException;

public interface AuthService {
    String registerUser(UserRegisterRequestDto registerRequest) throws UserAlreadyExistsException, UserServiceLogicException;

    UserLoginResponseDto loginUser(UserLoginRequestDto loginRequest) throws UserNotFoundException, UserServiceLogicException;

    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
