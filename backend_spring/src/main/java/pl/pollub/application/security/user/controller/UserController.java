package pl.pollub.application.security.user.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;
import pl.pollub.application.security.MyUserDetails;
import pl.pollub.application.security.MyUserDetailsService;
import pl.pollub.application.security.jwt.JwtUtil;
import pl.pollub.application.security.user.dto.UserRequestDto;
import pl.pollub.application.security.user.dto.UserResponseDto;
import pl.pollub.application.security.user.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        userService.registerUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserRequestDto user) {
        final String username = user.getUsername();

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, user.getPassword()));
        final MyUserDetails myUserDetails = (MyUserDetails) myUserDetailsService.loadUserByUsername(username);
        final String jwt = jwtUtil.generateToken(myUserDetails);

        return ResponseEntity.ok(new UserResponseDto(jwt,username));
    }

    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "logout success";
    }
}
