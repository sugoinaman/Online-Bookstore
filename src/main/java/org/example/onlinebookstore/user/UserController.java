package org.example.onlinebookstore.user;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class UserController {


    UserRepository userRepository;
    /*
    @GetMapping("/")
    public String getUserName(@AuthenticationPrincipal OAuth2User principal) {

        if (isAuthenticated()) {

            String name = principal.getAttribute("login");
            User existingUserCheck = userRepository.findByName(name);
            if (existingUserCheck == null) {
                User user = new User();
                user.setName(name);
                userRepository.save(user);
                System.out.println(principal.getAttributes());
            }
            model.addAttribute("name", name);
            return "welcome";
        }
        return "login";
        }


    public boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //SecurityContextHolder stores details of who is authenticated
        if (authentication == null || AnonymousAuthenticationToken.class.isAssignableFrom(authentication.getClass())) {
            return false; //no idea what this means tbh, gpt=if anonymous tries accessing welcome page?
        }
        return authentication.isAuthenticated();
    }
@RequestMapping("/user")
    public String user(@AuthenticationPrincipal OAuth2User principal) {
        //System.out.println(principal);
        return principal.getAttribute("login");
    }*/
    @GetMapping("/")
    public RedirectView welcome(@AuthenticationPrincipal OAuth2User principal) {
        User user=new User();
        user.setUserid(principal.getAttribute("id"));
        return new RedirectView("/books");
    }

    public String returnUserId(@AuthenticationPrincipal OAuth2User principal) {
        return principal.getAttribute("id");
    }

}
