package org.myungkeun.spring_blog.controllers;

import lombok.RequiredArgsConstructor;
import org.myungkeun.spring_blog.payload.UpdatePasswordRequestDto;
import org.myungkeun.spring_blog.payload.UserInfoResponseDto;
import org.myungkeun.spring_blog.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PatchMapping("/update/password")
    public ResponseEntity<String> updatePassword(
            Principal connectedUser,
            @RequestBody UpdatePasswordRequestDto updatePasswordRequestDto
    ) {
        return new ResponseEntity<>(userService.updatePassword(connectedUser, updatePasswordRequestDto), HttpStatus.OK);
    }

    @GetMapping("/profile")
    public ResponseEntity<UserInfoResponseDto> getUserInfoById(
            Principal connectedUser
    ) {
        return new ResponseEntity<>(userService.getProfileInfoByToken(connectedUser), HttpStatus.OK);
    }
}
