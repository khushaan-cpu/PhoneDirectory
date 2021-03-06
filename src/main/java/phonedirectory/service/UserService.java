package phonedirectory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phonedirectory.model.User;
import phonedirectory.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void registerUser(User newUser) {
        repository.registerUser(newUser);
    }

    public User login(User user) {
        User existingUser = repository.checkUser(user.getUsername(), user.getPassword());
        if(existingUser != null) {
            return existingUser;
        }
        else {
            return null;
        }
    }

}


