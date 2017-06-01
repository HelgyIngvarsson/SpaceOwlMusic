package greenapp.controller;

import greenapp.dao.SoundDao;
import greenapp.model.photo.Image;
import greenapp.model.sound.Sound;
import greenapp.service.image.ImageService;
import greenapp.service.profile.ProfileService;
import greenapp.service.sound.PlaylistService;
import greenapp.service.sound.SoundService;
import greenapp.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Dmitro on 11.05.2017.
 */

//profile
@Controller
@SessionAttributes("session_data")
public class ProfileController {
    @Autowired
    ImageService imageService;

    @Autowired
    ProfileService profileService;

    @Autowired
    UserService userService;

    @Autowired
    PlaylistService pl;
    @Autowired
    SoundDao soundService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String registration(Model model) {
        Image image = profileService.getUserAvatar(userService.getCurrentUser());
        if (image == null) image = imageService.getDefaultImage();
        model.addAttribute("user",userService.getCurrentUser());
        model.addAttribute("avatar", image);
        model.addAttribute("idUser", userService.getCurrentUser().getId());
        return "profile";
    }


}