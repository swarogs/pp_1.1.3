package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private final SessionFactory sessionFactory;
    private static final String createUsersQuery = "CREATE TABLE IF NOT EXISTS users" +
            "(id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), lastname VARCHAR(255), age INT)";
    public UserDaoHibernateImpl() {
        sessionFactory = new Util().getConnection();

    }

    @Override
    public void createUsersTable() {
        Session session = sessionFactory.openSession();
        try (session) {
            Transaction transaction = session.beginTransaction();
            session.createNativeQuery(createUsersQuery).executeUpdate();
        } catch (HibernateException e) {
            throw new RuntimeException("Error creating users: " + e.getMessage());
        }
    }

    @Override
    public void dropUsersTable() {
        Session session = sessionFactory.openSession();
        try (session) {
            Transaction transaction = session.beginTransaction();
            session.createNativeQuery("DROP TABLE IF EXISTS users").executeUpdate();
        } catch (HibernateException e) {
            throw new RuntimeException("Error drop users: " + e.getMessage());
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = sessionFactory.openSession();
        try (session) {
            Transaction transaction = session.beginTransaction();
            session.save(new User(name, lastName, age));
            transaction.commit();
        } catch (HibernateException e) {
            throw new RuntimeException("Error save users: " + e.getMessage());
        }
    }

    @Override
    public void removeUserById(long id) {
        Session session = sessionFactory.openSession();
        try (session) {
            Transaction transaction = session.beginTransaction();
            session.delete(session.get(User.class, id));
            transaction.commit();
        } catch (HibernateException e) {
            throw new RuntimeException("Error remove users: " + e.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        CriteriaQuery<User> criteriaQuery = session.getCriteriaBuilder().createQuery(User.class);
        criteriaQuery.from(User.class);
        Transaction transaction = session.beginTransaction();
        List<User> userList = session.createQuery(criteriaQuery).getResultList();
        try {
            return userList;
        } catch (HibernateException e) {
            throw new RuntimeException("Error remove users: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    @Override
    public void cleanUsersTable() {
        Session session = sessionFactory.openSession();
        try (session) {
            Transaction transaction = session.beginTransaction();
            session.createNativeQuery("TRUNCATE TABLE users;").executeUpdate();
        } catch (HibernateException e) {
            throw new RuntimeException("Error clean table: " + e.getMessage());
        }
    }
}
