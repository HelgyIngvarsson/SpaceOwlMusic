package greenapp.dao;

import greenapp.model.photo.Image;
import greenapp.model.profile.Profile;
import greenapp.model.sound.Playlists;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Dmitro on 29.05.2017.
 */
public interface PlaylistDao extends JpaRepository<Playlists,Long> {
    Playlists findById(long id);
    List<Playlists> findByProfile(Profile profile);


}
