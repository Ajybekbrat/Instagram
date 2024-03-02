package peaksoft.repositories.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entities.Image;
import peaksoft.entities.User;
import peaksoft.entities.UserInfo;
import peaksoft.repositories.User_InfoRepository;
@Repository
@RequiredArgsConstructor
@Transactional
public class UserINFORepositoryImpl implements User_InfoRepository {
    @PersistenceContext
    private final EntityManager entityManager;
    @Override
    @Transactional
    public void saveInfo(Long id, UserInfo userInfo) {
        UserInfo userInfo1 = entityManager.find(UserInfo.class, id);
        userInfo1.setFullName(userInfo.getFullName());
        userInfo1.setBiography(userInfo.getBiography());
        userInfo1.setGender(userInfo.getGender());
        userInfo1.setImage(userInfo.getImage());
        entityManager.merge(userInfo);
    }

    @Override
    public UserInfo findUserInfoByUserId(Long id) {
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
