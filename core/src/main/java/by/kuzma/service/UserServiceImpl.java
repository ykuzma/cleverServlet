package by.kuzma.service;

import by.kuzma.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;


public class UserServiceImpl implements UserService{
    private static final UserService INSTANCE = new UserServiceImpl();

    public static UserService getInstance(){
        return INSTANCE;
    }

    private final Map<String, User> userRepository = new HashMap<>();
    {
        userRepository.put("user", new User(UUID.randomUUID(), "user", "user", null));
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(userRepository.values());
    }


    @Override
    public User getUserByLogin(String login) {

        return userRepository.entrySet().stream()
                .filter(k -> k.getKey().equals(login))
                .map(Map.Entry::getValue)
                .findAny()
                .orElseThrow();
    }

    @Override
    public boolean isUser(String login, String password) {
        User user;
        try {
            user = getUserByLogin(login);
        }catch (NoSuchElementException e) {
            return false;
        }
        return user.getPassword().equals(password);
    }
}
