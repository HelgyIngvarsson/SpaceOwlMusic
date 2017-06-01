package greenapp.service.sound;

import greenapp.model.sound.Playlists;
import org.springframework.stereotype.Service;

/**
 * Created by Dmitro on 31.05.2017.
 */
public interface PlaylistService {
    public void save(Playlists playlists);
}
