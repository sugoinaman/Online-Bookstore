package org.example.onlinebookstore;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/welcome")
    public String getUserName(@AuthenticationPrincipal OAuth2User principal, Model model) {

        if (isAuthenticated()) {

            String name = principal.getAttribute("login");
            User existingUserCheck = userRepository.findByName(name);
            if (existingUserCheck==null) {
                User user = new User();
                user.setName(name);
                userRepository.save(user);
                System.out.println(principal.getAttributes());
            }
            model.addAttribute("name", name);
            return "welcome";
        }
        return "index";
    }

    public boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //SecurityContextHolder stores details of who is authenticated
        if (authentication == null || AnonymousAuthenticationToken.class.isAssignableFrom(authentication.getClass())) {
            return false; //no idea what this means tbh, gpt=if anonymous tries accessing welcome page?
        }
        return authentication.isAuthenticated();
    }

    @GetMapping("/clear")
    public void clear() {
        userRepository.deleteAll();
        System.out.println("DATABASE CLEARED");
    }
}