package peaksoft.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.tags.EscapeBodyTag;
import peaksoft.entities.User;
import peaksoft.repositories.UserRepository;
import peaksoft.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    public static  User currentUser;
    @Override
    public void Register(User user) throws Exception{
        if (user != null){
        userRepository.Register(user);
        }else {
            throw new Exception();
        }
    }

    @Override
    public User LogIn(User user) {
        currentUser = userRepository.LogIn(user);
        return currentUser;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User getUserByName(String name) {
        return userRepository.getUserByName(name);
    }

    @Override
    public String updateUser(Long id, User newUser) {
        return userRepository.updateUser(id, newUser);
    }

    @Override
    public String deleteUser(Long id) {
       return   userRepository.deleteUser(id);
    }

    @Override
    public User userProfile() {
        return null;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }
}
