package greenapp.controller.rest;

import greenapp.dao.MapperSoundDao;
import greenapp.dao.PlaylistDao;
import greenapp.dao.SoundDao;
import greenapp.model.sound.Audio;
import greenapp.model.sound.MapperSounds;
import greenapp.model.sound.Playlists;
import greenapp.service.sound.AudioService;
import greenapp.service.sound.PlaylistService;
import greenapp.service.sound.SoundService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
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
    MapperSoundDao mapperSoundDao;
    @Autowired
    PlaylistDao playlistDao;
    @Autowired
    SoundService soundService;
    @Autowired
    PlaylistService playlistService;
    @Autowired
    SoundDao soundDao;

    @Autowired
    AudioService audioService;

    @RequestMapping(value = "api/profile/putAudio", method = RequestMethod.POST, produces = {"application/json"})
    public @ResponseBody
    String putSound(@RequestParam("onefileaudio") MultipartFile multipartFile, @RequestParam("id_dialog") int id) throws Exception {
        String path = "{ \"path\": \"http://localhost:8080/greenapp/api/sound/" + soundService.addSound(multipartFile.getBytes(), playlistService.getPlaylistById(id)) + "\"}";
        return path;
    }


    @RequestMapping(value = "api/profile/createPlaylist", method = RequestMethod.POST, produces = {"application/json"})
    public @ResponseBody
    List<HashMap<String, String>> createPlaylist(@RequestParam("fileaudio") List<MultipartFile> arrMmultipartFile, @RequestParam("id_dialog") int id) throws Exception {

        List<HashMap<String, String>> arrayList = new ArrayList<>();
        Playlists playlists = playlistService.getPlaylistById(id);


        for (int i = 0; i < arrMmultipartFile.size(); i++) {
            byte[] bytes = arrMmultipartFile.get(i).getBytes();
            MapperSounds mapperSounds = new MapperSounds();
            mapperSounds.setPath(saveSoundForHard(bytes));
            mapperSounds.setName("sound" + mapperSoundDao.findAll().size());
            mapperSoundDao.save(mapperSounds);
            Audio audio = new Audio();
            //aSound sound = new Sound();
            audio.setMapperSounds(mapperSounds);

            audio.setTitle("title sound test" + mapperSoundDao.findAll().size());


            String path = "http://localhost:8080/greenapp/api/sound/" + mapperSounds.getName();
            HashMap<String, String> h = new HashMap<>();
            h.put("path", path);
            h.put("name", "test");
            audio.setUrl(path);
            audioService.save(audio);
            playlists.add(audio);
            arrayList.add(h);
        }
        playlistDao.save(playlists);



        return arrayList;
    }

//    @Override
//    public byte[] getSoundByName(String name) {
//        MapperSounds mapperSounds = mapperSoundDao.findByName(name);
//        InputStream in = null;
//        byte[] bytes = null;
//        try {
//            in = new FileInputStream(mapperSounds.getPath());
//            bytes = IOUtils.toByteArray(in);
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        int t = 3;
//        return bytes;
//    }


    private String saveSoundForHard(byte[] bytes) {
        int postfix = mapperSoundDao.findAll().size();
        try (FileOutputStream fos = new FileOutputStream("D://sound_memory//sound" + postfix + ".mp3")) {
            fos.write(bytes, 0, bytes.length);
        } catch (IOException ex) {
            //  System.out.println(ex.getMessage());
        }
        return "D://sound_memory//sound" + postfix + ".mp3";
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
