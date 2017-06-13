package greenapp.service.sound;

import greenapp.model.sound.Audio;
import greenapp.model.sound.MapperSounds;

import java.util.List;

/**
 * author Ghavrilin Oleg
 * 03.06.2017
 *
 */

public interface AudioService {

    void save(Audio audio);

    public List<MapperSounds> getAll();
}
