package model.dao;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private List<User> userList = new ArrayList<>(
            List.of(new User(1, "Koko", "koko@email.com" ),
                    new User(2, "Kaka", "kaka@gmail.com"))
    );

    @Override
    public void addNewUser(User user) {
        userList.add(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        userList.removeIf(e->e.getId().equals(id));
        System.out.print("User with ID " + id + " is deleted!!");
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public List<User> getAllUser() {
        return userList;
    }
}
