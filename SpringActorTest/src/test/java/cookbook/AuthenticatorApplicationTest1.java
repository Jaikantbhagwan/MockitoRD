

package cookbook;


import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class AuthenticatorApplicationTest1 {
    @Mock
    private AuthenticatorInterface authenticatorMock;
    @InjectMocks
    private AuthenticatorApplication authenticator;

    @Test
    public void testAuthenticateMockInjection() throws EmptyCredentialsException {
        String username = "javacodegeeks";
        String password = "s4f3 p4ssw0rd";
        when(this.authenticatorMock.authenticateUser(username, password)).thenReturn(true);
        boolean actual = this.authenticator.authenticate("javacodegeeks", "s4f3 p4ssw0rd");
        assertTrue(actual);
    }

}
