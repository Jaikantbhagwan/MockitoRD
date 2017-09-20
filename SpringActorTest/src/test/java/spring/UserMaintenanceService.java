

package spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserMaintenanceService {
    @Autowired
    private UserDao userDao;

    /**
    * Find user.
    * @param userId user id
    * @return Retrieved user
    */
    public User findUserById(Long userId) {
        // Do business validations.
        return userDao.findUserById(userId);
    }
}
