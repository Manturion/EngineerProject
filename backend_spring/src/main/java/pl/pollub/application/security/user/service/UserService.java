package pl.pollub.inzynierka.security.user.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.pollub.inzynierka.security.exception.UserExistsException;
import pl.pollub.inzynierka.security.exception.UserNotFoundException;
import pl.pollub.inzynierka.security.user.dto.UserRequestDto;
import pl.pollub.inzynierka.security.user.entity.User;
import pl.pollub.inzynierka.security.user.repository.UserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public void registerUser(UserRequestDto user) {
        Optional<User> foundUser = userRepository.findByUsername(user.getUsername());
        if (foundUser.isPresent()) {
            throw new UserExistsException(user);
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(new User(user));
    }

    public UserRequestDto findUserByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
        return new UserRequestDto(user.getUsername(), user.getPassword());
    }
}
