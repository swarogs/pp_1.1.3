package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Мария", "Богданова", (byte) 19);
        userService.saveUser("Мария", "Михалова", (byte) 19);
        userService.saveUser("Мария", "Рыданова", (byte) 19);
        userService.saveUser("Мария", "Квасова", (byte) 19);
        userService.getAllUsers();
        userService.removeUserById(3);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
