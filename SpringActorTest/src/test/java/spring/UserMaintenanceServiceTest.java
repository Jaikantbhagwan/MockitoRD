

package spring;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Date;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;



public class UserMaintenanceServiceTest {
    @InjectMocks
    private UserMaintenanceService userMaintenanceService;
    @Mock
    private UserDao userDao;

    @Test
    public void testFindUserByIdPositive() {
        initMocks(this);
        when(userDao.findUserById(1000L)).thenReturn(getMeTestUser());
        User user = userMaintenanceService.findUserById(1000L);
        assertNotNull(user);
        assertEquals("Test first name", user.getFirstName());
        assertEquals("Test surname", user.getSurname());
    }

    @Test(expected = NullPointerException.class)
    public void testFindUserByIdNegetive() {
        userMaintenanceService = new UserMaintenanceService();
        userMaintenanceService.findUserById(1000L);
        fail();
    }

    private User getMeTestUser() {
        User user = new User();
        user.setUserId(1000L);
        user.setFirstName("Test first name");
        user.setSurname("Test surname");
        user.setDateOfBirth(new Date());
        return user;
    }
}
