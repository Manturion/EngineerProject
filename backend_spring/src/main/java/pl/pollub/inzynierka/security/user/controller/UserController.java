package pl.pollub.inzynierka.security.user.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import pl.pollub.inzynierka.security.MyUserDetails;
import pl.pollub.inzynierka.security.MyUserDetailsService;
import pl.pollub.inzynierka.security.jwt.JwtUtil;
import pl.pollub.inzynierka.security.user.dto.UserRequestDto;
import pl.pollub.inzynierka.security.user.dto.UserResponseDto;
import pl.pollub.inzynierka.security.user.service.UserService;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("api/user")
public class UserController {
    private final UserService userService;
    private AuthenticationManager authenticationManager;
    private MyUserDetailsService myUserDetailsService;
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public void registerUser(@RequestBody UserRequestDto user) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        userService.registerUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserRequestDto user) {
        final String username = user.getUsername();
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, user.getPassword())
        );
        final MyUserDetails myUserDetails = (MyUserDetails) myUserDetailsService
                .loadUserByUsername(username);
        final String jwt = jwtUtil.generateToken(myUserDetails);
        System.out.println(jwt);
        return ResponseEntity.ok(new UserResponseDto(jwt));
    }

    
}
