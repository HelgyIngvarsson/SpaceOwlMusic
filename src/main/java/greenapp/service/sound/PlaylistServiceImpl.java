package greenapp.service.sound;

import greenapp.dao.PlaylistDao;
import greenapp.model.sound.Playlists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Dmitro on 31.05.2017.
 */
@Service
public class PlaylistServiceImpl implements PlaylistService {
    @Autowired
    PlaylistDao playlistDao;

    @Override
    public void save(Playlists playlists) {
        playlistDao.save(playlists);

    }
}
