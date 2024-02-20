package org.example.onlinebookstore.controller;

public class UserController {
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
*//*@RequestMapping("/user")
    public String user(@AuthenticationPrincipal OAuth2User principal) {
        //System.out.println(principal);
        return principal.getAttribute("login");
    }*/
}
