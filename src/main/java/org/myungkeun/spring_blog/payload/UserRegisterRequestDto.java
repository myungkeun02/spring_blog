package org.myungkeun.spring_blog.payload;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequestDto {
    String username;
    private String email;
    String password;
}
