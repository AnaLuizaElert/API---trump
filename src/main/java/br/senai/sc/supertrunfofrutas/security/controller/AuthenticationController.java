package br.senai.sc.supertrunfofrutas.security.controller;

import br.senai.sc.supertrunfofrutas.security.model.Login;
import br.senai.sc.supertrunfofrutas.security.model.User;
import br.senai.sc.supertrunfofrutas.security.util.CookieUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
public class AuthenticationController {

    AuthenticationManager manager;

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody Login login,
            HttpServletRequest request,
            HttpServletResponse response
    ){

        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());

        Authentication authentication = manager.authenticate(token);

        if(authentication.isAuthenticated()){
            User user = (User) authentication.getPrincipal();
            Cookie cookie = CookieUtil.generateCookie(user);
            response.addCookie(cookie);

            SecurityContextHolder.getContext().setAuthentication(authentication);

            return ResponseEntity.ok(authentication.getPrincipal());
        }

        return ResponseEntity.status(401).build();
    }

}
