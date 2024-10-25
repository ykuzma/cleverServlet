package by.kuzma.service;

import by.kuzma.domain.User;
import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUserById();

    User create(User newUser);

    User update(User newUser, long id);

    void delete(long id);

}
