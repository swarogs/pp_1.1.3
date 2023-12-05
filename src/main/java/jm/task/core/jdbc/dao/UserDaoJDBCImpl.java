package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

//public class UserDaoJDBCImpl extends Util implements UserDao {
//
//    Connection connection = getConnect();
//    Logger logger = Logger.getLogger("Логирование");
//
//    public UserDaoJDBCImpl() {
//
//    }
//
//    @Override
//    public void createUsersTable() {
//        String sql = "CREATE TABLE `mydb`.`users` (\n" +
//                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
//                "  `name` VARCHAR(45) NULL,\n" +
//                "  `lastName` VARCHAR(45) NULL,\n" +
//                "  `age` TINYINT NULL,\n" +
//                "  PRIMARY KEY (`id`))";
//        try (Connection connection = Util.getConnect();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)
//        ) {
//            preparedStatement.executeUpdate();
//            logger.info("Таблица Создана");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Override
//    public void dropUsersTable() {
//        String sql = "DROP TABLE IF EXISTS users";
//        try (Connection connection = Util.getConnect();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)
//        ) {
//            preparedStatement.executeUpdate();
//            logger.info("Таблица удалена");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void saveUser(String name, String lastName, byte age) {
//        String sql = "INSERT INTO USERS(name, lastName,age) VALUES (?,?,?)";
//
//        try (Connection connection = Util.getConnect();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        ) {
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, lastName);
//            preparedStatement.setByte(3, age);
//            logger.info("Пользователь сохранен");
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void removeUserById(long id) {
//        String sql = "Delete From users WHERE id = ?";
//        try (Connection connection = Util.getConnect();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)
//        ) {
//            preparedStatement.setLong(1, id);
//            preparedStatement.executeUpdate();
//            logger.info("Пользователь удален");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        List<User> list = new ArrayList<>();
//        String sql = "Select * From users";
//        try (Connection connection = Util.getConnect();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)
//        ) {
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                long id = resultSet.getLong("id");
//                String name = resultSet.getString("name");
//                String lastname = resultSet.getString("lastname");
//                byte age = resultSet.getByte("age");
//                User users = new User(id, name, lastname, age);
//                list.add(users);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    @Override
//    public void cleanUsersTable() {
//        String sql = "TRUNCATE TABLE users";
//        try (Connection connection = Util.getConnect();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)
//        ) {
//            preparedStatement.executeUpdate();
//            logger.info("Таблица очищена");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
