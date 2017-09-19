

package cookbook;


import static org.mockito.Mockito.doThrow;

import org.junit.Test;
import org.mockito.Mockito;


public class AuthenticatorApplicationTest2 {
    @Test(expected = NotAuthenticatedException.class)
    public void testAuthenticate() throws NotAuthenticatedException {
        AuthenticatorInterface1 authenticatorMock;
        AuthenticatorApplication1 authenticator;
        String username = "JavaCodeGeeks";
        String password = "wrong password";
        authenticatorMock = Mockito.mock(AuthenticatorInterface1.class);
        authenticator = new AuthenticatorApplication1(authenticatorMock);
        doThrow(new NotAuthenticatedException()).when(authenticatorMock).authenticateUser(username, password);
        authenticator.authenticate(username, password);
    }
}
