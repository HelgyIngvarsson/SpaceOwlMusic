package greenapp.controller.rest;

import greenapp.service.sound.SoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dmitro on 29.05.2017.
 */
@RestController
public class RestAudioController {


    @Autowired
    SoundService soundService;

    @RequestMapping(value = "api/profile/putAudio", method = RequestMethod.POST, produces = {"application/json"})
    public @ResponseBody
    String putSound(@RequestParam("onefileaudio") MultipartFile multipartFile) throws Exception {
        String path = "{ \"path\": \"http://localhost:8080/greenapp/api/sound/" + soundService.addSound(multipartFile.getBytes()) + "\"}";
        return path;
    }


    @RequestMapping(value = "api/profile/createPlaylist", method = RequestMethod.POST, produces = {"application/json"})
    public @ResponseBody
    List<HashMap<String,String>> createPlaylist(@RequestParam("fileaudio") List<MultipartFile> arrMmultipartFile) throws Exception {

        List<HashMap<String,String>> arrayList = new ArrayList<>();


        for (int i = 0; i < arrMmultipartFile.size(); i++) {
            String path="http://localhost:8080/greenapp/api/sound/"+(soundService.addSound(arrMmultipartFile.get(i).getBytes()));
            HashMap<String ,String > h= new HashMap<>();
            h.put("path",path);
            h.put("name","test");

            arrayList.add(h);
        }
        return arrayList;
    }




    @RequestMapping(value = "/api/sound/{sound_id}", method = RequestMethod.GET, produces = {"application/json"})
    public @ResponseBody
    HttpEntity<byte[]> sound(@PathVariable(value = "sound_id") String sound_id) {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("audio", "mp3"));
        byte[] sound = soundService.getSoundByName(sound_id);
        return new HttpEntity<>(sound, header);
    }
}
