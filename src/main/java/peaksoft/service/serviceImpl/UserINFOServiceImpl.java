package peaksoft.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entities.Image;
import peaksoft.entities.UserInfo;
import peaksoft.repositories.User_InfoRepository;
import peaksoft.service.User_InfoService;
@Service
@RequiredArgsConstructor

public class UserINFOServiceImpl implements User_InfoService {
    private final User_InfoRepository userInfoRepository;
    @Override
    public void saveInfo(Long id, UserInfo userInfo) {
        userInfoRepository.saveInfo(id, userInfo);
    }

    @Override
    public UserInfo findUserInfoByUserId(Long id) {
        return null;
    }

    @Override
    public String update(Long id, UserInfo userInfo) {
        return null;
    }

    @Override
    public String changeImage(Long id, Image newImage) {
        return null;
    }

    @Override
    public String deleteImage(Long id) {
        return null;
    }
}
