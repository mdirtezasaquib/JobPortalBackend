package in.codingage.jobportal.service;

import in.codingage.jobportal.model.User;

import java.util.List;

public interface UserService {

    User registerUser(User user);

    User loginUser(String email, String password);

    List<User> getAllUsers();

    User getUserById(String id);

    User updateUser(String id,User updateUser);

    void deleteUser(String id);


    User getUserByEmail(String email);
}
