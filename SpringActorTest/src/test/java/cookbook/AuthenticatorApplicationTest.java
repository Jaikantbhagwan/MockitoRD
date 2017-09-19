

package cookbook;


import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;


public class AuthenticatorApplicationTest {


    public static final String username = "JavaCodeGeeks";
    public static final String password = "unsafePassword";

    AuthenticatorInterface authenticatorMock;
    AuthenticatorApplication authenticator;

    @Before
    public void setUp() {
        authenticatorMock = Mockito.mock(AuthenticatorInterface.class);
        authenticator = new AuthenticatorApplication(authenticatorMock);
    }

    @Test
    public void testAuthenticate() throws EmptyCredentialsException {

        when(authenticatorMock.authenticateUser(username, password)).thenReturn(false);
        boolean actual = authenticator.authenticate(username, password);
        assertFalse(actual);
        verify(authenticatorMock).authenticateUser(username, password);
        // fail scenario
        // verify(authenticatorMock).authenticateUser(username, "not the original password");

        verify(authenticatorMock, times(1)).authenticateUser(username, password);
        verify(authenticatorMock, atLeastOnce()).authenticateUser(username, password);
        verify(authenticatorMock, atLeast(1)).authenticateUser(username, password);
        verify(authenticatorMock, atMost(1)).authenticateUser(username, password);
        // fail scenario
        // verify(authenticatorMock, never()).authenticateUser(username, password); // This will make the test fail!


    }


    @Test
    public void inOrderTest() throws EmptyCredentialsException {
        when(authenticatorMock.authenticateUser(username, password)).thenReturn(false);
        boolean actual = authenticator.authenticate(username, password);

        InOrder inOrder = Mockito.inOrder(authenticatorMock);
        inOrder.verify(authenticatorMock).foo();
        inOrder.verify(authenticatorMock).authenticateUser(username, password);
        // Fail scenario
        // InOrder inOrder = inOrder(authenticatorMock);
        // inOrder.verify(authenticatorMock).authenticateUser(username, password); // This will make ←-
        // the test fail!
        // inOrder.verify(authenticatorMock).foo();

    }

    @Test
    public void timeOutTest() throws EmptyCredentialsException {
        when(authenticatorMock.authenticateUser(username, password)).thenReturn(false);
        boolean actual = authenticator.authenticate(username, password);
        verify(authenticatorMock, timeout(100)).authenticateUser(username, password);

        verify(authenticatorMock, timeout(100).times(1)).authenticateUser(username, password);
    }


    @Test(expected = EmptyCredentialsException.class)
    public void testAuthenticateEmptyCredentialsException() throws EmptyCredentialsException {
        when(authenticatorMock.authenticateUser("", "")).thenThrow(new EmptyCredentialsException());
        authenticator.authenticate("", "");
    }
}
