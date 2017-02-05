package net.ua.service.realization;

import net.ua.entity.User;
import net.ua.service.SessionService;
import net.ua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Created by Roman Dashkivskyy on 05.02.2017.
 */
@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    UserService userService;

    /**
     * Finds current session user
     *
     * @return current authorized user
     */
    @Override
    public User getCurrentUser() {
        Authentication principal = SecurityContextHolder.getContext().getAuthentication();
        if (principal == null || !(principal.getPrincipal() instanceof User)) {
            return null;
        }
        return (User) principal.getPrincipal();
    }

}
