package greenapp.dao;

import greenapp.model.sound.Audio;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author Ghavrilin Oleg
 * 03.06.2017
 */

public interface AudioDao extends JpaRepository<Audio,Long> {


}

