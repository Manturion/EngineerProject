package pl.pollub.inzynierka.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.pollub.inzynierka.security.user.dto.UserRequestDto;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserExistsException extends RuntimeException {
    public UserExistsException(UserRequestDto user) {
        super("User with username " + user.getUsername() + " already exists");
    }
}
