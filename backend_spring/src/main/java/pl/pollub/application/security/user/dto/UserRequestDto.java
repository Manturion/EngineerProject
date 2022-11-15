package pl.pollub.inzynierka.security.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserRequestDto {
    private String username;
    private String password;
}
