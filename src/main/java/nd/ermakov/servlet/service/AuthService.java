package nd.ermakov.servlet.service;

import nd.ermakov.servlet.model.User;
import nd.ermakov.servlet.repository.UserRepository;

public class AuthService {

    public static AuthStatus authorize(String name, String password) {
        User user = UserRepository.findByName(name);
        if (user == null) {
            return AuthStatus.NOT_FOUND;
        }
        if (!user.getPassword().equals(password)) {
            return AuthStatus.WRONG_PASSWORD;
        }
        return AuthStatus.OK;
    }

    public static AuthStatus register(String name, String password) {
        if (UserRepository.findByName(name) != null) {
            return AuthStatus.ALREADY_EXISTS;
        }
        UserRepository.save(new User(name, password));
        return AuthStatus.CREATED;
    }
}
