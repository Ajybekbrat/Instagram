package peaksoft.service;

import peaksoft.entities.User;

import java.util.List;

public interface UserService {
    void Register(User user) throws Exception;
    User LogIn(User user);

    List<User> getAllUsers();
    User getUserByName(String name);
    String updateUser(Long id, User newUser);
    String deleteUser(Long id);
    User userProfile();
    User getUserById(Long id);
}
