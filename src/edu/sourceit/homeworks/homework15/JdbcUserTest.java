package edu.sourceit.homeworks.homework15;


import edu.sourceit.homeworks.homework16.jdbc.dao.AbstractDaoFactory;
import edu.sourceit.homeworks.homework16.jdbc.dao.GenericDao;
import edu.sourceit.homeworks.homework16.jdbc.dao.GenericDaoImpl;
import edu.sourceit.homeworks.homework16.jdbc.dao.MySqlDaoFactory;
import edu.sourceit.homeworks.homework16.jdbc.model.User;
import edu.sourceit.homeworks.homework16.jdbc.model.UserRole;

import java.util.Random;

public class JdbcUserTest {
    public static void main(String[] args) {
        GenericDao<User, Long> userDao = AbstractDaoFactory.getDaoFactory(User.class).getDao();
        GenericDao<UserRole, Long> userRoleDao = AbstractDaoFactory.getDaoFactory(UserRole.class).getDao();

        //userDao.create(createRandomClient());

        //User user = userDao.read(1L);
        //System.out.println(user);

        /*User user = userDao.read(2L);
        user.setName("Ponomar");
        userDao.update(user);*/

       /* UserRole userRole = new UserRole();
        userRole.setRole("Razdolbay");

        userRole = userRoleDao.read(3L);
        userRoleDao.delete(userRole);*/

        //userRoleDao.create(userRole);

        User user = new User();
        user.setId(6L);
        userDao.delete(user);

    }

    private static User createRandomClient() {
        GenericDao<UserRole, Long> userRoleDao = AbstractDaoFactory.getDaoFactory(UserRole.class).getDao();
        User user = new User();
        user.setName(randomString());
        user.setLastName(randomString());
        user.setLogin(randomString());
        user.setPassword(randomString());
        user.setEmail(randomString());
        user.setUserRole(userRoleDao.read(2L));
        return user;
    }

    private static String randomString() {
        Random random = new Random();
        int length = random.nextInt(5) + 3;
        char[] result = new char[length];
        for (int i = 0; i < length; i++) {
            result[i] = (char) ((random.nextInt(26) + 65) + (random.nextInt(2) * 32)) ;
        }
        return String.valueOf(result);
    }
}
