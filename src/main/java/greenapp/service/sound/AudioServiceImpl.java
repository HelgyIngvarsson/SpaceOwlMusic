package greenapp.service.sound;

import greenapp.dao.AudioDao;
import greenapp.model.sound.Audio;
import greenapp.utils.TagsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * author Ghavrilin Oleg
 * 03.06.2017
 */

@Service
public class AudioServiceImpl implements AudioService{

    @Autowired
    AudioDao audioDao;

    @Override
    public void save(Audio audio) {
        try {
            audio = TagsUtil.getSoundMetaData(audio);
        } catch (IOException e) {
            e.printStackTrace();
        }
        audioDao.save(audio);
    }
}
