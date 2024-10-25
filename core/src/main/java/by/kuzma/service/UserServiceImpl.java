package by.kuzma.service;

import by.kuzma.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService{

    private final Map<String, User> userRepository = new HashMap<>();

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


}
