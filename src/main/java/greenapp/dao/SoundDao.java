package greenapp.dao;

import greenapp.model.sound.Sound;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Dmitro on 27.05.2017.
 */
public interface SoundDao extends JpaRepository<Sound,Long>{
}
