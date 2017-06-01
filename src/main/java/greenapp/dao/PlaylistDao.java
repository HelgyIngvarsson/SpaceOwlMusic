package greenapp.dao;

import greenapp.model.sound.Playlists;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dmitro on 29.05.2017.
 */
public interface PlaylistDao extends JpaRepository<Playlists,Long> {
}
