package net.ua.controller;

import net.ua.entity.User;
import net.ua.service.SessionService;
import net.ua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class IndexController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private SessionRegistry sessionRegistry;

    public void killOtherSessionsOfCurrentUser(Authentication currentUser) {
        for (SessionInformation sessionInformation : sessionRegistry.getAllSessions(currentUser.getPrincipal(), false)) {
            sessionInformation.expireNow();
        }
    }

    @Autowired
    private SessionService sessionService;

    @RequestMapping(value = "/")
    public String getIndex() {
        User principal = sessionService.getCurrentUser();
        if (principal != null) {
            System.out.println(principal.getLogin());
        } else {
            System.out.println("null");
        }
        return "index";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(HttpSession session,
                         @RequestParam String username,
                         @RequestParam String password) {
        System.out.println("INSIDE");
        User user = null;
        user = userService.getUserByLogin(username);
        if (user == null) {
            return "redirect:/?signIn=failed&reason=credentialsA";
        }
        String hashedPass = bCryptPasswordEncoder.encode(password);
        if (!bCryptPasswordEncoder.matches(password, user.getPassword())) {
            return "redirect:/?signIn=failed&reason=credentialsP";
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(user, hashedPass, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        killOtherSessionsOfCurrentUser(authentication);
        sessionRegistry.registerNewSession(session.getId(), authentication.getPrincipal());
        return "redirect:/?signIn=success";
    }

}

//$2a$12$a8B3TEt0FqSQkRp1DUeyHeRw.kBAr2e.4/QcOHMOkBYtoIw6N8YEy