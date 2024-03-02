package peaksoft.repositories;

import peaksoft.entities.User;

import java.util.List;

public interface UserRepository {
    void Register(User user);
    User LogIn(User user);

    List<User> getAllUsers();
    User getUserByName(String name);
    User getUserById(Long id);
    String updateUser(Long id, User newUser);
    String deleteUser(Long id);
    User userProfile();
}
