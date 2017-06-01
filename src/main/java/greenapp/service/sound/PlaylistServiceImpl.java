package greenapp.service.sound;

import greenapp.dao.PlaylistDao;
import greenapp.model.profile.Profile;
import greenapp.model.sound.Playlists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dmitro on 31.05.2017.
 */
@Service
public class PlaylistServiceImpl implements PlaylistService {
    @Autowired
    PlaylistDao playlistDao;

    @Override
    public Playlists save(Playlists playlists) {
        return playlistDao.save(playlists);

    }

    @Override
    public Playlists getPlaylistById(int id) {
        return playlistDao.findById(id);
    }

    @Override
    public List<Playlists> getAllPlaylists(Profile profile) {
        List<Playlists> p=playlistDao.findByProfile(profile);
        return null;
    }

    @Override
    public List<Playlists> getAllPlaylists() {
        return playlistDao.findAll();    }
}
