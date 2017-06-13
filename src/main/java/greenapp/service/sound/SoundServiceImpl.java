package greenapp.service.sound;

import greenapp.dao.MapperSoundDao;
import greenapp.dao.PlaylistDao;
import greenapp.dao.SoundDao;
import greenapp.model.sound.*;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Dmitro on 27.05.2017.
 */
@Service
public class SoundServiceImpl implements SoundService {
    @Autowired
    SoundDao soundDao;
    @Autowired
    MapperSoundDao mapperSoundDao;

    @Autowired
    PlaylistDao playlistDao;

    @Override
    public String addSound(byte[] soundByte, Playlists playlists) {



//        playlistDao.save(playlists);
//        Set<Sound> p=  playlists.getSounds();
//        p.add(sound);
//        playlists.setSounds(p);
//        playlistDao.save(playlists);
//

            return null;
    }

    @Override
    public void addSoundInAlbum(Sound sound) {

    }

    @Override
    public long countSound() {
        return 0;
    }


    private String saveSoundForHard(byte[] bytes) {
        int postfix = mapperSoundDao.findAll().size();
        try (FileOutputStream fos = new FileOutputStream("D://sound_memory//sound" + postfix + ".mp3")) {
            fos.write(bytes, 0, bytes.length);
        } catch (IOException ex) {
            //  System.out.println(ex.getMessage());
        }
        return "D://sound_memory//sound" + postfix + ".mp3";
    }

    @Override
    public byte[] getSoundByName(String name) {
        MapperSounds mapperSounds=mapperSoundDao.findByName(name);
        InputStream in = null;
        byte[] bytes=null;
        try {
            in = new FileInputStream(mapperSounds.getPath());
         bytes = IOUtils.toByteArray(in);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
int t=3;
        return bytes ;
    }

    @Override
    public List<MapperSounds> getAll() {
        return mapperSoundDao.findAll();
    }
}
