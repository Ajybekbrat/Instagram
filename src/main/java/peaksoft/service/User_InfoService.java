package peaksoft.service;

import peaksoft.entities.Image;
import peaksoft.entities.UserInfo;

public interface User_InfoService {
    void saveInfo(Long id, UserInfo userInfo);
    UserInfo findUserInfoByUserId(Long id);
    String  update(Long id, UserInfo userInfo);
    String changeImage(Long id, Image newImage);
    String deleteImage(Long id);
}
