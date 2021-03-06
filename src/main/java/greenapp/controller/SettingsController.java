package greenapp.controller;

import greenapp.model.photo.Image;
import greenapp.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Dmitro on 28.05.2017.
 */
@Controller
public class SettingsController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/profile/settings", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("user", userService.getCurrentUser());

        return "settings";
    }

    @RequestMapping(value = "/profile/settings/update_first_block", method = RequestMethod.POST)
    public String updateFirstBlock(Model model, @RequestParam("email") String email) {
        model.addAttribute("user", userService.getCurrentUser());

        return "settings";
    }
}
