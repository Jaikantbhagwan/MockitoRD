

package spring;


import org.springframework.stereotype.Component;


@Component
public class UserDao {

    public User findUserById(Long id) {
        // Find user details from database
        return new User();
    }

}
