package greenapp.controller;

import greenapp.model.user.User;
//import greenapp.service.authorization.SecurityService;
import greenapp.service.user.UserService;
import greenapp.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller

public class UserController {

    @Autowired
    private UserService userService;
//
//    @Autowired
//    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;


    //    @RequestMapping(value = "/registration", method = RequestMethod.GET)
//    public String registration(Model model) {
//        model.addAttribute("userForm", new User());
//
//        return "registration";
//    }
//
       @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm) {
       // userValidator.validate(userForm, bindingResult);

//        if (bindingResult.hasErrors()) {
//            return "registration";
//        }

        userService.save(userForm);

//        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

        return "redirect:profile";
    }
//
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "main";
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        model.addAttribute("userForm", new User());

        return "main";
    }
//
//    @RequestMapping(value = "/admin", method = RequestMethod.GET)
//    public String admin(Model model) {
//        return "admin";
//    }


}
