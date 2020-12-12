package nd.ermakov.servlet.repository;

import nd.ermakov.servlet.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private static Map<String, User> storage = new HashMap<>();

    public static void save(User user) {
        storage.put(user.getName(), user);
    }

    public static User findByName(String name) {
        return storage.get(name);
    }
}
