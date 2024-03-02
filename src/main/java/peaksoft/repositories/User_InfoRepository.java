package peaksoft.repositories;

import peaksoft.entities.Image;
import peaksoft.entities.UserInfo;

public interface User_InfoRepository {
    void saveInfo(Long id, UserInfo userInfo);
   UserInfo findUserInfoByUserId(Long id);

    String changeImage(Long id, Image newImage);
    String deleteImage(Long id);
}
