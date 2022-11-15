package pl.pollub.application.security.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponseDto {
    private final String jwt;
    private final String username;
}
