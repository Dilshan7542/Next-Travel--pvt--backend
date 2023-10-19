package lk.travel.vehicleservice.filter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.travel.vehicleservice.constant.SecurityConstant;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class JwtGenerateFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication!=null) {
            SecretKey secretKey = Keys.hmacShaKeyFor(SecurityConstant.JWT_SECRET_KEY.getBytes(StandardCharsets.UTF_8));
            Jwts.builder()
                    .setSubject("Next-Travel")
                    .setIssuer("DILSHAN")
                    .claim("username",authentication.getName())
                    .claim("authorities",populateAuthorities(authentication.getAuthorities()))
                    .setIssuedAt(new Date())
                    .setExpiration(new Date());
        }
    }

    private String populateAuthorities(Collection<? extends GrantedAuthority> collection) {
        Set<String> set = new HashSet<>();
        for (GrantedAuthority authority : collection) {
            set.add(authority.getAuthority());
        }
        return String.join(",",set);

    }
}
