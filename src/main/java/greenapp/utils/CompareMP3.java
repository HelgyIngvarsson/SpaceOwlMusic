package greenapp.utils;

import greenapp.dao.MapperSoundDao;
import greenapp.model.sound.Audio;
import greenapp.model.sound.MapperSounds;
import greenapp.service.sound.AudioService;
import greenapp.service.sound.SoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;


/**
 * author Ghavrilin Oleg
 * 03.06.2017
 *
 */
public class CompareMP3 {


    // change mapperSaund in Audio object if found a comparison
    public Audio compare(Audio audio, List<MapperSounds> mapperSoundsSet) throws IOException {

        mapperSoundsSet.remove(audio.getMapperSounds());

        for(MapperSounds mapperSounds: mapperSoundsSet)
        {
            if(compareTags(audio,TagsUtil.getSoundMetaData(mapperSounds)))
            {
               audio.setMapperSounds(mapperSounds);
               return audio;
            }
        }

       /* for(MapperSounds mapperSounds: mapperSoundsSet)
        {
            if(compareByteArray(audio.getMapperSounds(),mapperSounds))
            {
                audio.setMapperSounds(mapperSounds);
                return audio;
            }
        }
*/
        return audio;
    }

    //true if audio1 == audio2
    private static Boolean  compareTags(Audio audio1,Audio audio2)
    {
        if(audio1.getAuthor().equals(audio2.getAuthor())&&
                audio1.getAlbum().equals(audio2.getAlbum())&&
                audio1.getTitle().equals(audio2.getTitle())&&
                audio1.getYear().equals(audio2.getYear())&&
                audio1.getComment().equals(audio2.getComment()))
        {return true;}
        return false;
    }

    //true if audio1 == audio2
     private static Boolean compareByteArray(MapperSounds mapperSounds1, MapperSounds mapperSounds2) throws IOException {

        byte[] byteArray1 = TagsUtil.getByteArrayFromMapper(mapperSounds1);

        byte[] byteArray2 = TagsUtil.getByteArrayFromMapper(mapperSounds2);

        if(byteArray1.length != byteArray2.length)
        {
            return false;
        }else if (byteArray1 == byteArray2)
        {
            return true;
        }
        for(int i=0;i<byteArray1.length;i++)
            if(byteArray1[i]!=byteArray2[i])
                return false;
        return true;
    }
}
