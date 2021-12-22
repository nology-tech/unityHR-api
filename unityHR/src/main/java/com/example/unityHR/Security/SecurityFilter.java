package com.example.unityHR.Security;

import com.example.unityHR.Repositories.UserRepository;
import com.example.unityHR.Security.models.Credentials;
import com.example.unityHR.Security.models.SecurityProperties;
import com.example.unityHR.Security.models.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    SecurityService securityService;

    @Autowired
    SecurityProperties restSecProps;

    @Autowired
    SecurityProperties securityProps;

    @Autowired
    UserRepository userRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        verifyToken(request);
        filterChain.doFilter(request, response);
    }

    private void verifyToken(HttpServletRequest request) {
        logger.info("Verifying token for request URL: " + request.getRequestURL());
        String session = null;
        FirebaseToken decodedToken = null;
        Credentials.CredentialType type = null;

        String token = securityService.getBearerToken(request);
        logger.info(token);
        try {
            if (token != null && !token.equalsIgnoreCase("undefined")) {
                decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
                type = Credentials.CredentialType.ID_TOKEN;
            }
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            log.error("Firebase Exception:: ", e.getLocalizedMessage());
        }
        User user = firebaseTokenToUserDto(decodedToken);

        if (user != null ) {
            com.example.unityHR.Models.User unityHRUser = userRepository.getByEmailVerified(user.getEmail());

            if (unityHRUser != null) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user,
                        new Credentials(type, decodedToken, token, session), null);
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                logger.error("API request made by firebase user that isn't in our database" + user.getEmail());
            }
        }
    }

    private User firebaseTokenToUserDto(FirebaseToken decodedToken) {
        User user = null;
        if (decodedToken != null) {
            user = new User();
            user.setUid(decodedToken.getUid());
            user.setName(decodedToken.getName());
            user.setEmail(decodedToken.getEmail());
            user.setPicture(decodedToken.getPicture());
            user.setIssuer(decodedToken.getIssuer());
            user.setEmailVerified(decodedToken.isEmailVerified());
        }
        return user;
    }

}
