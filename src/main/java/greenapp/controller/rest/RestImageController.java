package greenapp.controller.rest;

import greenapp.dao.MapperImageDao;
import greenapp.model.photo.Image;
import greenapp.model.photo.MapperImage;
import greenapp.model.sound.Playlists;
import greenapp.service.image.ImageService;
import greenapp.service.profile.ProfileService;
import greenapp.service.sound.PlaylistService;
import greenapp.service.sound.SoundService;
import greenapp.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RestImageController {
    @Autowired
    ProfileService profileService;

    @Autowired
    ImageService imageService;

    @Autowired
    MapperImageDao mapperImageDao;

    @Autowired
    PlaylistService playlistService;

    @RequestMapping(value = "api/profile/updatePhoto", method = RequestMethod.POST, produces = {"application/json"})
    public @ResponseBody
    HashMap<String, Object> updatePhoto(@RequestParam("filefoto") MultipartFile multipartFile) throws Exception {
        byte[] bytes = multipartFile.getBytes();

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("fileoriginalsize", bytes.length);
        map.put("contenttype", multipartFile.getContentType());
        map.put("base64", new String(Base64Utils.encode(bytes)));

        MapperImage mapperImage=new MapperImage();
        mapperImage.setBase64((String) map.get("base64"));
        mapperImage.setContenttype((String) map.get("contenttype"));
        mapperImage.setFileoriginalsize((Integer) map.get("fileoriginalsize"));
        mapperImageDao.save(mapperImage);

            Image image=new Image();
            image.setProfile(profileService.getCurrentProfile());
            image.setType("avatar");
            image.setDescription("my photo");
            image.setRating(0);
            image.setMapperImage(mapperImage);
            imageService.save(image);
            profileService.setAvatar(image);

        return map;
    }


    @RequestMapping(value = "api/profile/createPhotoAlbums", method = RequestMethod.POST, produces = {"application/json"})
    public @ResponseBody
    ArrayList<HashMap<String, Object>> createPhotoAlbums(@RequestParam("filefoto") List<MultipartFile> arrMmultipartFile) throws Exception {


        ArrayList<HashMap<String, Object>> list = new ArrayList<>();

        for (MultipartFile multipartFile : arrMmultipartFile) {
            byte[] bytes = multipartFile.getBytes();
            HashMap<String, Object> map = new HashMap();
            map.put("fileoriginalsize", bytes.length);
            map.put("contenttype", multipartFile.getContentType());
            map.put("base64", new String(Base64Utils.encode(bytes)));


            MapperImage mapperImage=new MapperImage();
            mapperImage.setBase64((String) map.get("base64"));
            mapperImage.setContenttype((String) map.get("contenttype"));
            mapperImage.setFileoriginalsize((Integer) map.get("fileoriginalsize"));
            mapperImageDao.save(mapperImage);

            Image image=new Image();
            image.setProfile(profileService.getCurrentProfile());
            image.setType("avatar");
            image.setDescription("my photo");
            image.setRating(0);
            image.setMapperImage(mapperImage);
            imageService.save(image);

            list.add(map);
        }
        return list;
    }


    @RequestMapping(value = "api/profile/loadPhoto", method = RequestMethod.POST, produces = {"application/json"})
    public @ResponseBody
    HashMap<String, Object> loadPhoto(@RequestParam("filefoto") MultipartFile multipartFile,@RequestParam("id_dialog") int id) throws Exception {
        byte[] bytes = multipartFile.getBytes();

        MapperImage mapperImage=new MapperImage();
        mapperImage.setBase64(new String(Base64Utils.encode(bytes)));
        mapperImage.setContenttype(multipartFile.getContentType());
        mapperImage.setFileoriginalsize(bytes.length);
        mapperImageDao.save(mapperImage);

        Image image=new Image();
        image.setProfile(profileService.getCurrentProfile());
        image.setType("avatar");
        image.setDescription("my photo");
        image.setRating(0);
        image.setMapperImage(mapperImage);
        image=imageService.save(image);


        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("fileoriginalsize", bytes.length);
        map.put("contenttype", multipartFile.getContentType());
        map.put("base64", new String(Base64Utils.encode(bytes)));
        map.put("image_id",image.getId());

        Playlists playlists=playlistService.getPlaylistById(id);
        playlists.setBacground(image);
        playlistService.save(playlists);
        return map;
    }


    @RequestMapping(value = "api/profile/updateBackgroundPlaylist", method = RequestMethod.POST, produces = {"application/json"})
    public @ResponseBody
    HashMap<String, Object> updateBackgroundPlaylist(@RequestParam("filefoto") MultipartFile multipartFile) throws Exception {
        byte[] bytes = multipartFile.getBytes();


        MapperImage mapperImage=new MapperImage();
        mapperImage.setBase64(new String(Base64Utils.encode(bytes)));
        mapperImage.setContenttype(multipartFile.getContentType());
        mapperImage.setFileoriginalsize(bytes.length);
        mapperImageDao.save(mapperImage);

        Image image=new Image();
        image.setProfile(profileService.getCurrentProfile());
        image.setType("avatar");
        image.setDescription("my photo");
        image.setRating(0);
        image.setMapperImage(mapperImage);
        image=imageService.save(image);


        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("fileoriginalsize", bytes.length);
        map.put("contenttype", multipartFile.getContentType());
        map.put("base64", new String(Base64Utils.encode(bytes)));
        map.put("image_id",image.getId());






        return map;
    }





}
