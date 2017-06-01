package greenapp.service.profile;

import greenapp.dao.ImageDao;
import greenapp.dao.ProfileDao;
import greenapp.model.photo.Image;
import greenapp.model.profile.Profile;
import greenapp.model.user.User;
import greenapp.service.image.ImageService;
import greenapp.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Dmitro on 25.05.2017.
 */
@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    ProfileDao profileDao;

    @Autowired
    UserService userService;

    @Autowired
    ImageService imageService;

    @Override
    public void createProfileForUser(User user) {
        Profile profile = new Profile();
        profile.setUser(user);
        profile.setAvatar(imageService.getDefaultImage());
        profileDao.save(profile);

    }


    @Transactional
    @Override
    public Image getUserAvatar(User user) {
        Profile profile = profileDao.findByUser(user);
        return profile.getAvatar();

    }

    @Override
    public void setAvatar(Image img) {
        Profile profile = getCurrentProfile();//get current profile

        Image image = profile.getAvatar();
        if (image != null&&!image.getType().equals("default_image")){
            image.setType("");//удаляем метку аватара
            imageService.save(image);//save
        }
        profile.setAvatar(img);
        profileDao.save(profile);
    }


    @Override
    public Profile getCurrentProfile() {
        User user = userService.getCurrentUser();
        Profile profile = profileDao.findByUser(user);
        return profile;
    }
}
