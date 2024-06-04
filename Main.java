import controller.UserController;
import model.dto.UserDto;

public class Main {
    public static void main(String[] args) {
        new UserController().getAllUsers()
                .forEach(System.out::println);
        UserController userController = new UserController();

        System.out.println("======== Add New User ========");
        userController.addNewUser(new UserDto("Sopeak", "sopheak123@gmail.com"));
        userController.getAllUsers().forEach(System.out::println);
        System.out.println("");

        System.out.println("======== Delete user by id ========");
        userController.deleteUserById(1);

        System.out.println("");
        System.out.println("======== List of all users ========");
        userController.getAllUsers().forEach(System.out::println);


    }
}