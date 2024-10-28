package by.kuzma.service;

import by.kuzma.domain.User;
import java.util.List;

public interface UserService {

    List<User> getUsers();


    User getUserByLogin(String login);

    boolean isUser(String login, String password);



}
