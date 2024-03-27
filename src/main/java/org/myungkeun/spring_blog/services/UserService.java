package org.myungkeun.spring_blog.services;

import org.myungkeun.spring_blog.payload.UpdatePasswordRequestDto;
import org.myungkeun.spring_blog.payload.UserInfoResponseDto;

import java.security.Principal;

public interface UserService {
    String updatePassword(Principal connectedUser, UpdatePasswordRequestDto updatePasswordRequestDto);

    UserInfoResponseDto getProfileInfoByToken(Principal connectedUser);
}
