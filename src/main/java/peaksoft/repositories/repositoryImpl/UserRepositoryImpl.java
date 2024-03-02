package peaksoft.repositories.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entities.*;
import peaksoft.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
@Repository
@Transactional
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    @PersistenceContext
    private final EntityManager entityManager;
    @Override
    public void Register(User user) {
        UserInfo userInfo = new UserInfo();
        Post post = new Post();
        List<Post>posts=new ArrayList<>();
        posts.add(post);
        user.setImage(new Image());
        List<Comment> comments = new ArrayList<>();
        user.setComments(comments);
        Follower follower = new Follower();
        user.setFollower(follower);
        user.setPosts(posts);
        post.setUser(user);
        user.setUserInfo(userInfo);
        userInfo.setUser(user);
        entityManager.persist(user);
    }

    @Override
    public User LogIn(User user) {
List<User>users=entityManager.createQuery("select s from User  s", User.class).getResultList();

try {
    for (User user1 : users) {
        if (user1.getEmail().equalsIgnoreCase(user.getEmail()) && user1.getPassword().equalsIgnoreCase(user.getPassword())){
            return user1;
        }
    }
}catch (Exception e){
    System.out.println("Incorrect password or Login");
}
return null;
    }

    @Override
    public List<User> getAllUsers() {
        List<User>users = entityManager.createQuery("select s from User  s", User.class).getResultList();
        return users;
    }
    @Override
    public User getUserByName(String name) {
       User user = entityManager.createQuery("select u from User u where u.user_name ilike (:keyword)", User.class).setParameter("keyword", "%"+name+"%").getSingleResult();

        return user;
    }

    @Override
    public User getUserById(Long id) {

        return entityManager.find(User.class, id);
    }


    @Override
    public String updateUser(Long id, User newUser) {
        User user = entityManager.find(User.class, id);
        user.setUser_name(newUser.getUser_name());
        return "updated";
    }

    @Override
    public String deleteUser(Long id) {
try {
    User user = entityManager.find(User.class, id);
    entityManager.remove(user);
}catch (Exception e){
    System.out.println(e.getMessage());
}
return "deleted";

    }

    @Override
    public User userProfile() {
        return null;
    }
}
