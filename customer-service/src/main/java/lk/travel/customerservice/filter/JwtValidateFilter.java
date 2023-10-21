package lk.travel.customerservice.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.travel.customerservice.constant.SecurityConstant;
import lk.travel.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;
@Component
public class JwtValidateFilter extends OncePerRequestFilter {
    @Autowired
   private CustomerService customerService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String tokenHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(tokenHeader != null && !tokenHeader.startsWith("Basic")) {
            SecretKey secretKey = Keys.hmacShaKeyFor(SecurityConstant.JWT_SECRET_KEY.getBytes(StandardCharsets.UTF_8));
        tokenHeader=tokenHeader.startsWith("Bearer ") ? tokenHeader.substring(7):tokenHeader;
            Claims claims = Jwts
                    .parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(tokenHeader)
                    .getBody();


           Authentication userNamePwdToken = new UsernamePasswordAuthenticationToken(claims.get("username").toString(), null, AuthorityUtils.commaSeparatedStringToAuthorityList(claims.get("authorities").toString()));
            SecurityContextHolder.getContext().setAuthentication(userNamePwdToken);

        }

        filterChain.doFilter(request,response);

    }
    private <T> T getClaims(Function<Claims,T> claimsTFunction,Claims claims){
       return claimsTFunction.apply(claims);
    }

}

