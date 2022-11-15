package pl.pollub.inzynierka.security.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponseDto {
    private final String jwt;
    private final String username;
}
