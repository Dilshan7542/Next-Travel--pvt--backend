package lk.travel.vehicleservice.security;

import lk.travel.vehicleservice.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;

@Component
@RequiredArgsConstructor
public class AuthenticationConfig implements AuthenticationProvider {
    RestTemplate restTemplate;
    PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        UserDTO userDTO = restTemplate.getForEntity("http://localhost:8084/api/v1/user/search/email?email=" + username, UserDTO.class).getBody();
        if (userDTO != null) {
            if(passwordEncoder.matches(pwd,userDTO.getPwd())){
                return new UsernamePasswordAuthenticationToken(username,pwd,getGenerateAuthorities(userDTO.getRole().name()));
            }
        throw new BadCredentialsException("Invalid Password name");
        }else{
        throw new BadCredentialsException("Invalid User name");
        }

    }

    private Collection<? extends GrantedAuthority> getGenerateAuthorities(String name) {
        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(name));
        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
