package greenapp.service.sound;

import greenapp.model.profile.Profile;
import greenapp.model.sound.Playlists;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dmitro on 31.05.2017.
 */
public interface PlaylistService {
    public Playlists save(Playlists playlists);
    public Playlists getPlaylistById(int id);
    List<Playlists> getAllPlaylists(Profile profile);
    List<Playlists> getAllPlaylists();
}
