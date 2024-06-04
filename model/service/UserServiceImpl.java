package model.service;

import mapper.Mapper;
import model.User;
import model.dao.UserDao;
import model.dao.UserDaoImpl;
import model.dto.UserDto;

import java.util.List;

public class UserServiceImpl implements UserService{
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public List<UserDto> getAllUser() {
        return userDao.getAllUser()
//                .stream().map(e->Mapper.fromUserToUserDto(e))
                .stream().map(Mapper::fromUserToUserDto)
                .toList();
    }

    @Override
    public void addNewUser(UserDto userDto) {
//        Convert UserDto to User
        User newUser = Mapper.fromUserDtoToUser(userDto);
//        checking if user is alr exit
        boolean userExists = userDao.getAllUser().stream()
                .anyMatch(user -> user.getEmail().equalsIgnoreCase(newUser.getEmail()));
        if (userExists) {
            throw new IllegalArgumentException("User with this email is already exists.");
        }
//        Generate id
        Integer newId = userDao.getAllUser().size() + 1;
        newUser.setId(newId);

//        Add the new user
        userDao.addNewUser(newUser);
    }

    @Override
    public void deleteUserById(Integer id) {
        userDao.deleteUserById(id);
    }

    @Override
    public void updateUser(Integer id, UserDto userDto) {

    }
}
