package greenapp.service.sound;

import greenapp.model.sound.Playlists;
import greenapp.model.sound.Sound;

/**
 * Created by Dmitro on 27.05.2017.
 */
public interface SoundService {
    public String addSound(byte[] sound, Playlists playlists);

    public void addSoundInAlbum(Sound sound);

    public long countSound();

    public byte[] getSoundByName(String name);
}
