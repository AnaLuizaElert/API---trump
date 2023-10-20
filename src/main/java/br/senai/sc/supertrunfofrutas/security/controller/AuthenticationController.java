package br.senai.sc.supertrunfofrutas.security.controller;

import br.senai.sc.supertrunfofrutas.security.model.Login;
import br.senai.sc.supertrunfofrutas.security.model.User;
import br.senai.sc.supertrunfofrutas.security.util.CookieUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<?> login(
            @RequestBody Login login,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        SecurityContextRepository securityContextRepository = new HttpSessionSecurityContextRepository();
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);

        if(authentication.isAuthenticated()){
            User user = (User) authentication.getPrincipal();
            Cookie cookie = CookieUtil.generateCookie(user);
            response.addCookie(cookie);
            return ResponseEntity.ok(authentication.getPrincipal());
        }

        return ResponseEntity.status(401).build();
    }

}
