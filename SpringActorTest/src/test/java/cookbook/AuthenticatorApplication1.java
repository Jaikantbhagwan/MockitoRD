

package cookbook;


public class AuthenticatorApplication1 {
    private AuthenticatorInterface1 authenticator1;

    /**
    * AuthenticatorApplication constructor.
    *
    * @param authenticator Authenticator interface implementation.
    */
    public AuthenticatorApplication1(AuthenticatorInterface1 authenticator1) {
        this.authenticator1 = authenticator1;
    }

    /**
    * Tries to authenticate an user with the received user name and password, with the ←-
    received
    * AuthenticatorInterface interface implementation in the constructor.
    *
    * @param username The user name to authenticate.
    * @param password The password to authenticate the user.
    * @throws NotAuthenticatedException If the user can’t be authenticated.
    */
    public void authenticate(String username, String password) throws NotAuthenticatedException {
        this.authenticator1.authenticateUser(username, password);
    }
}
