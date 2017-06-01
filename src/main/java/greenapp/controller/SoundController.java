package greenapp.controller;

import greenapp.model.photo.Image;
import greenapp.model.sound.Playlists;
import greenapp.service.image.ImageService;
import greenapp.service.sound.PlaylistService;
import greenapp.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by Dmitro on 28.05.2017.
 */
@Controller
public class SoundController {
    @Autowired
    ImageService imageService;

    @Autowired
    PlaylistService playlistService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/profile/sound", method = RequestMethod.GET)
    public String sound(Model model) {
        // model.addAttribute("userForm", new User());

        return "mymusic";
    }

    @RequestMapping(value = "/profile/sound/playlist", method = RequestMethod.GET)
    public String playlist() {

        return "playlist";
    }

    @RequestMapping(value = "api/profile/sound/createFolder", method = RequestMethod.POST, produces = {"application/json"})
    public @ResponseBody
    String createFolder(@RequestParam Map<String,String> map) throws Exception {
        int image_id=0;
        String title=map.get("name");
        String description=map.get("description");


        try {
             image_id= Integer.parseInt(map.get("image_id"));
        }catch (Exception e){
            image_id=0;
        }
        Image image=imageService.getImageById(image_id);

        Playlists playlists= new Playlists();
        playlists.setCover(image);
        playlists.setTitle(title);
        playlists.setDescription(description);
        playlists.setProfile(userService.getCurrentUser().getProfile());
        playlistService.save(playlists);



        String path = "{ \"path\":\"http://localhost:8080/greenapp/profile/sound/playlist\"}";
        return path;
    }
//createFolder
}
