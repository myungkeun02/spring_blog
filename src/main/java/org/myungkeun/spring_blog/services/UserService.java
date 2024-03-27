package org.myungkeun.spring_blog.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.myungkeun.spring_blog.payload.UpdatePasswordRequestDto;
import org.myungkeun.spring_blog.payload.UserInfoResponseDto;

import java.security.Principal;

public interface UserService {
    String updatePassword(
//            Principal connectedUser,
            UpdatePasswordRequestDto updatePasswordRequestDto);

    UserInfoResponseDto getProfileInfoByToken(
//            Principal connectedUser
    );
}
