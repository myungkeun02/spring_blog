package org.myungkeun.spring_blog.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.myungkeun.spring_blog.entities.Role;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoResponseDto {
    private String username;
    private String email;
    private Role role;
}
