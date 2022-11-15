package pl.pollub.application.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.pollub.application.security.user.dto.UserRequestDto;
import pl.pollub.application.security.user.service.UserService;

@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserRequestDto userRequestDto = userService.findUserByUsername(username);

        return new MyUserDetails(userRequestDto);
    }
}
