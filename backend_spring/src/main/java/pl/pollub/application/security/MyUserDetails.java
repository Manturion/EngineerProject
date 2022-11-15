package pl.pollub.application.security;

import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.pollub.application.security.user.dto.UserRequestDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
public class MyUserDetails implements UserDetails {
    private final List<SimpleGrantedAuthority> authorities = new ArrayList<>();
    private String username;
    private String password;

    public MyUserDetails(UserRequestDto user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
//        user.getRoles()
//                .forEach(role -> authorities.add(new SimpleGrantedAuthority("USER")));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
